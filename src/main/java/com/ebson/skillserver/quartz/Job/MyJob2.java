package com.ebson.skillserver.quartz.Job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyJob2 implements Job {

    private static final Logger logger = LoggerFactory.getLogger(MyJob2.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.info("MyJob2 executed ... ");
        logger.info("Myjob2 context.getJobDetail().getJobDataMap().get(\"key1\") :: {}", context.getJobDetail().getJobDataMap().get("key1"));
        logger.info("Myjob2 context.getJobDetail().getJobDataMap().get(\"key2\") :: {}", context.getJobDetail().getJobDataMap().get("key2"));
    }
}
