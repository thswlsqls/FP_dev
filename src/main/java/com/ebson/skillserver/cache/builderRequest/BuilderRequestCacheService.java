package com.ebson.skillserver.cache.builderRequest;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        builderV1ScenarioCacheService.setAllBuilderV1ScenarioDomainCache();
        builderV1BlockCacheService.setAllBuilderV1BlockDomainCache();
        builderV1BlockContextCacheService.setAllBuilderV1BlockContextDomainCache();
    }

}
