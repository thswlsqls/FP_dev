package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateListCardListItemDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SkillResV1TemplateListCardListItemCacheServiceTest {

    @Autowired
    private SkillResV1TemplateListCardListItemCacheService service;

    @Test
    @Transactional
    public void getSkillResV1TemplateListCardListItemDomainCacheTest() {
        String listitemId = UUIDFormatter.formatToUUID("1B2C10B5F3D811EEB5380A48BC1A5EE1");
        SkillResV1TemplateListCardListItemDomain domain = service.getSkillResV1TemplateListCardListItemDomainCache(listitemId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getDesc(), "테스트 설명입니다.(carousel > listCard > 1)");
    }

    @Test
    @Transactional
    public void setSkillResV1TemplateListCardListItemDomainCacheTest() {
        String listitemId = UUIDFormatter.formatToUUID("1B2C10B5F3D811EEB5380A48BC1A5EE1");
        SkillResV1TemplateListCardListItemDomain domain = service.setSkillResV1TemplateListCardListItemDomainCache(listitemId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getDesc(), "테스트 설명입니다.(carousel > listCard > 1)");
    }

    @Test
    public void deleteSkillResV1TemplateListCardListItemDomainCacheTest() {
        String listitemId = UUIDFormatter.formatToUUID("1B2C10B5F3D811EEB5380A48BC1A5EE1");
        service.deleteSkillResV1TemplateListCardListItemDomainCache(listitemId);
    }

}
