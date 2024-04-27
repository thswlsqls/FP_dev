package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateTextCardDomain;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateTextCardEntity;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1TemplateTextCardEntityRepository;
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
public class SkillResV1TemplateTextCardCacheService {

    private static final Logger logger = LoggerFactory.getLogger(SkillResV1TemplateTextCardCacheService.class);

    @Autowired
    SkillResV1TemplateTextCardEntityRepository repository;

    @Cacheable(value = "SkillResV1TemplateTextCardDomain", key = "#componentId")
    public SkillResV1TemplateTextCardDomain getSkillResV1TemplateTextCardDomainCache(String componentId) {
        SkillResV1TemplateTextCardEntity entity = repository.getReferenceById(UUID.fromString(componentId));
        SkillResV1TemplateTextCardDomain domain = new SkillResV1TemplateTextCardDomain();
        if (Objects.nonNull(entity.getComponentId())){ domain.setComponentId(UUID.fromString(componentId)); }
        if (Objects.nonNull(entity.getCardOrd())){ domain.setCardOrd(entity.getCardOrd()); }
        if (StringUtils.hasText(entity.getTitle())) { domain.setTitle(entity.getTitle()); }
        if (StringUtils.hasText(entity.getDesc())) { domain.setDesc(entity.getDesc()); }
        if (StringUtils.hasText(entity.getDataType())) { domain.setDataType(entity.getDataType()); }
        if (Objects.nonNull(entity.getSkillResV1TemplateCarouselEntity()) && Objects.nonNull(entity.getSkillResV1TemplateCarouselEntity().getCarouselId())) {
            domain.setCarouselId(entity.getSkillResV1TemplateCarouselEntity().getCarouselId());
        }
        return domain;
    }

    @CachePut(value = "SkillResV1TemplateTextCardDomain", key = "#componentId")
    public SkillResV1TemplateTextCardDomain setSkillResV1TemplateTextCardDomainCache(String componentId) {
        SkillResV1TemplateTextCardEntity entity = repository.getReferenceById(UUID.fromString(componentId));
        SkillResV1TemplateTextCardDomain domain = new SkillResV1TemplateTextCardDomain();
        if (Objects.nonNull(entity.getComponentId())){ domain.setComponentId(UUID.fromString(componentId)); }
        if (Objects.nonNull(entity.getCardOrd())){ domain.setCardOrd(entity.getCardOrd()); }
        if (StringUtils.hasText(entity.getTitle())) { domain.setTitle(entity.getTitle()); }
        if (StringUtils.hasText(entity.getDesc())) { domain.setDesc(entity.getDesc()); }
        if (StringUtils.hasText(entity.getDataType())) { domain.setDataType(entity.getDataType()); }
        if (Objects.nonNull(entity.getSkillResV1TemplateCarouselEntity()) && Objects.nonNull(entity.getSkillResV1TemplateCarouselEntity().getCarouselId())) {
            domain.setCarouselId(entity.getSkillResV1TemplateCarouselEntity().getCarouselId());
        }
        return domain;
    }

    @CacheEvict(value = "SkillResV1TemplateTextCardDomain", key = "#componentId")
    public void deleteSkillResV1TemplateTextCardDomainCache(String componentId) {}

}
