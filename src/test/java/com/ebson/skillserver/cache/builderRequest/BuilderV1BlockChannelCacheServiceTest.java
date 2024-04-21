package com.ebson.skillserver.cache.builderRequest;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.domain.BuilderV1ChannelDomain;
import com.ebson.skillserver.v1.channels.FP.repository.BuilderV1ChannelEntityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BuilderV1BlockChannelCacheServiceTest {

    @Autowired
    private BuilderV1ChannelCacheService service;

    @Autowired
    private BuilderV1ChannelEntityRepository repository;

    @Test
    @Transactional
    public void getBuilderV1ChannelDomainCacheByIdAndNameTest() {
        String channelId = UUIDFormatter.formatToUUID("DA05F8D6EC3611EEB5380A48BC1A5EE1");
        BuilderV1ChannelDomain domain = service.getBuilderV1ChannelDomainCache(channelId, "FP");

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getChannelName(), "FP");
    }

    @Test
    @Transactional
    public void setBuilderV1ChannelDomainCacheByIdAndNameTest() {
        String channelId = UUIDFormatter.formatToUUID("DA05F8D6EC3611EEB5380A48BC1A5EE1");
        BuilderV1ChannelDomain domain = service.setBuilderV1ChannelDomainCache(channelId, "FP");

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getChannelName(), "FP");
    }

    @Test
    @Transactional
    public void deleteBuilderV1ChannelDomainCacheByIdAndNameTest() {
        String channelId = UUIDFormatter.formatToUUID("DA05F8D6EC3611EEB5380A48BC1A5EE1");
        service.deleteBuilderV1ChannelDomainCache(channelId, "FP");
    }


}
