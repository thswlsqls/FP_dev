package com.ebson.skillserver.cache.skillResponse;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1ContextParamDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SkillResV1ContextParamCacheServiceTest {

    @Autowired
    private SkillResV1ContextParamCacheService service;

    @Test
    @Transactional
    public void getSkillResV1ContextParamDomainCacheTest() {
        String contextId = UUIDFormatter.formatToUUID("0334AEA5F95111EEB5380A48BC1A5EE1");
        int paramNo = 1;
        SkillResV1ContextParamDomain domain = service.getSkillResV1ContextParamDomainCache(contextId, paramNo);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getKey(), "context param test key");
        Assertions.assertEquals(domain.getValue(), "context param test value");
    }

    @Test
    @Transactional
    public void setSkillResV1ContextParamDomainCacheTest() {
        String contextId = UUIDFormatter.formatToUUID("0334AEA5F95111EEB5380A48BC1A5EE1");
        int paramNo = 1;
        SkillResV1ContextParamDomain domain = service.setSkillResV1ContextParamDomainCache(contextId, paramNo);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getKey(), "context param test key");
        Assertions.assertEquals(domain.getValue(), "context param test value");
    }

    @Test
    public void deleteSkillResV1ContextParamDomainCacheTest() {
        String contextId = UUIDFormatter.formatToUUID("0334AEA5F95111EEB5380A48BC1A5EE1");
        int paramNo = 1;

        service.deleteSkillResV1ContextParamDomainCache(contextId, paramNo);
    }

}
