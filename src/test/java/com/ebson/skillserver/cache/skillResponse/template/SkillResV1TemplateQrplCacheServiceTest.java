package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateQrplDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SkillResV1TemplateQrplCacheServiceTest {

    @Autowired
    private SkillResV1TemplateQrplCacheService service;

    @Test
    @Transactional
    public void getSkillResV1TemplateQrplDomainCacheTest() {
        String qrplId = UUIDFormatter.formatToUUID("83A0159CEDB711EEB5380A48BC1A5EE1");
        SkillResV1TemplateQrplDomain domain = service.getSkillResV1TemplateQrplDomainCache(qrplId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getLabel(), "테스트 라벨(simpleText)");
    }

    @Test
    @Transactional
    public void setSkillResV1TemplateQrplDomainCacheTest() {
        String qrplId = UUIDFormatter.formatToUUID("83A0159CEDB711EEB5380A48BC1A5EE1");
        SkillResV1TemplateQrplDomain domain = service.setSkillResV1TemplateQrplDomainCache(qrplId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getLabel(), "테스트 라벨(simpleText)");
    }

    @Test
    public void deleteSkillResV1TemplateQrplDomainCacheTest() {
        String qrplId = UUIDFormatter.formatToUUID("83A0159CEDB711EEB5380A48BC1A5EE1");
        service.deleteSkillResV1TemplateQrplDomainCache(qrplId);
    }

}
