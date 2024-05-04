package com.ebson.skillserver.quartz.Job;

import com.ebson.skillserver.cache.builderRequest.BuilderRequestCacheService;
import com.ebson.skillserver.quartz.CustomJobListener;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
public class MyJob1 implements Job {

    private static final Logger logger = LoggerFactory.getLogger(MyJob1.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.info("MyJob1 executed ... ");
        logger.info("Myjob1 context.getJobDetail().getJobDataMap().get(\"key1\") :: {}", context.getJobDetail().getJobDataMap().get("key1"));
        logger.info("Myjob1 context.getJobDetail().getJobDataMap().get(\"key2\") :: {}", context.getJobDetail().getJobDataMap().get("key2"));
        try {
            ApplicationContext applicationContext = (ApplicationContext) context.getScheduler().getContext().get("applicationContext");
            BuilderRequestCacheService service = applicationContext.getBean(BuilderRequestCacheService.class);
            service.init();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }
}
