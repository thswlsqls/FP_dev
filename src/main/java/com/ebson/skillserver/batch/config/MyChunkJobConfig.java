package com.ebson.skillserver.batch.config;


import com.ebson.skillserver.batch.processor.MyItemProcessor;
import com.ebson.skillserver.batch.reader.MyItemReader;
import com.ebson.skillserver.batch.writer.MyItemWriter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class MyChunkJobConfig {

    private static final Logger logger = LoggerFactory.getLogger(MyChunkJobConfig.class);


    @Bean(name="myChunkJob")
    public Job myChunkJob(JobRepository jobRepository, Step myChunkStep) {
        logger.info("MyJobConfig^^myChunkJob :: started ... ");
        return new JobBuilder("myChunkJob", jobRepository)
                .start(myChunkStep)
                .build();
    }

    @Bean
    public Step myChunkStep(PlatformTransactionManager platformTransactionManager
                            , JobRepository jobRepository
                            , ItemReader myItemReader
                            , ItemProcessor myItemProcessor
                            , ItemWriter myItemWriter){
        logger.info("MyJobConfig^^myChunkStep :: started ... ");
        return new StepBuilder("myChunkStep", jobRepository)
                .<String, String>chunk(2, platformTransactionManager)
                .reader(myItemReader)
                .processor(myItemProcessor)
                .writer(myItemWriter)
                .build();
    }
    @Bean
    public ItemReader myItemReader(){
        return new MyItemReader();
    }

    @Bean
    public ItemProcessor myItemProcessor() {
        return new MyItemProcessor();
    }

    @Bean
    public ItemWriter myItemWriter() {
        return new MyItemWriter();
    }
}
