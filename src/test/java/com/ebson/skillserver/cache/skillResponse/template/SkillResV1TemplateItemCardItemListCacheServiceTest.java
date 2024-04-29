package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateItemCardItemListDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SkillResV1TemplateItemCardItemListCacheServiceTest {

    @Autowired
    private SkillResV1TemplateItemCardItemListCacheService service;

    @Test
    @Transactional
    public void getSkillResV1TemplateItemCardItemListDomainCacheTest() {
        String itemlistId = UUIDFormatter.formatToUUID("6FB4F2FAEF0C11EEB5380A48BC1A5EE1");
        SkillResV1TemplateItemCardItemListDomain domain = service.getSkillResV1TemplateItemCardItemListDomainCache(itemlistId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getDesc(), "테스트 설명입니다.");
    }

    @Test
    @Transactional
    public void setSkillResV1TemplateItemCardItemListDomainCacheTest() {
        String itemlistId = UUIDFormatter.formatToUUID("6FB4F2FAEF0C11EEB5380A48BC1A5EE1");
        SkillResV1TemplateItemCardItemListDomain domain = service.setSkillResV1TemplateItemCardItemListDomainCache(itemlistId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getDesc(), "테스트 설명입니다.");
    }

    @Test
    public void deleteSkillResV1TemplateItemCardItemListDomainCacheTest() {
        String itemlistId = UUIDFormatter.formatToUUID("6FB4F2FAEF0C11EEB5380A48BC1A5EE1");
        service.deleteSkillResV1TemplateItemCardItemListDomainCache(itemlistId);

    }

}
