package com.ebson.skillserver.cache.builderRequest;

import com.ebson.skillserver.v1.channels.FP.domain.BuilderV1BlockDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BuilderV1BlockCacheServiceTest {

    @Autowired
    private BuilderV1BlockCacheService service;

    @Test
    @Transactional
    public void getBuilderV1BlockDomainCacheTest() {
        String channelName = "FP";
        String blockId = "6590ab5b193392115b5a7ff8";
        String blockCode = "FP_S01_B01";

        BuilderV1BlockDomain domain =  service.getBuilderV1BlockDomainCache(channelName, blockId, blockCode);
        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getBlockName(), "테스트 블록");
    }

    @Test
    @Transactional
    public void setBuilderV1BlockDomainCacheTest() {
        String channelName = "FP";
        String blockId = "6590ab5b193392115b5a7ff8";
        String blockCode = "FP_S01_B01";

        BuilderV1BlockDomain domain =  service.setBuilderV1BlockDomainCache(channelName, blockId, blockCode);
        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getBlockName(), "테스트 블록");
    }

    @Test
    public void deleteBuilderV1BlockDomainCacheTest() {
        String channelName = "FP";
        String blockId = "6590ab5b193392115b5a7ff8";
        String blockCode = "FP_S01_B01";
        service.deleteBuilderV1BlockDomainCache(channelName, blockId, blockCode);
    }

}
