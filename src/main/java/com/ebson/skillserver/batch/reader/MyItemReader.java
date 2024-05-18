package com.ebson.skillserver.batch.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class MyItemReader implements ItemReader<String> {

    private static final Logger logger = LoggerFactory.getLogger(MyItemReader.class);

    private String[] tokens = { "java", "spring", "springBoot", "Hibernate", "springBootBatch" };
    private int index = 0;

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        logger.info("MyItemReader^^read() :: started ... ");

        if (index >= tokens.length) {
            return null;
        }

        String item = index + " " + tokens[index];
        index++;

        logger.info("Reading item - {}" , item);
        return item;
    }
}
