package com.ebson.skillserver.quartz.Job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class MyJob2 implements Job {

    private static final Logger logger = LoggerFactory.getLogger(MyJob2.class);

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private org.springframework.batch.core.Job myChunkJob; // bean name 으로 검색

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.info("MyJob2 executed ... ");
        logger.info("Myjob2 context.getJobDetail().getJobDataMap().get(\"key1\") :: {}", context.getJobDetail().getJobDataMap().get("key1"));
        logger.info("Myjob2 context.getJobDetail().getJobDataMap().get(\"key2\") :: {}", context.getJobDetail().getJobDataMap().get("key2"));

        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addString("param1", "this is my chunk job") // 문자열 파라미터 설정
                    .addLong("param2", System.currentTimeMillis()) // Long 형 파라미터 설정 (예: 현재 시간)
                    .addLocalDate("param3", LocalDate.now())
                    .toJobParameters();

            jobLauncher.run(myChunkJob, jobParameters);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
