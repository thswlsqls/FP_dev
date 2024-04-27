package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateSimpleTextDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SkillResV1TemplateSimpleTextCacheServiceTest {

    @Autowired
    private SkillResV1TemplateSimpleTextCacheService service;

    @Test
    @Transactional
    public void getSkillResV1TemplateSimpleTextDomainCacheTest() {
        String componentId = UUIDFormatter.formatToUUID("72135D7EEDB711EEB5380A48BC1A5EE1");
        SkillResV1TemplateSimpleTextDomain domain = service.getSkillResV1TemplateSimpleTextDomainCache(componentId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getText(), "테스트 텍스트 입니다.");
    }

    @Test
    @Transactional
    public void gstSkillResV1TemplateSimpleTextDomainCacheTest() {
        String componentId = UUIDFormatter.formatToUUID("72135D7EEDB711EEB5380A48BC1A5EE1");
        SkillResV1TemplateSimpleTextDomain domain = service.setSkillResV1TemplateSimpleTextDomainCache(componentId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getText(), "테스트 텍스트 입니다.");
    }

    @Test
    public void deleteSkillResV1TemplateSimpleTextDomainCacheTest() {
        String componentId = UUIDFormatter.formatToUUID("72135D7EEDB711EEB5380A48BC1A5EE1");
        service.deleteSkillResV1TemplateSimpleTextDomainCache(componentId);
    }

}
