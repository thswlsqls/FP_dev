package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateItemCardDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SkillResV1TemplateItemCardCacheServiceTest {

    @Autowired
    private SkillResV1TemplateItemCardCacheService service;

    @Test
    @Transactional
    public void getSkillResV1TemplateItemCardDomainCacheTest() {
        String componentId = UUIDFormatter.formatToUUID("18488D0CEF0B11EEB5380A48BC1A5EE1");
        SkillResV1TemplateItemCardDomain domain = service.getSkillResV1TemplateItemCardDomainCache(componentId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getThumbImgUrl(), "http://localhost:8080/resources/img/test.jpg");
    }

    @Test
    @Transactional
    public void setSkillResV1TemplateItemCardDomainCacheTest() {
        String componentId = UUIDFormatter.formatToUUID("18488D0CEF0B11EEB5380A48BC1A5EE1");
        SkillResV1TemplateItemCardDomain domain = service.setSkillResV1TemplateItemCardDomainCache(componentId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getThumbImgUrl(), "http://localhost:8080/resources/img/test.jpg");
    }

    @Test
    public void deleteSkillResV1TemplateItemCardDomainCacheTest() {
        String componentId = UUIDFormatter.formatToUUID("18488D0CEF0B11EEB5380A48BC1A5EE1");
        service.deleteSkillResV1TemplateItemCardDomainCache(componentId);
    }

}
