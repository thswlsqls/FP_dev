package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateOutputDomain;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateOutputEntity;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1TemplateOutputEntityRepository;
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
public class SkillResV1TemplateOutputCacheService {

    private static final Logger logger = LoggerFactory.getLogger(SkillResV1TemplateOutputCacheService.class);

    @Autowired
    SkillResV1TemplateOutputEntityRepository repository;

    @Cacheable(value = "SkillResV1TemplateOutputDomain", key = "#outputId")
    public SkillResV1TemplateOutputDomain getSkillResV1TemplateOutputDomainCache(String outputId) {
        SkillResV1TemplateOutputEntity entity = repository.getReferenceById(UUID.fromString(outputId));
        SkillResV1TemplateOutputDomain domain = new SkillResV1TemplateOutputDomain();
        if (Objects.nonNull(entity.getOutputId())) { domain.setOutputId(entity.getOutputId()); }
        if (Objects.nonNull(entity.getOutputOrd())) { domain.setOutputOrd(entity.getOutputOrd()); }
        if (StringUtils.hasText(entity.getOutputName())) { domain.setOutputName(entity.getOutputName()); }
        if (Objects.nonNull(entity.getSkillResV1TemplateEntity()) && Objects.nonNull(entity.getSkillResV1TemplateEntity().getTemplateId())) {
            domain.setTemplateId(entity.getSkillResV1TemplateEntity().getTemplateId());
        }
        logger.info("getSkillResV1TemplateOutputDomainCache^^SkillResV1TemplateOutputDomain :: {}", domain.toString());
        return domain;
    }

    @CachePut(value = "SkillResV1TemplateOutputDomain", key = "#outputId")
    public SkillResV1TemplateOutputDomain setSkillResV1TemplateOutputDomainCache(String outputId) {
        SkillResV1TemplateOutputEntity entity = repository.getReferenceById(UUID.fromString(outputId));
        SkillResV1TemplateOutputDomain domain = new SkillResV1TemplateOutputDomain();
        if (Objects.nonNull(entity.getOutputId())) { domain.setOutputId(entity.getOutputId()); }
        if (Objects.nonNull(entity.getOutputOrd())) { domain.setOutputOrd(entity.getOutputOrd()); }
        if (StringUtils.hasText(entity.getOutputName())) { domain.setOutputName(entity.getOutputName()); }
        if (Objects.nonNull(entity.getSkillResV1TemplateEntity()) && Objects.nonNull(entity.getSkillResV1TemplateEntity().getTemplateId())) {
            domain.setTemplateId(entity.getSkillResV1TemplateEntity().getTemplateId());
        }
        logger.info("setSkillResV1TemplateOutputDomainCache^^SkillResV1TemplateOutputDomain :: {}", domain.toString());
        return domain;
    }

    @CacheEvict(value = "SkillResV1TemplateOutputDomain", key = "#outputId")
    public void deleteSkillResV1TemplateOutputDomainCache(String outputId) {
        logger.info("SkillResV1TemplateOutputDomain Cache is deleted ... outputId : {}", outputId);
    }
}
