package com.ebson.skillserver.batch.config;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class MyTaskletJobConfig {

    private static final Logger logger = LoggerFactory.getLogger(MyTaskletJobConfig.class);

    @Bean(name="myJob")
    public Job myJob(JobRepository jobRepository, Step myStep) {
        logger.info("MyTaskletJob^^myJob :: started ... ");
        return new JobBuilder("myJob", jobRepository)
                .start(myStep)
                .build();
    }

    @Bean
    public Step myStep(PlatformTransactionManager platformTransactionManager, JobRepository jobRepository){
        logger.info("MyTaskletJob^^myStep :: started ... ");
        return new StepBuilder("myStep", jobRepository)
                .tasklet(myTasklet(), platformTransactionManager).build();
    }
    @Bean
    public Tasklet myTasklet(){
        logger.info("MyTaskletJob^^myTasklet :: started ... ");
        return ((contribution, chunkContext) -> {
            return RepeatStatus.FINISHED;
        });
    }

}
