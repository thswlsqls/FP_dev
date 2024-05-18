package com.ebson.skillserver.batch.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.ArrayList;
import java.util.List;

public class MyItemReader implements ItemReader<String> {

    private static final Logger logger = LoggerFactory.getLogger(MyItemReader.class);

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        logger.info("MyItemReader^^read() :: started ... ");
        return null;
    }
}
