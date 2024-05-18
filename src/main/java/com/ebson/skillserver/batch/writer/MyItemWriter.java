package com.ebson.skillserver.batch.writer;

import com.ebson.skillserver.batch.processor.MyItemProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

public class MyItemWriter implements ItemWriter<String> {

    private static final Logger logger = LoggerFactory.getLogger(MyItemWriter.class);

    @Override
    public void write(Chunk<? extends String> chunk) throws Exception {
        logger.info("MyItemWriter^^write() :: started ... ");
    }
}
