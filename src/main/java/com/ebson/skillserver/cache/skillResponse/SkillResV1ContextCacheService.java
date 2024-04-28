package com.ebson.skillserver.cache.skillResponse;

import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1ContextDomain;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1ContextEntity;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1ContextEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SkillResV1ContextCacheService {

    private static final Logger logger = LoggerFactory.getLogger(SkillResV1ContextCacheService.class);

    @Autowired
    SkillResV1ContextEntityRepository repository;

    @Cacheable(value = "SkillResV1ContextDomain", key = "#blockCode + ':' + #contextId + ':' + #contextName")
    public SkillResV1ContextDomain getSkillResV1ContextDomainCache(String blockCode
                                                                 , String contextId
                                                                 , String contextName) {
        SkillResV1ContextEntity entity = repository.getReferenceById(UUID.fromString(contextId));
        SkillResV1ContextDomain domain = new SkillResV1ContextDomain();
        domain.setContextId(entity.getContextId());
        domain.setContextName(entity.getContextName());
        domain.setContextType(entity.getContextType());
        domain.setBlockCode(entity.getBlockCode());
        domain.setBlockId(entity.getBuilderV1BlockContextEntity().getBuilderV1BlockEntity().getBlockId());
        domain.setTtl(entity.getTtl());
        domain.setLifespan(entity.getLifespan());
        logger.info("getSkillResV1ContextDomainCache^^SkillResV1ContextDomain :: {}", domain.toString());
        return domain;
    }

    @CachePut(value = "SkillResV1ContextDomain", key = "#blockCode + ':' + #contextId + ':' + #contextName")
    public SkillResV1ContextDomain setSkillResV1ContextDomainCache(String blockCode
                                                                 , String contextId
                                                                 , String contextName) {
        SkillResV1ContextEntity entity = repository.getReferenceById(UUID.fromString(contextId));
        SkillResV1ContextDomain domain = new SkillResV1ContextDomain();
        domain.setContextId(entity.getContextId());
        domain.setContextName(entity.getContextName());
        domain.setContextType(entity.getContextType());
        domain.setBlockCode(entity.getBlockCode());
        domain.setBlockId(entity.getBuilderV1BlockContextEntity().getBuilderV1BlockEntity().getBlockId());
        domain.setTtl(entity.getTtl());
        domain.setLifespan(entity.getLifespan());
        logger.info("getSkillResV1ContextDomainCache^^SkillResV1ContextDomain :: {}", domain.toString());
        return domain;
    }

    @CacheEvict(value = "SkillResV1ContextDomain", key = "#blockCode + ':' + #contextId + ':' + #contextName")
    public void deleteSkillResV1ContextDomainCache(String blockCode
                                                 , String contextId
                                                 , String contextName) {
        logger.info("SkillResV1ContextDomain Cache is deleted ... blockCode : {}, contextId : {}, contextName : {}", blockCode, contextId, contextName);
    }

}
