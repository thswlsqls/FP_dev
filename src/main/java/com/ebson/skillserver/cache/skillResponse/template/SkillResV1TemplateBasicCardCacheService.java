package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateBasicCardDomain;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateBasicCardEntity;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1TemplateBasicCardEntityRepository;
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
public class SkillResV1TemplateBasicCardCacheService {

    private static final Logger logger = LoggerFactory.getLogger(SkillResV1TemplateBasicCardCacheService.class);

    @Autowired
    SkillResV1TemplateBasicCardEntityRepository repository;

    @Cacheable(value = "SkillResV1TemplateBasicCardDomain", key = "#componentId")
    public SkillResV1TemplateBasicCardDomain getSkillResV1TemplateBasicCardDomainCache(String componentId) {
        SkillResV1TemplateBasicCardEntity entity = repository.getReferenceById(UUID.fromString(componentId));
        SkillResV1TemplateBasicCardDomain domain = new SkillResV1TemplateBasicCardDomain();
        if (Objects.nonNull(entity.getComponentId())) { domain.setComponentId(entity.getComponentId()); }
        if (Objects.nonNull(entity.getCardOrd())) { domain.setCardOrd(entity.getCardOrd()); }
        if (StringUtils.hasText(entity.getDataType())) { domain.setDataType(entity.getDataType());}
        if (StringUtils.hasText(entity.getTitle())) { domain.setTitle(entity.getTitle()); }
        if (StringUtils.hasText(entity.getDesc())) { domain.setDesc(entity.getDesc()); }
        if (StringUtils.hasText(entity.getThumbImgUrl())) { domain.setThumbImgUrl(entity.getThumbImgUrl()); }
        if (StringUtils.hasText(entity.getThumbLinkPc())) { domain.setThumbLinkPc(entity.getThumbLinkPc()); }
        if (StringUtils.hasText(entity.getThumbLinkWeb())) { domain.setThumbLinkWeb(entity.getThumbLinkWeb()); }
        if (StringUtils.hasText(entity.getThumbLinkMobile())) { domain.setThumbLinkMobile(entity.getThumbLinkMobile()); }
        if (StringUtils.hasText(entity.getThumbFixedRatio())) { domain.setThumbFixedRatio(entity.getThumbFixedRatio()); }
        if (Objects.nonNull(entity.getSkillResV1TemplateCarouselEntity()) && Objects.nonNull(entity.getSkillResV1TemplateCarouselEntity().getCarouselId())) { domain.setCarouselId(entity.getSkillResV1TemplateCarouselEntity().getCarouselId()); }
        return domain;
    }

    @CachePut(value = "SkillResV1TemplateBasicCardDomain", key = "#componentId")
    public SkillResV1TemplateBasicCardDomain setSkillResV1TemplateBasicCardDomainCache(String componentId) {
        SkillResV1TemplateBasicCardEntity entity = repository.getReferenceById(UUID.fromString(componentId));
        SkillResV1TemplateBasicCardDomain domain = new SkillResV1TemplateBasicCardDomain();
        if (Objects.nonNull(entity.getComponentId())) { domain.setComponentId(entity.getComponentId()); }
        if (Objects.nonNull(entity.getCardOrd())) { domain.setCardOrd(entity.getCardOrd()); }
        if (StringUtils.hasText(entity.getDataType())) { domain.setDataType(entity.getDataType());}
        if (StringUtils.hasText(entity.getTitle())) { domain.setTitle(entity.getTitle()); }
        if (StringUtils.hasText(entity.getDesc())) { domain.setDesc(entity.getDesc()); }
        if (StringUtils.hasText(entity.getThumbImgUrl())) { domain.setThumbImgUrl(entity.getThumbImgUrl()); }
        if (StringUtils.hasText(entity.getThumbLinkPc())) { domain.setThumbLinkPc(entity.getThumbLinkPc()); }
        if (StringUtils.hasText(entity.getThumbLinkWeb())) { domain.setThumbLinkWeb(entity.getThumbLinkWeb()); }
        if (StringUtils.hasText(entity.getThumbLinkMobile())) { domain.setThumbLinkMobile(entity.getThumbLinkMobile()); }
        if (StringUtils.hasText(entity.getThumbFixedRatio())) { domain.setThumbFixedRatio(entity.getThumbFixedRatio()); }
        if (Objects.nonNull(entity.getSkillResV1TemplateCarouselEntity()) && Objects.nonNull(entity.getSkillResV1TemplateCarouselEntity().getCarouselId())) { domain.setCarouselId(entity.getSkillResV1TemplateCarouselEntity().getCarouselId()); }
        return domain;
    }

    @CacheEvict(value = "SkillResV1TemplateBasicCardDomain", key = "#componentId")
    public void deleteSkillResV1TemplateBasicCardDomainCache(String componentId) {}

}
