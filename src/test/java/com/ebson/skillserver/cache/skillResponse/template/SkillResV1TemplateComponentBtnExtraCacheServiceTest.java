package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateComponentBtnExtraDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SkillResV1TemplateComponentBtnExtraCacheServiceTest {

    @Autowired
    private SkillResV1TemplateComponentBtnExtraCacheService service;

    @Test
    @Transactional
    public void getSkillResV1TemplateComponentBtnExtraDomainCacheTest() {
        String extraId = UUIDFormatter.formatToUUID("E0015C09052911EFB5380A48BC1A5EE1");
        SkillResV1TemplateComponentBtnExtraDomain domain = service.getSkillResV1TemplateComponentBtnExtraDomainCache(extraId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getKey(), "test extra key");
    }

    @Test
    @Transactional
    public void setSkillResV1TemplateComponentBtnExtraDomainCacheTest() {
        String extraId = UUIDFormatter.formatToUUID("E0015C09052911EFB5380A48BC1A5EE1");
        SkillResV1TemplateComponentBtnExtraDomain domain = service.setSkillResV1TemplateComponentBtnExtraDomainCache(extraId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getKey(), "test extra key");
    }

    @Test
    public void deleteSkillResV1TemplateComponentBtnExtraDomainCacheTest() {
        String extraId = UUIDFormatter.formatToUUID("E0015C09052911EFB5380A48BC1A5EE1");
        service.deleteSkillResV1TemplateComponentBtnExtraDomainCache(extraId);
    }

}
