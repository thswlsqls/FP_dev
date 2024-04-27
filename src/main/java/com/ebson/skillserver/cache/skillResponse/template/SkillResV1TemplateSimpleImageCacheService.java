package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateSimpleImageDomain;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateSimpleImageEntity;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1TemplateSimpleImageEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SkillResV1TemplateSimpleImageCacheService {

    private static final Logger logger = LoggerFactory.getLogger(SkillResV1TemplateSimpleImageCacheService.class);

    @Autowired
    SkillResV1TemplateSimpleImageEntityRepository repository;

    @Cacheable(value = "SkillResV1TemplateSimpleImageDomain", key = "#componentId")
    public SkillResV1TemplateSimpleImageDomain getSkillResV1TemplateSimpleImageDomainCache(String componentId) {
        SkillResV1TemplateSimpleImageEntity entity = repository.getReferenceById(UUID.fromString(componentId));
        SkillResV1TemplateSimpleImageDomain domain = new SkillResV1TemplateSimpleImageDomain();
        domain.setComponentId(UUID.fromString(componentId));
        domain.setImgUrl(entity.getImgUrl());
        domain.setAltText(entity.getAltText());
        return domain;
    }

    @CachePut(value = "SkillResV1TemplateSimpleImageDomain", key = "#componentId")
    public SkillResV1TemplateSimpleImageDomain setSkillResV1TemplateSimpleImageDomainCache(String componentId) {
        SkillResV1TemplateSimpleImageEntity entity = repository.getReferenceById(UUID.fromString(componentId));
        SkillResV1TemplateSimpleImageDomain domain = new SkillResV1TemplateSimpleImageDomain();
        domain.setComponentId(UUID.fromString(componentId));
        domain.setImgUrl(entity.getImgUrl());
        domain.setAltText(entity.getAltText());
        return domain;
    }

    @CacheEvict(value = "SkillResV1TemplateSimpleImageDomain", key = "#componentId")
    public void deleteSkillResV1TemplateSimpleImageDomainCache(String componentId) {}

}
