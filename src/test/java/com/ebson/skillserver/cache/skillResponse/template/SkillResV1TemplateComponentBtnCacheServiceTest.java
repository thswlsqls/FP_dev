package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateComponentBtnDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SkillResV1TemplateComponentBtnCacheServiceTest {

    @Autowired
    private SkillResV1TemplateComponentBtnCacheService service;

    @Test
    @Transactional
    public void getSkillResV1TemplateComponentBtnDomainCacheTest() {
        String btnId = UUIDFormatter.formatToUUID("F7245E3CEDB711EEB5380A48BC1A5EE1");
        SkillResV1TemplateComponentBtnDomain domain = service.getSkillResV1TemplateComponentBtnDomainCache(btnId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getLabel(), "테스트 라벨(textCard)");
    }

    @Test
    @Transactional
    public void setSkillResV1TemplateComponentBtnDomainCacheTest() {
        String btnId = UUIDFormatter.formatToUUID("F7245E3CEDB711EEB5380A48BC1A5EE1");
        SkillResV1TemplateComponentBtnDomain domain = service.setSkillResV1TemplateComponentBtnDomainCache(btnId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getLabel(), "테스트 라벨(textCard)");
    }

    @Test
    public void deleteSkillResV1TemplateComponentBtnDomainCacheTest() {
        String btnId = UUIDFormatter.formatToUUID("F7245E3CEDB711EEB5380A48BC1A5EE1");
        service.deleteSkillResV1TemplateComponentBtnDomainCache(btnId);
    }

}
