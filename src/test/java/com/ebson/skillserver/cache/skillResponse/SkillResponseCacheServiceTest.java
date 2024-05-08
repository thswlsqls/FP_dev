package com.ebson.skillserver.cache.skillResponse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SkillResponseCacheServiceTest {

    @Autowired
    private SkillResponseCacheService service;

    @Test
    public void initTest() {
        service.init();
    }

}
