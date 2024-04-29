package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateItemCardDomain;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateItemCardEntity;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1TemplateItemCardEntityRepository;
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
public class SkillResV1TemplateItemCardCacheService {

    private static final Logger logger = LoggerFactory.getLogger(SkillResV1TemplateItemCardCacheService.class);

    @Autowired
    SkillResV1TemplateItemCardEntityRepository repository;

    @Cacheable(value = "SkillResV1TemplateItemCardDomain", key = "#componentId")
    public SkillResV1TemplateItemCardDomain getSkillResV1TemplateItemCardDomainCache(String componentId) {
        SkillResV1TemplateItemCardEntity entity = repository.getReferenceById(UUID.fromString(componentId));
        SkillResV1TemplateItemCardDomain domain = new SkillResV1TemplateItemCardDomain();
        if (Objects.nonNull(entity.getComponentId())) { domain.setComponentId(entity.getComponentId()); }
        if (Objects.nonNull(entity.getCardOrd())) { domain.setCardOrd(entity.getCardOrd()); }
        if (StringUtils.hasText(entity.getDataType())) { domain.setDataType(entity.getDataType()); }
        if (StringUtils.hasText(entity.getThumbYn())) { domain.setThumbYn(entity.getThumbYn()); }
        if (StringUtils.hasText(entity.getThumbImgUrl())) { domain.setThumbImgUrl(entity.getThumbImgUrl()); }
        if (Objects.nonNull(entity.getThumbWidth())) { domain.setThumbWidth(entity.getThumbWidth()); }
        if (Objects.nonNull(entity.getThumbHeight())) { domain.setThumbHeight(entity.getThumbHeight()); }
        if (StringUtils.hasText(entity.getThumbLinkPc())) { domain.setThumbLinkPc(entity.getThumbLinkPc()); }
        if (StringUtils.hasText(entity.getThumbLinkMob())) { domain.setThumbLinkMob(entity.getThumbLinkMob()); }
        if (StringUtils.hasText(entity.getThumbLinkWeb())) { domain.setThumbLinkWeb(entity.getThumbLinkWeb()); }
        if (StringUtils.hasText(entity.getHeadYn())) { domain.setHeadYn(entity.getHeadYn()); }
        if (StringUtils.hasText(entity.getHeadTitle())) { domain.setHeadTitle(entity.getHeadTitle()); }
        if (StringUtils.hasText(entity.getProfileYn())) { domain.setProfileYn(entity.getProfileYn()); }
        if (StringUtils.hasText(entity.getProfileImgUrl())) { domain.setProfileImgUrl(entity.getProfileImgUrl()); }
        if (Objects.nonNull(entity.getProfileWidth())) { domain.setProfileWidth(entity.getProfileWidth()); }
        if (Objects.nonNull(entity.getProfileHeight())) { domain.setProfileHeight(entity.getProfileHeight()); }
        if (StringUtils.hasText(entity.getProfileTitle())) { domain.setProfileTitle(entity.getProfileTitle()); }
        if (StringUtils.hasText(entity.getImgtitleYn())) { domain.setImgTitleYn(entity.getImgtitleYn()); }
        if (StringUtils.hasText(entity.getImgtitleTitle())) { domain.setImgTitleTitle(entity.getImgtitleTitle()); }
        if (StringUtils.hasText(entity.getImgtitleDesc())) { domain.setImgTitleDesc(entity.getImgtitleDesc()); }
        if (StringUtils.hasText(entity.getImgtitleImgUrl())) { domain.setImgTitleImgUrl(entity.getImgtitleImgUrl()); }
        if (StringUtils.hasText(entity.getItemlistAlign())) { domain.setItemListAlign(entity.getItemlistAlign()); }
        if (StringUtils.hasText(entity.getItemlistSummaryYn())) { domain.setItemListSummaryYn(entity.getItemlistSummaryYn()); }
        if (StringUtils.hasText(entity.getItemlistSummaryTitle())) { domain.setItemListSummaryTitle(entity.getItemlistSummaryTitle()); }
        if (StringUtils.hasText(entity.getItemlistSummaryDesc())) { domain.setItemListSummaryDesc(entity.getItemlistSummaryDesc()); }
        if (StringUtils.hasText(entity.getTitle())) { domain.setTitle(entity.getTitle()); }
        if (StringUtils.hasText(entity.getDesc())) { domain.setDesc(entity.getDesc()); }
        if (StringUtils.hasText(entity.getBtnLayout())) { domain.setBtnLayout(entity.getBtnLayout()); }
        if (Objects.nonNull(entity.getSkillResV1TemplateCarouselEntity()) && Objects.nonNull(entity.getSkillResV1TemplateCarouselEntity().getCarouselId())) {
            domain.setCarouselId(entity.getSkillResV1TemplateCarouselEntity().getCarouselId());
        }
        logger.info("getSkillResV1TemplateItemCardDomainCache^^SkillResV1TemplateItemCardDomain :: {}", domain.toString());
        return domain;
    }

    @CachePut(value = "SkillResV1TemplateItemCardDomain", key = "#componentId")
    public SkillResV1TemplateItemCardDomain setSkillResV1TemplateItemCardDomainCache(String componentId) {
        SkillResV1TemplateItemCardEntity entity = repository.getReferenceById(UUID.fromString(componentId));
        SkillResV1TemplateItemCardDomain domain = new SkillResV1TemplateItemCardDomain();
        if (Objects.nonNull(entity.getComponentId())) { domain.setComponentId(entity.getComponentId()); }
        if (Objects.nonNull(entity.getCardOrd())) { domain.setCardOrd(entity.getCardOrd()); }
        if (StringUtils.hasText(entity.getDataType())) { domain.setDataType(entity.getDataType()); }
        if (StringUtils.hasText(entity.getThumbYn())) { domain.setThumbYn(entity.getThumbYn()); }
        if (StringUtils.hasText(entity.getThumbImgUrl())) { domain.setThumbImgUrl(entity.getThumbImgUrl()); }
        if (Objects.nonNull(entity.getThumbWidth())) { domain.setThumbWidth(entity.getThumbWidth()); }
        if (Objects.nonNull(entity.getThumbHeight())) { domain.setThumbHeight(entity.getThumbHeight()); }
        if (StringUtils.hasText(entity.getThumbLinkPc())) { domain.setThumbLinkPc(entity.getThumbLinkPc()); }
        if (StringUtils.hasText(entity.getThumbLinkMob())) { domain.setThumbLinkMob(entity.getThumbLinkMob()); }
        if (StringUtils.hasText(entity.getThumbLinkWeb())) { domain.setThumbLinkWeb(entity.getThumbLinkWeb()); }
        if (StringUtils.hasText(entity.getHeadYn())) { domain.setHeadYn(entity.getHeadYn()); }
        if (StringUtils.hasText(entity.getHeadTitle())) { domain.setHeadTitle(entity.getHeadTitle()); }
        if (StringUtils.hasText(entity.getProfileYn())) { domain.setProfileYn(entity.getProfileYn()); }
        if (StringUtils.hasText(entity.getProfileImgUrl())) { domain.setProfileImgUrl(entity.getProfileImgUrl()); }
        if (Objects.nonNull(entity.getProfileWidth())) { domain.setProfileWidth(entity.getProfileWidth()); }
        if (Objects.nonNull(entity.getProfileHeight())) { domain.setProfileHeight(entity.getProfileHeight()); }
        if (StringUtils.hasText(entity.getProfileTitle())) { domain.setProfileTitle(entity.getProfileTitle()); }
        if (StringUtils.hasText(entity.getImgtitleYn())) { domain.setImgTitleYn(entity.getImgtitleYn()); }
        if (StringUtils.hasText(entity.getImgtitleTitle())) { domain.setImgTitleTitle(entity.getImgtitleTitle()); }
        if (StringUtils.hasText(entity.getImgtitleDesc())) { domain.setImgTitleDesc(entity.getImgtitleDesc()); }
        if (StringUtils.hasText(entity.getImgtitleImgUrl())) { domain.setImgTitleImgUrl(entity.getImgtitleImgUrl()); }
        if (StringUtils.hasText(entity.getItemlistAlign())) { domain.setItemListAlign(entity.getItemlistAlign()); }
        if (StringUtils.hasText(entity.getItemlistSummaryYn())) { domain.setItemListSummaryYn(entity.getItemlistSummaryYn()); }
        if (StringUtils.hasText(entity.getItemlistSummaryTitle())) { domain.setItemListSummaryTitle(entity.getItemlistSummaryTitle()); }
        if (StringUtils.hasText(entity.getItemlistSummaryDesc())) { domain.setItemListSummaryDesc(entity.getItemlistSummaryDesc()); }
        if (StringUtils.hasText(entity.getTitle())) { domain.setTitle(entity.getTitle()); }
        if (StringUtils.hasText(entity.getDesc())) { domain.setDesc(entity.getDesc()); }
        if (StringUtils.hasText(entity.getBtnLayout())) { domain.setBtnLayout(entity.getBtnLayout()); }
        if (Objects.nonNull(entity.getSkillResV1TemplateCarouselEntity()) && Objects.nonNull(entity.getSkillResV1TemplateCarouselEntity().getCarouselId())) {
            domain.setCarouselId(entity.getSkillResV1TemplateCarouselEntity().getCarouselId());
        }
        logger.info("setSkillResV1TemplateItemCardDomainCache^^SkillResV1TemplateItemCardDomain :: {}", domain.toString());
        return domain;
    }

    @CacheEvict(value = "SkillResV1TemplateItemCardDomain", key = "#componentId")
    public void deleteSkillResV1TemplateItemCardDomainCache(String componentId) {
        logger.info("SkillResV1TemplateItemCardDomain Cache is deleted ... componentId : {}", componentId);
    }

}
