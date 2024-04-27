package com.ebson.skillserver.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomJobListener implements JobListener {

    private static final Logger logger = LoggerFactory.getLogger(CustomJobListener.class);

    @Override
    public String getName() {
        return "CustomJobListener";
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext context) {
        logger.info("This Job is about to be executed :: {}", context.getJobDetail().getKey().getName());
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {
        logger.info("This Job was vetoed and not executed :: {}", context.getJobDetail().getKey().getName());
    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        logger.info("This Job was executed :: {}", context.getJobDetail().getKey().getName());
        if (jobException != null) {
            logger.error("This Job threw an exception :: {}", jobException.getMessage());
        }
    }
}
