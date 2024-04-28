package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateCarouselDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SkillResV1TemplateCarouselCacheServiceTest {

    @Autowired
    private SkillResV1TemplateCarouselCacheService service;

    @Test
    @Transactional
    public void getSkillResV1TemplateCarouselDomainCacheTest() {
        String carouselId = UUIDFormatter.formatToUUID("F19C7476EF2511EEB5380A48BC1A5EE1");
        SkillResV1TemplateCarouselDomain domain = service.getSkillResV1TemplateCarouselDomainCache(carouselId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getCardType(), "textCard");
    }

    @Test
    @Transactional
    public void setSkillResV1TemplateCarouselDomainCacheTest() {
        String carouselId = UUIDFormatter.formatToUUID("F19C7476EF2511EEB5380A48BC1A5EE1");
        SkillResV1TemplateCarouselDomain domain = service.getSkillResV1TemplateCarouselDomainCache(carouselId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getCardType(), "textCard");
    }

    @Test
    public void deleteSkillResV1TemplateCarouselDomainCacheTest() {
        String carouselId = UUIDFormatter.formatToUUID("F19C7476EF2511EEB5380A48BC1A5EE1");
        service.deleteSkillResV1TemplateCarouselDomainCache(carouselId);
    }
}
