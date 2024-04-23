package com.ebson.skillserver.cache.builderRequest;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.domain.BuilderV1BlockContextDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BuilderV1BlockContextCacheServiceTest {

    @Autowired
    private BuilderV1BlockContextCacheService service;

    @Test
    @Transactional
    public void getBuilderV1BlockContextDomainCacheTest() {
        String blockCode = "FP_S01_B01";
        String contextId = UUIDFormatter.formatToUUID("0334AEA5F95111EEB5380A48BC1A5EE1");

        BuilderV1BlockContextDomain domain = service.getBuilderV1BlockContextDomainCache(blockCode, contextId);
        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getContextName(), "S01_B01_테스트콘텍스트");
    }

    @Test
    @Transactional
    public void setBuilderV1BlockContextDomainCacheTest() {
        String blockCode = "FP_S01_B01";
        String contextId = UUIDFormatter.formatToUUID("0334AEA5F95111EEB5380A48BC1A5EE1");

        BuilderV1BlockContextDomain domain = service.setBuilderV1BlockContextDomainCache(blockCode, contextId);
        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getContextName(), "S01_B01_테스트콘텍스트");
    }

    @Test
    public void deleteBuilderV1BlockContextDomainCacheTest(){
        String blockCode = "FP_S01_B01";
        String contextId = UUIDFormatter.formatToUUID("0334AEA5F95111EEB5380A48BC1A5EE1");
        service.deleteBuilderV1BlockContextDomainCache(blockCode, contextId);
    }

}
