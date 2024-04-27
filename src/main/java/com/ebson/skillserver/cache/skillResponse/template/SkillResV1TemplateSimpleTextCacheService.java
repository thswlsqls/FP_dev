package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateSimpleTextDomain;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateSimpleTextEntity;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1TemplateSimpleTextEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SkillResV1TemplateSimpleTextCacheService {

    private static final Logger logger = LoggerFactory.getLogger(SkillResV1TemplateSimpleTextCacheService.class);

    @Autowired
    SkillResV1TemplateSimpleTextEntityRepository repository;

    @Cacheable(value = "SkillResV1TemplateSimpleTextDomain", key = "#componentId")
    public SkillResV1TemplateSimpleTextDomain getSkillResV1TemplateSimpleTextDomainCache(String componentId) {
        SkillResV1TemplateSimpleTextEntity entity = repository.getReferenceById(UUID.fromString(componentId));
        SkillResV1TemplateSimpleTextDomain domain = new SkillResV1TemplateSimpleTextDomain();
        domain.setComponentId(UUID.fromString(componentId));
        domain.setText(entity.getText());
        return domain;
    }

    @CachePut(value = "SkillResV1TemplateSimpleTextDomain", key = "#componentId")
    public SkillResV1TemplateSimpleTextDomain setSkillResV1TemplateSimpleTextDomainCache(String componentId) {
        SkillResV1TemplateSimpleTextEntity entity = repository.getReferenceById(UUID.fromString(componentId));
        SkillResV1TemplateSimpleTextDomain domain = new SkillResV1TemplateSimpleTextDomain();
        domain.setComponentId(UUID.fromString(componentId));
        domain.setText(entity.getText());
        return domain;
    }

    @CacheEvict(value = "SkillResV1TemplateSimpleTextDomain", key = "#componentId")
    public void deleteSkillResV1TemplateSimpleTextDomainCache(String componentId) {}

}
