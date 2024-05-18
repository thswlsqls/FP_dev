package com.ebson.skillserver.batch.config;

import com.ebson.skillserver.batch.tasklet.MyTasklet;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class MyTaskletJobConfig {

    private static final Logger logger = LoggerFactory.getLogger(MyTaskletJobConfig.class);

    @Bean(name="myTaskletJob")
    public Job myTaskletJob(JobRepository jobRepository, Step myTaskletStep) {
        logger.info("MyTaskletJobConfig^^myTaskletJob :: started ... ");
        return new JobBuilder("myTaskletJob", jobRepository)
                .start(myTaskletStep)
                .build();
    }

    @Bean
    public Step myTaskletStep(PlatformTransactionManager platformTransactionManager, JobRepository jobRepository){
        logger.info("MyTaskletJobConfig^^myTaskletStep :: started ... ");
        return new StepBuilder("myTaskletStep", jobRepository)
                .tasklet(myTasklet(), platformTransactionManager).build();
    }
    @Bean
    public Tasklet myTasklet(){
        return new MyTasklet();
    }

}
