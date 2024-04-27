package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateBasicCardDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SkillResV1TemplateBasicCardCacheServiceTest {

    @Autowired
    private SkillResV1TemplateBasicCardCacheService service;

    @Test
    @Transactional
    public void getSkillResV1TemplateBasicCardDomainCacheTest() {
        String componentId = UUIDFormatter.formatToUUID("2AAF4950EDC711EEB5380A48BC1A5EE1");
        SkillResV1TemplateBasicCardDomain domain = service.getSkillResV1TemplateBasicCardDomainCache(componentId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getTitle(), "테스트 타이틀");
    }

    @Test
    @Transactional
    public void setSkillResV1TemplateBasicCardDomainCacheTest() {
        String componentId = UUIDFormatter.formatToUUID("2AAF4950EDC711EEB5380A48BC1A5EE1");
        SkillResV1TemplateBasicCardDomain domain = service.setSkillResV1TemplateBasicCardDomainCache(componentId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getTitle(), "테스트 타이틀");
    }

    @Test
    public void deleteSkillResV1TemplateBasicCardDomainCacheTest() {
        String componentId = UUIDFormatter.formatToUUID("2AAF4950EDC711EEB5380A48BC1A5EE1");
        service.deleteSkillResV1TemplateBasicCardDomainCache(componentId);
    }

}
