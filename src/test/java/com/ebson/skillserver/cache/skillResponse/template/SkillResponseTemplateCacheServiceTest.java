package com.ebson.skillserver.cache.skillResponse.template;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SkillResponseTemplateCacheServiceTest {

    @Autowired
    private SkillResponseTemplateCacheService service;

    @Test
    public void initTest() {
        service.init1();
        service.init2();
        service.init3();
        service.init4();
    }

}
