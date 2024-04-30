package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateListCardListItemExtraDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SkillResV1TemplateListCardListItemExtraCacheServiceTest {

    @Autowired
    private SkillResV1TemplateListCardListItemExtraCacheService service;

    @Test
    @Transactional
    public void getSkillResV1TemplateListCardListItemExtraDomainCacheTest() {
        String extraId = UUIDFormatter.formatToUUID("EA672B9A06EB11EFB5380A48BC1A5EE1");
        SkillResV1TemplateListCardListItemExtraDomain domain = service.getSkillResV1TemplateListCardListItemExtraDomainCache(extraId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getKey(), "test listitem extra key");
    }

    @Test
    @Transactional
    public void setSkillResV1TemplateListCardListItemExtraDomainCacheTest() {
        String extraId = UUIDFormatter.formatToUUID("EA672B9A06EB11EFB5380A48BC1A5EE1");
        SkillResV1TemplateListCardListItemExtraDomain domain = service.getSkillResV1TemplateListCardListItemExtraDomainCache(extraId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getKey(), "test listitem extra key");
    }

    @Test
    public void deleteSkillResV1TemplateListCardListItemExtraDomainCacheTest() {
        String extraId = UUIDFormatter.formatToUUID("EA672B9A06EB11EFB5380A48BC1A5EE1");
        service.deleteSkillResV1TemplateListCardListItemExtraDomainCache(extraId);
    }

}
