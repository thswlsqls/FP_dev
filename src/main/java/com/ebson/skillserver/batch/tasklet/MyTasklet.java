package com.ebson.skillserver.batch.tasklet;

import com.ebson.skillserver.batch.config.MyTaskletJobConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

// @Component
public class MyTasklet implements Tasklet {

    private static final Logger logger = LoggerFactory.getLogger(MyTasklet.class);

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        logger.info("MyTasklet is executed ... ");
        return RepeatStatus.FINISHED;
    }
}
