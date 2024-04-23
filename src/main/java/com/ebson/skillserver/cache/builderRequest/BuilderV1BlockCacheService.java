package com.ebson.skillserver.cache.builderRequest;

import com.ebson.skillserver.v1.channels.FP.domain.BuilderV1BlockDomain;
import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1BlockEntity;
import com.ebson.skillserver.v1.channels.FP.repository.BuilderV1BlockEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BuilderV1BlockCacheService {

    private static final Logger logger = LoggerFactory.getLogger(BuilderV1BlockCacheService.class);

    @Autowired
    BuilderV1BlockEntityRepository repository;

    @Cacheable(value = "BuilderV1BlockDomain", key = "#channelName + ':' + #blockId + ':' + #blockCode")
    public BuilderV1BlockDomain getBuilderV1BlockDomainCache(String channelName, String blockId, String blockCode) {
        BuilderV1BlockEntity entity = repository.getReferenceById(blockId);
        BuilderV1BlockDomain domain = new BuilderV1BlockDomain();
        domain.setScenarioId(entity.getBuilderV1ScenarioEntity().getScenarioId());
        domain.setBlockId(entity.getBlockId());
        domain.setBlockCode(entity.getBlockCode());
        domain.setBlockName(entity.getBlockName());
        logger.info("getBuilderV1BlockDomainCache^^BuilderV1BlockDomain :: {}", domain.toString());
        return domain;
    }

    @CachePut(value = "BuilderV1BlockDomain", key = "#channelName + ':' + #blockId + ':' + #blockCode")
    public BuilderV1BlockDomain setBuilderV1BlockDomainCache(String channelName, String blockId, String blockCode) {
        BuilderV1BlockEntity entity = repository.getReferenceById(blockId);
        BuilderV1BlockDomain domain = new BuilderV1BlockDomain();
        domain.setScenarioId(entity.getBuilderV1ScenarioEntity().getScenarioId());
        domain.setBlockId(entity.getBlockId());
        domain.setBlockCode(entity.getBlockCode());
        domain.setBlockName(entity.getBlockName());
        logger.info("getBuilderV1BlockDomainCache^^BuilderV1BlockDomain :: {}", domain.toString());
        return domain;
    }

    @CacheEvict(value = "BuilderV1BlockDomain", key = "#channelName + ':' + #blockId + ':' + #blockCode")
    public void deleteBuilderV1BlockDomainCache(String channelName, String blockId, String blockCode) {}

}
