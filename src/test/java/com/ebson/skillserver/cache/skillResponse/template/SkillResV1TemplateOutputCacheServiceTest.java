package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateOutputDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SkillResV1TemplateOutputCacheServiceTest {

    @Autowired
    private SkillResV1TemplateOutputCacheService service;

    @Test
    @Transactional
    public void getSkillResV1TemplateOutputDomainCacheTest() {
        String outputId = UUIDFormatter.formatToUUID("6BDD5A89EDB711EEB5380A48BC1A5EE1");
        String templateId = UUIDFormatter.formatToUUID("4144051BEDB711EEB5380A48BC1A5EE1");
        SkillResV1TemplateOutputDomain domain = service.getSkillResV1TemplateOutputDomainCache(outputId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getOutputName(), "테스트 아웃풋(single simpleText)");
    }

    @Test
    @Transactional
    public void setSkillResV1TemplateOutputDomainCacheTest() {
        String outputId = UUIDFormatter.formatToUUID("6BDD5A89EDB711EEB5380A48BC1A5EE1");
        String templateId = UUIDFormatter.formatToUUID("4144051BEDB711EEB5380A48BC1A5EE1");
        SkillResV1TemplateOutputDomain domain = service.setSkillResV1TemplateOutputDomainCache(outputId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getOutputName(), "테스트 아웃풋(single simpleText)");
    }

    @Test
    public void deleteSkillResV1TemplateOutputDomainCache() {
        String outputId = UUIDFormatter.formatToUUID("6BDD5A89EDB711EEB5380A48BC1A5EE1");
        String templateId = UUIDFormatter.formatToUUID("4144051BEDB711EEB5380A48BC1A5EE1");
        service.deleteSkillResV1TemplateOutputDomainCache(outputId);
    }

}
