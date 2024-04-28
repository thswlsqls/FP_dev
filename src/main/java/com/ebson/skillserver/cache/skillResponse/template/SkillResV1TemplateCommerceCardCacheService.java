package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateCommerceCardDomain;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateCommerceCardEntity;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1TemplateCommerceCardEntityRepository;
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
public class SkillResV1TemplateCommerceCardCacheService {

    private static final Logger logger = LoggerFactory.getLogger(SkillResV1TemplateCommerceCardCacheService.class);

    @Autowired
    SkillResV1TemplateCommerceCardEntityRepository repository;

    @Cacheable(value = "SkillResV1TemplateCommerceCardDomain", key = "#componentId")
    public SkillResV1TemplateCommerceCardDomain getSkillResV1TemplateCommerceCardDomainCache(String componentId) {
        SkillResV1TemplateCommerceCardEntity entity = repository.getReferenceById(UUID.fromString(componentId));
        SkillResV1TemplateCommerceCardDomain domain = new SkillResV1TemplateCommerceCardDomain();
        if (Objects.nonNull(entity.getComponentId())) { domain.setComponentId(entity.getComponentId()); }
        if (Objects.nonNull(entity.getCardOrd())) { domain.setCardOrd(entity.getCardOrd()); }
        if (StringUtils.hasText(entity.getDataType())) { domain.setDataType(entity.getDataType()); }
        if (StringUtils.hasText(entity.getTitle())) { domain.setTitle(entity.getTitle()); }
        if (StringUtils.hasText(entity.getDesc())) { domain.setDesc(entity.getDesc()); }
        if (Objects.nonNull(entity.getPrice())) { domain.setPrice(entity.getPrice()); }
        if (StringUtils.hasText(entity.getCurrency())) { domain.setCurrency(entity.getCurrency()); }
        if (Objects.nonNull(entity.getDiscount())) { domain.setDiscount(entity.getDiscount()); }
        if (Objects.nonNull(entity.getDiscountRate())) { domain.setDiscountRate(entity.getDiscountRate()); }
        if (Objects.nonNull(entity.getDiscountedPrice())) { domain.setDiscountedPrice(entity.getDiscountedPrice()); }
        if (StringUtils.hasText(entity.getThumbImgUrl())) { domain.setThumbImgUrl(entity.getThumbImgUrl()); }
        if (StringUtils.hasText(entity.getThumbLinkWeb())) { domain.setThumbLinkWeb(entity.getThumbLinkWeb()); }
        if (StringUtils.hasText(entity.getThumbLinkPc())) { domain.setThumbLinkPc(entity.getThumbLinkPc()); }
        if (StringUtils.hasText(entity.getThumbLinkMobile())) { domain.setThumbLinkMobile(entity.getThumbLinkMobile()); }
        if (StringUtils.hasText(entity.getThumbFixedRatio())) { domain.setThumbFixedRatio(entity.getThumbFixedRatio()); }
        if (StringUtils.hasText(entity.getProfileNickname())) { domain.setProfileNickname(entity.getProfileNickname()); }
        if (StringUtils.hasText(entity.getProfileImgUrl())) { domain.setProfileImgUrl(entity.getProfileImgUrl()); }
        logger.info("getSkillResV1TemplateCommerceCardDomainCache^^SkillResV1TemplateCommerceCardDomain :: {}", domain.toString());
        return domain;
    }

    @CachePut(value = "SkillResV1TemplateCommerceCardDomain", key = "#componentId")
    public SkillResV1TemplateCommerceCardDomain setSkillResV1TemplateCommerceCardDomainCache(String componentId) {
        SkillResV1TemplateCommerceCardEntity entity = repository.getReferenceById(UUID.fromString(componentId));
        SkillResV1TemplateCommerceCardDomain domain = new SkillResV1TemplateCommerceCardDomain();
        if (Objects.nonNull(entity.getComponentId())) { domain.setComponentId(entity.getComponentId()); }
        if (Objects.nonNull(entity.getCardOrd())) { domain.setCardOrd(entity.getCardOrd()); }
        if (StringUtils.hasText(entity.getDataType())) { domain.setDataType(entity.getDataType()); }
        if (StringUtils.hasText(entity.getTitle())) { domain.setTitle(entity.getTitle()); }
        if (StringUtils.hasText(entity.getDesc())) { domain.setDesc(entity.getDesc()); }
        if (Objects.nonNull(entity.getPrice())) { domain.setPrice(entity.getPrice()); }
        if (StringUtils.hasText(entity.getCurrency())) { domain.setCurrency(entity.getCurrency()); }
        if (Objects.nonNull(entity.getDiscount())) { domain.setDiscount(entity.getDiscount()); }
        if (Objects.nonNull(entity.getDiscountRate())) { domain.setDiscountRate(entity.getDiscountRate()); }
        if (Objects.nonNull(entity.getDiscountedPrice())) { domain.setDiscountedPrice(entity.getDiscountedPrice()); }
        if (StringUtils.hasText(entity.getThumbImgUrl())) { domain.setThumbImgUrl(entity.getThumbImgUrl()); }
        if (StringUtils.hasText(entity.getThumbLinkWeb())) { domain.setThumbLinkWeb(entity.getThumbLinkWeb()); }
        if (StringUtils.hasText(entity.getThumbLinkPc())) { domain.setThumbLinkPc(entity.getThumbLinkPc()); }
        if (StringUtils.hasText(entity.getThumbLinkMobile())) { domain.setThumbLinkMobile(entity.getThumbLinkMobile()); }
        if (StringUtils.hasText(entity.getThumbFixedRatio())) { domain.setThumbFixedRatio(entity.getThumbFixedRatio()); }
        if (StringUtils.hasText(entity.getProfileNickname())) { domain.setProfileNickname(entity.getProfileNickname()); }
        if (StringUtils.hasText(entity.getProfileImgUrl())) { domain.setProfileImgUrl(entity.getProfileImgUrl()); }
        logger.info("setSkillResV1TemplateCommerceCardDomainCache^^SkillResV1TemplateCommerceCardDomain :: {}", domain.toString());
        return domain;
    }

    @CacheEvict(value = "SkillResV1TemplateCommerceCardDomain", key = "#componentId")
    public void deleteSkillResV1TemplateCommerceCardDomainCache(String componentId) {
        logger.info("SkillResV1TemplateCommerceCardDomain Cache is deleted ... componentId : {}", componentId);
    }

}
