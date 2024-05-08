package com.ebson.skillserver.cache.builderRequest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BuilderRequestCacheServiceTest {

    @Autowired
    private BuilderRequestCacheService service;

    @Test
    public void initTest() {
        service.init();
    }

    @Test
    public void initByQuartzJobTest() { service.initByQuartzJob(); }
}
