package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateDomain;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateEntity;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1TemplateEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.UUID;

@Service
public class SkillResV1TemplateCacheService {

    private static final Logger logger = LoggerFactory.getLogger(SkillResV1TemplateCacheService.class);

    @Autowired
    private SkillResV1TemplateEntityRepository repository;


    @Cacheable(value = "SkillResV1TemplateDomain", key = "#templateId")
    public SkillResV1TemplateDomain getSkillResV1TemplateDomainCache(String templateId) {
        SkillResV1TemplateEntity entity = repository.getReferenceById(UUID.fromString(templateId));
        SkillResV1TemplateDomain domain = new SkillResV1TemplateDomain();

        if (Objects.nonNull(entity.getTemplateId())) { domain.setTemplateId(entity.getTemplateId());}
        if (Objects.nonNull(entity.getBuilderV1BlockEntity().getBlockId())) { domain.setBlockId(entity.getBuilderV1BlockEntity().getBlockId()); }
        if (StringUtils.hasText(entity.getBlockCode())) { domain.setBlockCode(entity.getBlockCode()); }
        if (StringUtils.hasText(entity.getTemplateName())) { domain.setTemplateName(entity.getTemplateName()); }

        logger.info("getSkillResV1TemplateDomainCache^^SkillResV1TemplateDomain :: {}", domain.toString());
        return domain;
    }

    @Cacheable(value = "SkillResV1TemplateDomain", key = "#templateId")
    public SkillResV1TemplateDomain setSkillResV1TemplateDomainCache(String templateId) {
        SkillResV1TemplateEntity entity = repository.getReferenceById(UUID.fromString(templateId));
        SkillResV1TemplateDomain domain = new SkillResV1TemplateDomain();

        if (Objects.nonNull(entity.getTemplateId())) { domain.setTemplateId(entity.getTemplateId());}
        if (Objects.nonNull(entity.getBuilderV1BlockEntity().getBlockId())) { domain.setBlockId(entity.getBuilderV1BlockEntity().getBlockId()); }
        if (StringUtils.hasText(entity.getBlockCode())) { domain.setBlockCode(entity.getBlockCode()); }
        if (StringUtils.hasText(entity.getTemplateName())) { domain.setTemplateName(entity.getTemplateName()); }

        logger.info("setSkillResV1TemplateDomainCache^^SkillResV1TemplateDomain :: {}", domain.toString());
        return domain;
    }

    @CacheEvict(value = "SkillResV1TemplateDomain", key = "#templateId")
    public void deleteSkillResV1TemplateDomainCache(String templateId) {
        logger.info("SkillResV1TemplateDomain Cache is deleted ... templateId : {}", templateId);
    }

}
