package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateListCardDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SkillResV1TemplateListCardCacheServiceTest {

    @Autowired
    private SkillResV1TemplateListCardCacheService service;

    @Test
    @Transactional
    public void getSkillResV1TemplateListCardDomainCache() {
        String componentId = UUIDFormatter.formatToUUID("0F75ACACF3D711EEB5380A48BC1A5EE1");
        SkillResV1TemplateListCardDomain domain = service.getSkillResV1TemplateListCardDomainCache(componentId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getCardOrd(), 2);
        Assertions.assertEquals(domain.getCarouselId().toString().toUpperCase(), UUIDFormatter.formatToUUID("61A1C408F3D711EEB5380A48BC1A5EE1"));
    }

    @Test
    @Transactional
    public void setSkillResV1TemplateListCardDomainCache() {
        String componentId = UUIDFormatter.formatToUUID("0F75ACACF3D711EEB5380A48BC1A5EE1");
        SkillResV1TemplateListCardDomain domain = service.setSkillResV1TemplateListCardDomainCache(componentId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getCardOrd(), 2);
        Assertions.assertEquals(domain.getCarouselId().toString().toUpperCase(), UUIDFormatter.formatToUUID("61A1C408F3D711EEB5380A48BC1A5EE1").toUpperCase());
    }

    @Test
    public void deleteSkillResV1TemplateListCardDomainCache() {
        String componentId = UUIDFormatter.formatToUUID("0F75ACACF3D711EEB5380A48BC1A5EE1");
        service.deleteSkillResV1TemplateListCardDomainCache(componentId);
    }

}
