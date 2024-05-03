package com.ebson.skillserver.cache.builderRequest;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1ChannelEntity;
import com.ebson.skillserver.v1.channels.FP.repository.BuilderV1ChannelEntityRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BuilderRequestCacheService {

    @Autowired
    private BuilderV1ChannelCacheService builderV1ChannelCacheService;

    @Autowired
    private BuilderV1ScenarioCacheService builderV1ScenarioCacheService;

    @Autowired
    private BuilderV1BlockCacheService builderV1BlockCacheService;

    @Autowired
    private BuilderV1BlockContextCacheService builderV1BlockContextCacheService;

    @PostConstruct
    public void initBuilderRequestCache() {
        builderV1ChannelCacheService.setAllBuilderV1ChannelDomainCache();
//        builderV1ScenarioCacheService.setAllBuilderV1ScenarioDomainCache();
//        builderV1BlockCacheService.setAllBuilderV1BlockDomainCache();
//        builderV1BlockContextCacheService.setAllBuilderV1BlockContextDomainCache();
    }

}
