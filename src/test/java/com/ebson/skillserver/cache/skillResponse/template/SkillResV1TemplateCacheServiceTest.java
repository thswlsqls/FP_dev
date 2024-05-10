package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SkillResV1TemplateCacheServiceTest {

    @Autowired
    private SkillResV1TemplateCacheService service;

    @Test
    @Transactional
    public void getSkillResV1TemplateDomainCacheTest() {
        String templateId = UUIDFormatter.formatToUUID("4144051BEDB711EEB5380A48BC1A5EE1");
        SkillResV1TemplateDomain domain = service.getSkillResV1TemplateDomainCache(templateId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getTemplateName(), "테스트 템플릿(single simpleText)");
    }

    @Test
    @Transactional
    public void setSkillResV1TemplateDomainCacheTest() {
        String templateId = UUIDFormatter.formatToUUID("4144051BEDB711EEB5380A48BC1A5EE1");
        SkillResV1TemplateDomain domain = service.setSkillResV1TemplateDomainCache(templateId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getTemplateName(), "테스트 템플릿(single simpleText)");
    }

    @Test
    public void deleteSkillResV1TemplateDomainCacheTest() {
        String templateId = UUIDFormatter.formatToUUID("4144051BEDB711EEB5380A48BC1A5EE1");
        service.deleteSkillResV1TemplateDomainCache(templateId);
    }

}
