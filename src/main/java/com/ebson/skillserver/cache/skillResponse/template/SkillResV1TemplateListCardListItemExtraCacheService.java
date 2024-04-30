package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateListCardListItemDomain;
import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateListCardListItemExtraDomain;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateListCardListItemExtraEntity;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1TemplateListCardListItemExtraEntityRepository;
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
public class SkillResV1TemplateListCardListItemExtraCacheService {

    private static final Logger logger = LoggerFactory.getLogger(SkillResV1TemplateListCardListItemExtraCacheService.class);

    @Autowired
    SkillResV1TemplateListCardListItemExtraEntityRepository repository;

    @Cacheable(value = "SkillResV1TemplateListCardListItemExtraDomain", key = "#extraId")
    public SkillResV1TemplateListCardListItemExtraDomain getSkillResV1TemplateListCardListItemExtraDomainCache(String extraId) {
        SkillResV1TemplateListCardListItemExtraEntity entity = repository.getReferenceById(UUID.fromString(extraId));
        SkillResV1TemplateListCardListItemExtraDomain domain = new SkillResV1TemplateListCardListItemExtraDomain();
        if (Objects.nonNull(entity.getExtraId())) { domain.setExtraId(entity.getExtraId()); }
        if (Objects.nonNull(entity.getListItemOrd())) { domain.setListItemOrd(entity.getListItemOrd()); }
        if (StringUtils.hasText(entity.getKey())) { domain.setKey(entity.getKey()); }
        if (StringUtils.hasText(entity.getValue())) { domain.setValue(entity.getValue()); }
        if (Objects.nonNull(entity.getSkillResV1TemplateListCardListItemEntity()) && Objects.nonNull(entity.getSkillResV1TemplateListCardListItemEntity().getListItemId())) {
            domain.setListItemId(entity.getSkillResV1TemplateListCardListItemEntity().getListItemId());
        }
        logger.info("getSkillResV1TemplateListCardListItemExtraDomainCache^^SkillResV1TemplateListCardListItemExtraDomain :: {}", domain.toString());
        return domain;
    }

    @CachePut(value = "SkillResV1TemplateListCardListItemExtraDomain", key = "#extraId")
    public SkillResV1TemplateListCardListItemExtraDomain setSkillResV1TemplateListCardListItemExtraDomainCache(String extraId) {
        SkillResV1TemplateListCardListItemExtraEntity entity = repository.getReferenceById(UUID.fromString(extraId));
        SkillResV1TemplateListCardListItemExtraDomain domain = new SkillResV1TemplateListCardListItemExtraDomain();
        if (Objects.nonNull(entity.getExtraId())) { domain.setExtraId(entity.getExtraId()); }
        if (Objects.nonNull(entity.getListItemOrd())) { domain.setListItemOrd(entity.getListItemOrd()); }
        if (StringUtils.hasText(entity.getKey())) { domain.setKey(entity.getKey()); }
        if (StringUtils.hasText(entity.getValue())) { domain.setValue(entity.getValue()); }
        if (Objects.nonNull(entity.getSkillResV1TemplateListCardListItemEntity()) && Objects.nonNull(entity.getSkillResV1TemplateListCardListItemEntity().getListItemId())) {
            domain.setListItemId(entity.getSkillResV1TemplateListCardListItemEntity().getListItemId());
        }
        logger.info("getSkillResV1TemplateListCardListItemExtraDomainCache^^SkillResV1TemplateListCardListItemExtraDomain :: {}", domain.toString());
        return domain;
    }

    @CacheEvict(value = "SkillResV1TemplateListCardListItemExtraDomain", key = "#extraId")
    public void deleteSkillResV1TemplateListCardListItemExtraDomainCache(String extraId) {
        logger.info("SkillResV1TemplateListCardListItemExtraDomain Cache is deleted ... extraId : {}", extraId);
    }

}
