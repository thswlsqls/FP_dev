package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateQrplExtraDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SkillResV1TemplateQrplExtraCacheServiceTest {

    @Autowired
    private SkillResV1TemplateQrplExtraCacheService service;

    @Test
    @Transactional
    public void getSkillResV1TemplateQrplExtraDomainCacheTest() {
        String extraId = UUIDFormatter.formatToUUID("4462F1BC055711EFB5380A48BC1A5EE1");
        SkillResV1TemplateQrplExtraDomain domain = service.getSkillResV1TemplateQrplExtraDomainCache(extraId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getKey(), "test qrpl extra key");
    }

    @Test
    @Transactional
    public void setSkillResV1TemplateQrplExtraDomainCacheTest() {
        String extraId = UUIDFormatter.formatToUUID("4462F1BC055711EFB5380A48BC1A5EE1");
        SkillResV1TemplateQrplExtraDomain domain = service.setSkillResV1TemplateQrplExtraDomainCache(extraId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getKey(), "test qrpl extra key");
    }

    @Test
    public void deleteSkillResV1TemplateQrplExtraDomainCacheTest() {
        String extraId = UUIDFormatter.formatToUUID("4462F1BC055711EFB5380A48BC1A5EE1");
        service.deleteSkillResV1TemplateQrplExtraDomainCache(extraId);
    }

}
