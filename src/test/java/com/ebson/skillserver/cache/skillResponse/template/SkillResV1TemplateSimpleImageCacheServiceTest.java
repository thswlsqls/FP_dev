package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateSimpleImageDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SkillResV1TemplateSimpleImageCacheServiceTest {

    @Autowired
    private SkillResV1TemplateSimpleImageCacheService service;

    @Test
    @Transactional
    public void getSkillResV1TemplateSimpleImageDomainCacheTest() {
        String componentId = UUIDFormatter.formatToUUID("AEBA568FEDB711EEB5380A48BC1A5EE1");
        SkillResV1TemplateSimpleImageDomain domain = service.getSkillResV1TemplateSimpleImageDomainCache(componentId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getAltText(), "대체 텍스트 입니다.");
    }

    @Test
    @Transactional
    public void setSkillResV1TemplateSimpleImageDomainCacheTest() {
        String componentId = UUIDFormatter.formatToUUID("AEBA568FEDB711EEB5380A48BC1A5EE1");
        SkillResV1TemplateSimpleImageDomain domain = service.setSkillResV1TemplateSimpleImageDomainCache(componentId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getAltText(), "대체 텍스트 입니다.");
    }

    @Test
    public void deleteSkillResV1TemplateSimpleImageDomainCacheTest() {
        String componentId = UUIDFormatter.formatToUUID("AEBA568FEDB711EEB5380A48BC1A5EE1");
        service.deleteSkillResV1TemplateSimpleImageDomainCache(componentId);
    }

}
