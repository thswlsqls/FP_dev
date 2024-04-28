package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateQrplDomain;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateQrplEntity;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1TemplateQrplEntityRepository;
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
public class SkillResV1TemplateQrplCacheService {

    private static final Logger logger = LoggerFactory.getLogger(SkillResV1TemplateQrplCacheService.class);

    @Autowired
    SkillResV1TemplateQrplEntityRepository repository;

    @Cacheable(value = "SkillResV1TemplateQrplDomain", key = "#qrplId")
    public SkillResV1TemplateQrplDomain getSkillResV1TemplateQrplDomainCache(String qrplId) {
        SkillResV1TemplateQrplEntity entity = repository.getReferenceById(UUID.fromString(qrplId));
        SkillResV1TemplateQrplDomain domain = new SkillResV1TemplateQrplDomain();
        if (Objects.nonNull(entity.getQrplId())) { domain.setQrplId(entity.getQrplId()); }
        if (StringUtils.hasText(entity.getLabel())) { domain.setLabel(entity.getLabel()); }
        if (StringUtils.hasText(entity.getAction())) { domain.setAction(entity.getAction()); }
        if (StringUtils.hasText(entity.getMessageText())) { domain.setMessageText(entity.getMessageText()); }
        if (Objects.nonNull(entity.getSkillResV1TemplateEntity()) && Objects.nonNull(entity.getSkillResV1TemplateEntity().getTemplateId())) {
            domain.setTemplateId(entity.getSkillResV1TemplateEntity().getTemplateId());
        }
        logger.info("getSkillResV1TemplateQrplDomainCache^^SkillResV1TemplateQrplDomain :: {}", domain.toString());
        return domain;
    }

    @CachePut(value = "SkillResV1TemplateQrplDomain", key = "#qrplId")
    public SkillResV1TemplateQrplDomain setSkillResV1TemplateQrplDomainCache(String qrplId) {
        SkillResV1TemplateQrplEntity entity = repository.getReferenceById(UUID.fromString(qrplId));
        SkillResV1TemplateQrplDomain domain = new SkillResV1TemplateQrplDomain();
        if (Objects.nonNull(entity.getQrplId())) { domain.setQrplId(entity.getQrplId()); }
        if (StringUtils.hasText(entity.getLabel())) { domain.setLabel(entity.getLabel()); }
        if (StringUtils.hasText(entity.getAction())) { domain.setAction(entity.getAction()); }
        if (StringUtils.hasText(entity.getMessageText())) { domain.setMessageText(entity.getMessageText()); }
        if (Objects.nonNull(entity.getSkillResV1TemplateEntity()) && Objects.nonNull(entity.getSkillResV1TemplateEntity().getTemplateId())) {
            domain.setTemplateId(entity.getSkillResV1TemplateEntity().getTemplateId());
        }
        logger.info("setSkillResV1TemplateQrplDomainCache^^SkillResV1TemplateQrplDomain :: {}", domain.toString());
        return domain;
    }

    @CacheEvict(value = "SkillResV1TemplateQrplDomain", key = "#qrplId")
    public void deleteSkillResV1TemplateQrplDomainCache(String qrplId) {
        logger.info("SkillResV1TemplateQrplDomain Cache is deleted ... qrplId : {}", qrplId);
    }
}
