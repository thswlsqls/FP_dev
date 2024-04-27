package com.ebson.skillserver.quartz.Job;

import com.ebson.skillserver.quartz.CustomJobListener;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyJob1 implements Job {

    private static final Logger logger = LoggerFactory.getLogger(MyJob1.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.info("MyJob1 executed ... ");
        logger.info("Myjob1 context.getJobDetail().getJobDataMap().get(\"key1\") :: {}", context.getJobDetail().getJobDataMap().get("key1"));
        logger.info("Myjob1 context.getJobDetail().getJobDataMap().get(\"key2\") :: {}", context.getJobDetail().getJobDataMap().get("key2"));
    }
}
