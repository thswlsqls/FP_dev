package com.ebson.skillserver.config;

import com.ebson.skillserver.quartz.CustomJobListener;
import com.ebson.skillserver.quartz.CustomTriggerListener;
import com.ebson.skillserver.quartz.Job.MyJob1;
import com.ebson.skillserver.quartz.Job.MyJob2;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
public class QuartzSchedulerConfig {

    @Autowired
    CustomJobListener customJobListener;

    @Autowired
    CustomTriggerListener customTriggerListener;

    @Bean
    public JobDetail jobDetail1() {
        return JobBuilder.newJob(MyJob1.class)
                .withIdentity("myJob1", "group1")
                .usingJobData("key1", "value1")
                .usingJobData("key2", "value2")
                .build();
    }

    @Bean
    public JobDetail jobDetail2() {
        return JobBuilder.newJob(MyJob2.class)
                .withIdentity("myJob2", "group1")
                .usingJobData("key1", "value1")
                .usingJobData("key2", "value2")
                .build();
    }

    @Bean
    public CronTrigger cronTrigger1() {
        return TriggerBuilder
                .newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * * * ?"))
                .forJob("myJob1", "group1")
                .build();
    }

    @Bean
    public CronTrigger cronTrigger2() {
        return TriggerBuilder
                .newTrigger()
                .withIdentity("trigger2", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * * * ?"))
                .forJob("myJob2", "group1")
                .build();
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setGlobalJobListeners(customJobListener);
        schedulerFactoryBean.setGlobalTriggerListeners(customTriggerListener);

        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("quartz.properties"));
        propertiesFactoryBean.afterPropertiesSet();
        schedulerFactoryBean.setQuartzProperties(propertiesFactoryBean.getObject());

        schedulerFactoryBean.setTriggers(cronTrigger1()
                                        , cronTrigger2());

        return schedulerFactoryBean;
    }

}
