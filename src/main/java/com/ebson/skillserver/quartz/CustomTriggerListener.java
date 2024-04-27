package com.ebson.skillserver.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomTriggerListener implements TriggerListener {

    private static final Logger logger = LoggerFactory.getLogger(CustomJobListener.class);

    @Override
    public String getName() {
        return "CustomTriggerListener";
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext context) {
        logger.info("Trigger {} fired for job {}", trigger.getKey().getName(), context.getJobDetail().getKey().getName());
    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
        logger.info("Trigger {} is vetoing job execution for job {}", trigger.getKey().getName(), context.getJobDetail().getKey().getName());
        return false;
    }

    @Override
    public void triggerMisfired(Trigger trigger) {
        logger.warn("Trigger {} misfired", trigger.getKey().getName());
    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext context, Trigger.CompletedExecutionInstruction triggerInstructionCode) {
        logger.info("Trigger {} completed for job {}", trigger.getKey().getName(), context.getJobDetail().getKey().getName());
    }
}
