package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateTextCardDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SkillResV1TemplateTextCardCacheServiceTest {

    @Autowired
    private SkillResV1TemplateTextCardCacheService service;

    @Test
    @Transactional
    public void getSkillResV1TemplateTextCardDomainCacheTest() {
        String componentId = UUIDFormatter.formatToUUID("DE4C1D59EDB711EEB5380A48BC1A5EE1");
        SkillResV1TemplateTextCardDomain domain = service.getSkillResV1TemplateTextCardDomainCache(componentId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getTitle(), "테스트 타이틀");
    }

    @Test
    @Transactional
    public void setSkillResV1TemplateTextCardDomainCacheTest() {
        String componentId = UUIDFormatter.formatToUUID("DE4C1D59EDB711EEB5380A48BC1A5EE1");
        SkillResV1TemplateTextCardDomain domain = service.setSkillResV1TemplateTextCardDomainCache(componentId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getTitle(), "테스트 타이틀");
    }

    @Test
    public void deleteSkillResV1TemplateTextCardDomainCacheTest() {
        String componentId = UUIDFormatter.formatToUUID("DE4C1D59EDB711EEB5380A48BC1A5EE1");
        service.deleteSkillResV1TemplateTextCardDomainCache(componentId);
    }

}
