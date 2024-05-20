package com.ebson.skillserver.quartz.Job;

import com.ebson.skillserver.cache.builderRequest.BuilderRequestCacheService;
import com.ebson.skillserver.quartz.CustomJobListener;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MyJob1 implements Job {

    private static final Logger logger = LoggerFactory.getLogger(MyJob1.class);

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private org.springframework.batch.core.Job myTaskletJob; // bean name 으로 검색

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.info("MyJob1 executed ... ");
        logger.info("Myjob1 context.getJobDetail().getJobDataMap().get(\"key1\") :: {}", context.getJobDetail().getJobDataMap().get("key1"));
        logger.info("Myjob1 context.getJobDetail().getJobDataMap().get(\"key2\") :: {}", context.getJobDetail().getJobDataMap().get("key2"));

        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addString("param1", "this is my tasklet job") // 문자열 파라미터 설정
                    .addLong("param2", System.currentTimeMillis()) // Long 형 파라미터 설정 (예: 현재 시간)
                    .addLocalDate("param3", LocalDate.now()) // 유니크한 파라미터 값을 부여
                    .toJobParameters();

            jobLauncher.run(myTaskletJob, jobParameters);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
