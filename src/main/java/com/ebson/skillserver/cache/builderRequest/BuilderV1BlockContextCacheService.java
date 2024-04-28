package com.ebson.skillserver.cache.builderRequest;

import com.ebson.skillserver.v1.channels.FP.domain.BuilderV1BlockContextDomain;
import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1BlockContextEntity;
import com.ebson.skillserver.v1.channels.FP.repository.BuilderV1BlockContextEntityRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BuilderV1BlockContextCacheService {

    private static final Logger logger = LoggerFactory.getLogger(BuilderV1BlockContextCacheService.class);

    @Autowired
    BuilderV1BlockContextEntityRepository repository;

    @Cacheable(value = "BuilderV1BlockContextDomain", key = "#blockCode + ':' + #contextId"  )
    public BuilderV1BlockContextDomain getBuilderV1BlockContextDomainCache(String blockCode, String contextId) {
        BuilderV1BlockContextEntity entity = repository.getReferenceById(UUID.fromString(contextId));
        BuilderV1BlockContextDomain domain = new BuilderV1BlockContextDomain();
        domain.setContextId(entity.getContextId());
        domain.setContextName(entity.getContextName());
        domain.setBlockCode(entity.getBlockCode());
        domain.setContextType(entity.getContextType());
        domain.setBlockId(entity.getBuilderV1BlockEntity().getBlockId());
        logger.info("getBuilderV1BlockContextDomainCache^^BuilderV1BlockContextDomain :: {}", domain.toString());
        return domain;
    }

    @CachePut(value = "BuilderV1BlockContextDomain", key = "#blockCode + ':' + #contextId"  )
    public BuilderV1BlockContextDomain setBuilderV1BlockContextDomainCache(String blockCode, String contextId) {
        BuilderV1BlockContextEntity entity = repository.getReferenceById(UUID.fromString(contextId));
        BuilderV1BlockContextDomain domain = new BuilderV1BlockContextDomain();
        domain.setContextId(entity.getContextId());
        domain.setContextName(entity.getContextName());
        domain.setBlockCode(entity.getBlockCode());
        domain.setContextType(entity.getContextType());
        domain.setBlockId(entity.getBuilderV1BlockEntity().getBlockId());
        logger.info("setBuilderV1BlockContextDomainCache^^BuilderV1BlockContextDomain :: {}", domain.toString());
        return domain;
    }

    @CacheEvict(value = "BuilderV1BlockContextDomain", key = "#blockCode + ':' + #contextId"  )
    public void deleteBuilderV1BlockContextDomainCache(String blockCode, String contextId) {
        logger.info("BuilderV1BlockContextDomain Cache is deleted ... blockCode : {}, contextId : {}", blockCode, contextId);
    }

}
