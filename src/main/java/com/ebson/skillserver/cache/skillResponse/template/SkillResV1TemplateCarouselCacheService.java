package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateCarouselDomain;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateCarouselEntity;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1TemplateCarouselEntityRepository;
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
public class SkillResV1TemplateCarouselCacheService {

    private static final Logger logger = LoggerFactory.getLogger(SkillResV1TemplateCarouselCacheService.class);

    @Autowired
    SkillResV1TemplateCarouselEntityRepository repository;

    @Cacheable(value = "SkillResV1TemplateCarouselDomain", key = "#carouselId")
    public SkillResV1TemplateCarouselDomain getSkillResV1TemplateCarouselDomainCache(String carouselId) {
        SkillResV1TemplateCarouselEntity entity = repository.getReferenceById(UUID.fromString(carouselId));
        SkillResV1TemplateCarouselDomain domain = new SkillResV1TemplateCarouselDomain();
        if (Objects.nonNull(entity.getCarouselId())) { domain.setCarouselId(entity.getCarouselId()); }
        if (StringUtils.hasText(entity.getCardType())) { domain.setCardType(entity.getCardType()); }
        if (StringUtils.hasText(entity.getHeaderTitle())) { domain.setHeaderTitle(entity.getHeaderTitle()); }
        if (StringUtils.hasText(entity.getHeaderDesc())) { domain.setHeaderDesc(entity.getHeaderDesc()); }
        if (StringUtils.hasText(entity.getHeaderThumb())) { domain.setHeaderThumb(entity.getHeaderThumb()); }
        if (Objects.nonNull(entity.getSkillResV1TemplateComponentEntity()) && Objects.nonNull(entity.getSkillResV1TemplateComponentEntity().getComponentId())) {
            domain.setComponentId(entity.getSkillResV1TemplateComponentEntity().getComponentId());
        }
        logger.info("getSkillResV1TemplateCarouselDomainCache^^SkillResV1TemplateCarouselDomain :: {}", domain.toString());
        return domain;
    }

    @CachePut(value = "SkillResV1TemplateCarouselDomain", key = "#carouselId")
    public SkillResV1TemplateCarouselDomain setSkillResV1TemplateCarouselDomainCache(String carouselId) {
        SkillResV1TemplateCarouselEntity entity = repository.getReferenceById(UUID.fromString(carouselId));
        SkillResV1TemplateCarouselDomain domain = new SkillResV1TemplateCarouselDomain();
        if (Objects.nonNull(entity.getCarouselId())) { domain.setCarouselId(entity.getCarouselId()); }
        if (StringUtils.hasText(entity.getCardType())) { domain.setCardType(entity.getCardType()); }
        if (StringUtils.hasText(entity.getHeaderTitle())) { domain.setHeaderTitle(entity.getHeaderTitle()); }
        if (StringUtils.hasText(entity.getHeaderDesc())) { domain.setHeaderDesc(entity.getHeaderDesc()); }
        if (StringUtils.hasText(entity.getHeaderThumb())) { domain.setHeaderThumb(entity.getHeaderThumb()); }
        if (Objects.nonNull(entity.getSkillResV1TemplateComponentEntity()) && Objects.nonNull(entity.getSkillResV1TemplateComponentEntity().getComponentId())) {
            domain.setComponentId(entity.getSkillResV1TemplateComponentEntity().getComponentId());
        }
        logger.info("setSkillResV1TemplateCarouselDomainCache^^SkillResV1TemplateCarouselDomain :: {}", domain.toString());
        return domain;
    }

    @CacheEvict(value = "SkillResV1TemplateCarouselDomain", key = "#carouselId")
    public void deleteSkillResV1TemplateCarouselDomainCache(String carouselId) {
        logger.info("SkillResV1TemplateCarouselDomain Cache is deleted ... carouselId : {}", carouselId);
    }

}
