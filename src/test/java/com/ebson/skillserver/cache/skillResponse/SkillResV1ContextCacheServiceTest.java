package com.ebson.skillserver.cache.skillResponse;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1ContextDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SkillResV1ContextCacheServiceTest {

    @Autowired
    private SkillResV1ContextCacheService service;

    @Test
    @Transactional
    public void getSkillResV1ContextDomainCacheTest() {
        String blockCode = "FP_S01_B01";
        String contextId = UUIDFormatter.formatToUUID("0334AEA5F95111EEB5380A48BC1A5EE1");
        String contextName = "S01_B01_테스트콘텍스트";

        SkillResV1ContextDomain domain = service.getSkillResV1ContextDomainCache(contextId);
        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getContextName(), "S01_B01_테스트콘텍스트");
    }

    @Test
    @Transactional
    public void setSkillResV1ContextDomainCacheTest() {
        String blockCode = "FP_S01_B01";
        String contextId = UUIDFormatter.formatToUUID("0334AEA5F95111EEB5380A48BC1A5EE1");
        String contextName = "S01_B01_테스트콘텍스트";

        SkillResV1ContextDomain domain = service.setSkillResV1ContextDomainCache(contextId);
        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getContextName(), "S01_B01_테스트콘텍스트");
    }

    @Test
    public void deleteSkillResV1ContextDomainCache() {
        String blockCode = "FP_S01_B01";
        String contextId = UUIDFormatter.formatToUUID("0334AEA5F95111EEB5380A48BC1A5EE1");
        String contextName = "S01_B01_테스트콘텍스트";

        service.deleteSkillResV1ContextDomainCache(contextId);
    }
}
