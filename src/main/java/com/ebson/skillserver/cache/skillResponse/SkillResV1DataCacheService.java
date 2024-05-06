package com.ebson.skillserver.cache.skillResponse;

import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1DataDomain;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1DataEntity;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1DataEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SkillResV1DataCacheService {

    private static final Logger logger = LoggerFactory.getLogger(SkillResV1DataCacheService.class);

    @Autowired
    SkillResV1DataEntityRepository repository;

    @Cacheable(value = "SkillResV1DataDomain", key = "#dataId")
    public SkillResV1DataDomain getSkillResV1DataDomainCache(String dataId){
        SkillResV1DataEntity entity = repository.getReferenceById(UUID.fromString(dataId));
        SkillResV1DataDomain domain = new SkillResV1DataDomain();
        domain.setDataId(entity.getDataId());
        domain.setBlockId(entity.getBuilderV1BlockEntity().getBlockId());
        domain.setBlockCode(entity.getBlockCode());
        domain.setKey(entity.getKey());
        domain.setValue(entity.getValue());
        logger.info("getSkillResV1DataDomainCache^^SkillResV1DataDomain :: {}", domain.toString());
        return domain;
    }

    @CachePut(value = "SkillResV1DataDomain", key = "#dataId")
    public SkillResV1DataDomain setSkillResV1DataDomainCache(String dataId){
        SkillResV1DataEntity entity = repository.getReferenceById(UUID.fromString(dataId));
        SkillResV1DataDomain domain = new SkillResV1DataDomain();
        domain.setDataId(entity.getDataId());
        domain.setBlockId(entity.getBuilderV1BlockEntity().getBlockId());
        domain.setBlockCode(entity.getBlockCode());
        domain.setKey(entity.getKey());
        domain.setValue(entity.getValue());
        logger.info("setSkillResV1DataDomainCache^^SkillResV1DataDomain :: {}", domain.toString());
        return domain;
    }

    @CacheEvict(value = "SkillResV1DataDomain", key = "#dataId")
    public void deleteSkillResV1DataDomainCache(String dataId){
        logger.info("SkillResV1DataDomain Cache is deleted ... dataId : {}", dataId);
    }
}
