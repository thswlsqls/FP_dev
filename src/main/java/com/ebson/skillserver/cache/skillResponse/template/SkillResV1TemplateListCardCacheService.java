package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateListCardDomain;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateListCardEntity;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1TemplateListCardEntityRepository;
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
public class SkillResV1TemplateListCardCacheService {

    private static final Logger logger = LoggerFactory.getLogger(SkillResV1TemplateListCardCacheService.class);

    @Autowired
    SkillResV1TemplateListCardEntityRepository repository;

    @Cacheable(value = "SkillResV1TemplateListCardDomain", key = "#componentId")
    public SkillResV1TemplateListCardDomain getSkillResV1TemplateListCardDomainCache(String componentId) {
        SkillResV1TemplateListCardEntity entity = repository.getReferenceById(UUID.fromString(componentId));
        SkillResV1TemplateListCardDomain domain = new SkillResV1TemplateListCardDomain();
        if (Objects.nonNull(entity.getComponentId())) { domain.setComponentId(entity.getComponentId()); }
        if (Objects.nonNull(entity.getCardOrd())) { domain.setCardOrd(entity.getCardOrd()); }
        if (StringUtils.hasText(entity.getDataType())) { domain.setDataType(entity.getDataType()); }
        if (Objects.nonNull(entity.getSkillResV1TemplateCarouselEntity()) && Objects.nonNull(entity.getSkillResV1TemplateCarouselEntity().getCarouselId())) {
            domain.setCarouselId(entity.getSkillResV1TemplateCarouselEntity().getCarouselId());
        }
        logger.info("getSkillResV1TemplateListCardDomainCache^^SkillResV1TemplateListCardDomain :: {}", domain.toString());
        return domain;
    }

    @CachePut(value = "SkillResV1TemplateListCardDomain", key = "#componentId")
    public SkillResV1TemplateListCardDomain setSkillResV1TemplateListCardDomainCache(String componentId) {
        SkillResV1TemplateListCardEntity entity = repository.getReferenceById(UUID.fromString(componentId));
        SkillResV1TemplateListCardDomain domain = new SkillResV1TemplateListCardDomain();
        if (Objects.nonNull(entity.getComponentId())) { domain.setComponentId(entity.getComponentId()); }
        if (Objects.nonNull(entity.getCardOrd())) { domain.setCardOrd(entity.getCardOrd()); }
        if (StringUtils.hasText(entity.getDataType())) { domain.setDataType(entity.getDataType()); }
        if (Objects.nonNull(entity.getSkillResV1TemplateCarouselEntity()) && Objects.nonNull(entity.getSkillResV1TemplateCarouselEntity().getCarouselId())) {
            domain.setCarouselId(entity.getSkillResV1TemplateCarouselEntity().getCarouselId());
        }
        logger.info("setSkillResV1TemplateListCardDomainCache^^SkillResV1TemplateListCardDomain :: {}", domain.toString());
        return domain;
    }

    @CacheEvict(value = "SkillResV1TemplateListCardDomain", key = "#componentId")
    public void deleteSkillResV1TemplateListCardDomainCache(String componentId) {
        logger.info("SkillResV1TemplateListCardDomain Cache is deleted ... componentId : {}", componentId);
    }

}
