package com.ebson.skillserver.cache.skillResponse;

import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1ContextParamDomain;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1ContextParamEntity;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1ContextParamEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SkillResV1ContextParamCacheService {

    private static final Logger logger = LoggerFactory.getLogger(SkillResV1ContextParamCacheService.class);

    @Autowired
    SkillResV1ContextParamEntityRepository repository;

    @Cacheable(value = "SkillResV1ContextParamDomain", key = "#contextId + ':' + #paramNo")
    public SkillResV1ContextParamDomain getSkillResV1ContextParamDomainCache(String contextId, int paramNo){
        SkillResV1ContextParamEntity entity = repository.findByContextIdAndParamNo(UUID.fromString(contextId), paramNo);
        SkillResV1ContextParamDomain domain = new SkillResV1ContextParamDomain();
        domain.setContextId(entity.getContextId());
        domain.setParamNo(entity.getParamNo());
        domain.setKey(entity.getKey());
        domain.setValue(entity.getValue());
        return domain;
    }

    @CachePut(value = "SkillResV1ContextParamDomain", key = "#contextId + ':' + #paramNo")
    public SkillResV1ContextParamDomain setSkillResV1ContextParamDomainCache(String contextId, int paramNo){
        SkillResV1ContextParamEntity entity = repository.findByContextIdAndParamNo(UUID.fromString(contextId), paramNo);
        SkillResV1ContextParamDomain domain = new SkillResV1ContextParamDomain();
        domain.setContextId(entity.getContextId());
        domain.setParamNo(entity.getParamNo());
        domain.setKey(entity.getKey());
        domain.setValue(entity.getValue());
        return domain;
    }

    @CacheEvict(value = "SkillResV1ContextParamDomain", key = "#contextId + ':' + #paramNo")
    public void deleteSkillResV1ContextParamDomainCache(String contextId, int paramNo) {}

}
