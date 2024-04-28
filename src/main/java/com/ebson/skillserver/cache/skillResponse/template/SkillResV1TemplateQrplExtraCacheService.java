package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateQrplExtraDomain;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateQrplExtraEntity;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1TemplateQrplEntityRepository;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1TemplateQrplExtraEntityRepository;
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
public class SkillResV1TemplateQrplExtraCacheService {

    private static final Logger logger = LoggerFactory.getLogger(SkillResV1TemplateQrplExtraCacheService.class);

    @Autowired
    SkillResV1TemplateQrplExtraEntityRepository repository;

    @Cacheable(value = "SkillResV1TemplateQrplExtraDomain", key = "#extraId")
    public SkillResV1TemplateQrplExtraDomain getSkillResV1TemplateQrplExtraDomainCache(String extraId) {
        SkillResV1TemplateQrplExtraEntity entity = repository.getReferenceById(UUID.fromString(extraId));
        SkillResV1TemplateQrplExtraDomain domain = new SkillResV1TemplateQrplExtraDomain();
        if (Objects.nonNull(entity.getExtraId())) { domain.setExtraId(entity.getExtraId()); }
        if (StringUtils.hasText(entity.getKey())) { domain.setKey(entity.getKey()); }
        if (StringUtils.hasText(entity.getValue())) { domain.setValue(entity.getValue()); }
        if (Objects.nonNull(entity.getSkillResV1TemplateQrplEntity()) && Objects.nonNull(entity.getSkillResV1TemplateQrplEntity().getQrplId())) {
            domain.setExtraId(entity.getSkillResV1TemplateQrplEntity().getQrplId());
        }
        logger.info("getSkillResV1TemplateQrplExtraDomainCache^^SkillResV1TemplateQrplExtraDomain :: {}", domain.toString());
        return domain;
    }

    @CachePut(value = "SkillResV1TemplateQrplExtraDomain", key = "#extraId")
    public SkillResV1TemplateQrplExtraDomain setSkillResV1TemplateQrplExtraDomainCache(String extraId) {
        SkillResV1TemplateQrplExtraEntity entity = repository.getReferenceById(UUID.fromString(extraId));
        SkillResV1TemplateQrplExtraDomain domain = new SkillResV1TemplateQrplExtraDomain();
        if (Objects.nonNull(entity.getExtraId())) { domain.setExtraId(entity.getExtraId()); }
        if (StringUtils.hasText(entity.getKey())) { domain.setKey(entity.getKey()); }
        if (StringUtils.hasText(entity.getValue())) { domain.setValue(entity.getValue()); }
        if (Objects.nonNull(entity.getSkillResV1TemplateQrplEntity()) && Objects.nonNull(entity.getSkillResV1TemplateQrplEntity().getQrplId())) {
            domain.setExtraId(entity.getSkillResV1TemplateQrplEntity().getQrplId());
        }
        logger.info("setSkillResV1TemplateQrplExtraDomainCache^^SkillResV1TemplateQrplExtraDomain :: {}", domain.toString());
        return domain;
    }

    @CacheEvict(value = "SkillResV1TemplateQrplExtraDomain", key = "#extraId")
    public void deleteSkillResV1TemplateQrplExtraDomainCache(String extraId) {
        logger.info("SkillResV1TemplateQrplExtraDomain Cache is deleted ... extraId : {}", extraId);
    }

}
