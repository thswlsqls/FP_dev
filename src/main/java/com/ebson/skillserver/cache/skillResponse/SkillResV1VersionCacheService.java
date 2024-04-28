package com.ebson.skillserver.cache.skillResponse;

import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1VersionDomain;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1VersionEntity;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1VersionEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SkillResV1VersionCacheService {

    private static final Logger logger = LoggerFactory.getLogger(SkillResV1VersionCacheService.class);

    @Autowired
    SkillResV1VersionEntityRepository repository;

    @Cacheable(value = "SkillResV1VersionDomain", key = "#versionId + ':' + #blockCode")
    public SkillResV1VersionDomain getSkillResV1VersionDomainCache(String versionId, String blockCode) {
        SkillResV1VersionEntity entity = repository.getReferenceById(UUID.fromString(versionId));
        SkillResV1VersionDomain domain = new SkillResV1VersionDomain();
        domain.setVersionId(entity.getVersionId());
        domain.setBlockId(entity.getBuilderV1BlockEntity().getBlockId());
        domain.setBlockCode(entity.getBlockCode());
        domain.setMajor(entity.getMajor());
        domain.setMinor(entity.getMinor());
        logger.info("getSkillResV1VersionDomainCache^^SkillResV1VersionDomain :: {}", domain.toString());
        return domain;
    }

    @CachePut(value = "SkillResV1VersionDomain", key = "#versionId + ':' + #blockCode")
    public SkillResV1VersionDomain setSkillResV1VersionDomainCache(String versionId, String blockCode) {
        SkillResV1VersionEntity entity = repository.getReferenceById(UUID.fromString(versionId));
        SkillResV1VersionDomain domain = new SkillResV1VersionDomain();
        domain.setVersionId(entity.getVersionId());
        domain.setBlockId(entity.getBuilderV1BlockEntity().getBlockId());
        domain.setBlockCode(entity.getBlockCode());
        domain.setMajor(entity.getMajor());
        domain.setMinor(entity.getMinor());
        logger.info("setSkillResV1VersionDomainCache^^SkillResV1VersionDomain :: {}", domain.toString());
        return domain;
    }

    @CacheEvict(value = "SkillResV1VersionDomain", key = "#versionId + ':' + #blockCode")
    public void deleteSkillResV1VersionDomainCache(String versionId, String blockCode) {
        logger.info("SkillResV1VersionDomain Cache is deleted ... versionId : {}, blockCode : {}", versionId, blockCode);
    }

}
