package com.ebson.skillserver.cache.skillResponse;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1VersionDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SkillResV1VersionCacheServiceTest {

    @Autowired
    private SkillResV1VersionCacheService service;

    @Test
    @Transactional
    public void getSkillResV1VersionDomainCacheTest() {
        String versionId = UUIDFormatter.formatToUUID("EC26D695038D11EFB5380A48BC1A5EE1");
        String blockCode = "FP_S01_B01";
        SkillResV1VersionDomain domain = service.getSkillResV1VersionDomainCache(versionId, blockCode);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getMajor(), 2);
        Assertions.assertEquals(domain.getMinor(), 0);
    }

    @Test
    @Transactional
    public void setSkillResV1VersionDomainCacheTest() {
        String versionId = UUIDFormatter.formatToUUID("EC26D695038D11EFB5380A48BC1A5EE1");
        String blockCode = "FP_S01_B01";
        SkillResV1VersionDomain domain = service.setSkillResV1VersionDomainCache(versionId, blockCode);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getMajor(), 2);
        Assertions.assertEquals(domain.getMinor(), 0);
    }

    @Test
    public void deleteSkillResV1VersionDomainCache() {
        String versionId = UUIDFormatter.formatToUUID("EC26D695038D11EFB5380A48BC1A5EE1");
        String blockCode = "FP_S01_B01";

        service.deleteSkillResV1VersionDomainCache(versionId, blockCode);
    }


}
