package com.ebson.skillserver.cache.builderRequest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BuilderRequestCacheServiceTest {

    @Autowired
    BuilderRequestCacheService service;

    @Test
    public void initBuilderRequestCacheTest() {
        service.initBuilderRequestCache();
    }


}
