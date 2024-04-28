package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateComponentBtnExtraDomain;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateComponentBtnExtraEntity;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1TemplateComponentBtnExtraEntityRepository;
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
public class SkillResV1TemplateComponentBtnExtraCacheService {

    private static final Logger logger = LoggerFactory.getLogger(SkillResV1TemplateComponentBtnExtraCacheService.class);

    @Autowired
    SkillResV1TemplateComponentBtnExtraEntityRepository repository;

    @Cacheable(value = "SkillResV1TemplateComponentBtnExtraDomain", key = "#extraId")
    public SkillResV1TemplateComponentBtnExtraDomain getSkillResV1TemplateComponentBtnExtraDomainCache(String extraId) {
        SkillResV1TemplateComponentBtnExtraEntity entity = repository.getReferenceById(UUID.fromString(extraId));
        SkillResV1TemplateComponentBtnExtraDomain domain = new SkillResV1TemplateComponentBtnExtraDomain();
        if (Objects.nonNull(entity.getExtraId())) { domain.setExtraId(entity.getExtraId()); }
        if (StringUtils.hasText(entity.getKey())) { domain.setKey(entity.getKey()); }
        if (StringUtils.hasText(entity.getValue())) { domain.setValue(entity.getValue()); }
        if (Objects.nonNull(entity.getSkillResV1TemplateComponentBtnEntity()) && Objects.nonNull(entity.getSkillResV1TemplateComponentBtnEntity().getBtnId())) {
            domain.setBtnId(entity.getSkillResV1TemplateComponentBtnEntity().getBtnId());
        }
        logger.info("getSkillResV1TemplateComponentBtnExtraDomainCache^^SkillResV1TemplateComponentBtnExtraDomain :: {}", domain.toString());
        return domain;
    }

    @CachePut(value = "SkillResV1TemplateComponentBtnExtraDomain", key = "#extraId")
    public SkillResV1TemplateComponentBtnExtraDomain setSkillResV1TemplateComponentBtnExtraDomainCache(String extraId) {
        SkillResV1TemplateComponentBtnExtraEntity entity = repository.getReferenceById(UUID.fromString(extraId));
        SkillResV1TemplateComponentBtnExtraDomain domain = new SkillResV1TemplateComponentBtnExtraDomain();
        if (Objects.nonNull(entity.getExtraId())) { domain.setExtraId(entity.getExtraId()); }
        if (StringUtils.hasText(entity.getKey())) { domain.setKey(entity.getKey()); }
        if (StringUtils.hasText(entity.getValue())) { domain.setValue(entity.getValue()); }
        if (Objects.nonNull(entity.getSkillResV1TemplateComponentBtnEntity()) && Objects.nonNull(entity.getSkillResV1TemplateComponentBtnEntity().getBtnId())) {
            domain.setBtnId(entity.getSkillResV1TemplateComponentBtnEntity().getBtnId());
        }
        logger.info("getSkillResV1TemplateComponentBtnExtraDomainCache^^SkillResV1TemplateComponentBtnExtraDomain :: {}", domain.toString());
        return domain;
    }

    @CacheEvict(value = "SkillResV1TemplateComponentBtnExtraDomain", key = "#extraId")
    public void deleteSkillResV1TemplateComponentBtnExtraDomainCache(String extraId) {
        logger.info("SkillResV1TemplateComponentBtnExtraDomain Cache is deleted ... extraId : {}", extraId);
    }

}
