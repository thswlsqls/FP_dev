package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateComponentDomain;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateComponentEntity;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1TemplateComponentEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.UUID;

@Service
public class SkillResV1TemplateComponentCacheService {

    private static final Logger logger = LoggerFactory.getLogger(SkillResV1TemplateComponentCacheService.class);

    @Autowired
    SkillResV1TemplateComponentEntityRepository repository;

    @Cacheable(value = "SkillResV1TemplateComponentDomain", key = "#componentId")
    public SkillResV1TemplateComponentDomain getSkillResV1TemplateComponentDomainCache(String componentId) {
        SkillResV1TemplateComponentEntity entity = repository.getReferenceById(UUID.fromString(componentId));
        SkillResV1TemplateComponentDomain domain = new SkillResV1TemplateComponentDomain();
        if (Objects.nonNull(entity.getComponentId())) { domain.setComponentId(entity.getComponentId()); }
        if (StringUtils.hasText(entity.getComponentType())) { domain.setComponentType(entity.getComponentType()); }
        if (StringUtils.hasText(entity.getComponentName())) { domain.setComponentName(entity.getComponentName()); }
        if (Objects.nonNull(entity.getSkillResV1TemplateOutputEntity()) && Objects.nonNull(entity.getSkillResV1TemplateOutputEntity().getOutputId()) ) {
            domain.setOutputId(entity.getSkillResV1TemplateOutputEntity().getOutputId());
        }
        logger.info("getSkillResV1TemplateComponentDomainCache^^SkillResV1TemplateComponentDomain :: {}", domain.toString());
        return domain;
    }

    @CachePut(value = "SkillResV1TemplateComponentDomain", key = "#componentId")
    public SkillResV1TemplateComponentDomain setSkillResV1TemplateComponentDomainCache(String componentId) {
        SkillResV1TemplateComponentEntity entity = repository.getReferenceById(UUID.fromString(componentId));
        SkillResV1TemplateComponentDomain domain = new SkillResV1TemplateComponentDomain();
        if (Objects.nonNull(entity.getComponentId())) { domain.setComponentId(entity.getComponentId()); }
        if (StringUtils.hasText(entity.getComponentType())) { domain.setComponentType(entity.getComponentType()); }
        if (StringUtils.hasText(entity.getComponentName())) { domain.setComponentName(entity.getComponentName()); }
        if (Objects.nonNull(entity.getSkillResV1TemplateOutputEntity()) && Objects.nonNull(entity.getSkillResV1TemplateOutputEntity().getOutputId()) ) {
            domain.setOutputId(entity.getSkillResV1TemplateOutputEntity().getOutputId());
        }
        logger.info("setSkillResV1TemplateComponentDomainCache^^SkillResV1TemplateComponentDomain :: {}", domain.toString());
        return domain;
    }

    @CacheEvict(value = "SkillResV1TemplateComponentDomain", key = "#componentId")
    public void deleteSkillResV1TemplateComponentDomainCache(String componentId) {
        logger.info("SkillResV1TemplateComponentDomain Cache is deleted ... componentId : {}", componentId);
    }

}
