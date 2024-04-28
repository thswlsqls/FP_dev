package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateComponentBtnDomain;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateComponentBtnEntity;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1TemplateComponentBtnEntityRepository;
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
public class SkillResV1TemplateComponentBtnCacheService {
    private static final Logger logger = LoggerFactory.getLogger(SkillResV1TemplateComponentBtnCacheService.class);

    @Autowired
    SkillResV1TemplateComponentBtnEntityRepository repository;

    @Cacheable(value = "SkillResV1TemplateComponentBtnDomain", key = "#btnId")
    public SkillResV1TemplateComponentBtnDomain getSkillResV1TemplateComponentBtnDomainCache(String btnId) {
        SkillResV1TemplateComponentBtnEntity entity = repository.getReferenceById(UUID.fromString(btnId));
        SkillResV1TemplateComponentBtnDomain domain = new SkillResV1TemplateComponentBtnDomain();
        if (Objects.nonNull(entity.getBtnId())) { domain.setBtnId(entity.getBtnId()); }
        if (StringUtils.hasText(entity.getBlockId())) { domain.setBlockId(entity.getBlockId()); }
        if (StringUtils.hasText(entity.getLabel())) { domain.setLabel(entity.getLabel()); }
        if (StringUtils.hasText(entity.getAction())) { domain.setAction(entity.getAction()); }
        if (StringUtils.hasText(entity.getWebLinkUrl())) { domain.setWebLinkUrl(entity.getWebLinkUrl()); }
        if (StringUtils.hasText(entity.getMessageText())) { domain.setMessageText(entity.getMessageText()); }
        if (StringUtils.hasText(entity.getPhone())) { domain.setPhone(entity.getPhone()); }
        if (Objects.nonNull(entity.getSkillResV1TemplateComponentEntity()) && Objects.nonNull(entity.getSkillResV1TemplateComponentEntity().getComponentId())) {
            domain.setComponentId(entity.getSkillResV1TemplateComponentEntity().getComponentId());
        }
        logger.info("getSkillResV1TemplateComponentBtnDomainCache^^SkillResV1TemplateComponentBtnDomain :: {}", domain.toString());
        return domain;
    }

    @CachePut(value = "SkillResV1TemplateComponentBtnDomain", key = "#btnId")
    public SkillResV1TemplateComponentBtnDomain setSkillResV1TemplateComponentBtnDomainCache(String btnId) {
        SkillResV1TemplateComponentBtnEntity entity = repository.getReferenceById(UUID.fromString(btnId));
        SkillResV1TemplateComponentBtnDomain domain = new SkillResV1TemplateComponentBtnDomain();
        if (Objects.nonNull(entity.getBtnId())) { domain.setBtnId(entity.getBtnId()); }
        if (StringUtils.hasText(entity.getBlockId())) { domain.setBlockId(entity.getBlockId()); }
        if (StringUtils.hasText(entity.getLabel())) { domain.setLabel(entity.getLabel()); }
        if (StringUtils.hasText(entity.getAction())) { domain.setAction(entity.getAction()); }
        if (StringUtils.hasText(entity.getWebLinkUrl())) { domain.setWebLinkUrl(entity.getWebLinkUrl()); }
        if (StringUtils.hasText(entity.getMessageText())) { domain.setMessageText(entity.getMessageText()); }
        if (StringUtils.hasText(entity.getPhone())) { domain.setPhone(entity.getPhone()); }
        if (Objects.nonNull(entity.getSkillResV1TemplateComponentEntity()) && Objects.nonNull(entity.getSkillResV1TemplateComponentEntity().getComponentId())) {
            domain.setComponentId(entity.getSkillResV1TemplateComponentEntity().getComponentId());
        }
        logger.info("setSkillResV1TemplateComponentBtnDomainCache^^SkillResV1TemplateComponentBtnDomain :: {}", domain.toString());
        return domain;
    }

    @CacheEvict(value = "SkillResV1TemplateComponentBtnDomain", key = "#btnId")
    public void deleteSkillResV1TemplateComponentBtnDomainCache(String btnId) {
        logger.info("SkillResV1TemplateComponentBtnDomain Cache is deleted ... btnId : {}", btnId);
    }

}
