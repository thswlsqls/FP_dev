package com.ebson.skillserver.cache.builderRequest;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.domain.BuilderV1ChannelDomain;
import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1ChannelEntity;
import com.ebson.skillserver.v1.channels.FP.repository.BuilderV1ChannelEntityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BuilderV1ChannelCacheServiceTest {

    @Autowired
    private BuilderV1ChannelCacheService service;

    @Autowired
    private BuilderV1ChannelEntityRepository repository;

    @Test
    @Transactional
    public void getBuilderV1ChannelDomainCacheTest() {
        String channelId = UUIDFormatter.formatToUUID("DA05F8D6EC3611EEB5380A48BC1A5EE1");
        BuilderV1ChannelDomain domain = service.getBuilderV1ChannelDomainCache(channelId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getChannelName(), "FP");
    }

    @Test
    @Transactional
    public void setBuilderV1ChannelDomainCacheTest() {
        List<BuilderV1ChannelEntity> list = repository.findAll();
        String channelId = UUIDFormatter.formatToUUID("DA05F8D6EC3611EEB5380A48BC1A5EE1");
        BuilderV1ChannelDomain domain = service.setBuilderV1ChannelDomainCache(channelId);

        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getChannelName(), "FP");
    }

    @Test
    public void deleteBuilderV1ChannelDomainCacheTest() {
        String channelId = UUIDFormatter.formatToUUID("DA05F8D6EC3611EEB5380A48BC1A5EE1");
        service.deleteBuilderV1ChannelDomainCache(channelId);
    }

}
