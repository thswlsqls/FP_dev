package com.ebson.skillserver.cache.skillResponse;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1DataDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SkillResV1DataCacheServiceTest {

    @Autowired
    private SkillResV1DataCacheService service;

    @Test
    @Transactional
    public void getSkillResV1DataDomainCache() {
        String dataId = UUIDFormatter.formatToUUID("4A972B25037511EFB5380A48BC1A5EE1");
        String blockCode = "FP_S01_B01";
        SkillResV1DataDomain domain = service.getSkillResV1DataDomainCache(dataId, blockCode);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getKey(), "test res data key");
        Assertions.assertEquals(domain.getValue(), "test res data value");
    }

    @Test
    @Transactional
    public void setSkillResV1DataDomainCache() {
        String dataId = UUIDFormatter.formatToUUID("4A972B25037511EFB5380A48BC1A5EE1");
        String blockCode = "FP_S01_B01";
        SkillResV1DataDomain domain = service.setSkillResV1DataDomainCache(dataId, blockCode);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getKey(), "test res data key");
        Assertions.assertEquals(domain.getValue(), "test res data value");
    }

    @Test
    public void deleteSkillResV1DataDomainCache() {
        String dataId = UUIDFormatter.formatToUUID("4A972B25037511EFB5380A48BC1A5EE1");
        String blockCode = "FP_S01_B01";

        service.deleteSkillResV1DataDomainCache(dataId, blockCode);
    }

}
