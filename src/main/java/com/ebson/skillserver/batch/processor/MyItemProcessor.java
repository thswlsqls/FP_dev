package com.ebson.skillserver.batch.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class MyItemProcessor implements ItemProcessor<String, String> {

    private static final Logger logger = LoggerFactory.getLogger(MyItemProcessor.class);


    @Override
    public String process(String item) throws Exception {
        logger.info("MyItemProcessor^^process() :: started ... ");

        item = item.toUpperCase();

        logger.info("Processed item - {}" , item);
        return item;
    }
}
