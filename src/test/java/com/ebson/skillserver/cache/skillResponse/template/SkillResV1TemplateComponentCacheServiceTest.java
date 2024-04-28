package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateComponentDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SkillResV1TemplateComponentCacheServiceTest {

    @Autowired
    private SkillResV1TemplateComponentCacheService service;

    @Test
    @Transactional
    public void getSkillResV1TemplateComponentDomainCacheTest() {
        String componentId = UUIDFormatter.formatToUUID("72135D7EEDB711EEB5380A48BC1A5EE1");
        SkillResV1TemplateComponentDomain domain = service.getSkillResV1TemplateComponentDomainCache(componentId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getComponentName(), "테스트 컴포넌트(single simpleText)");
    }

    @Test
    @Transactional
    public void setSkillResV1TemplateComponentDomainCacheTest() {
        String componentId = UUIDFormatter.formatToUUID("72135D7EEDB711EEB5380A48BC1A5EE1");
        SkillResV1TemplateComponentDomain domain = service.setSkillResV1TemplateComponentDomainCache(componentId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getComponentName(), "테스트 컴포넌트(single simpleText)");
    }

    @Test
    public void deleteSkillResV1TemplateComponentDomainCacheTest() {
        String componentId = UUIDFormatter.formatToUUID("72135D7EEDB711EEB5380A48BC1A5EE1");
        service.deleteSkillResV1TemplateComponentDomainCache(componentId);
    }

}
