package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateItemCardItemListDomain;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateItemCardItemListEntity;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1TemplateItemCardItemListEntityRepository;
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
public class SkillResV1TemplateItemCardItemListCacheService {

    private static final Logger logger = LoggerFactory.getLogger(SkillResV1TemplateItemCardItemListCacheService.class);

    @Autowired
    SkillResV1TemplateItemCardItemListEntityRepository repository;

    @Cacheable(value = "SkillResV1TemplateItemCardItemListDomain", key = "#itemlistId")
    public SkillResV1TemplateItemCardItemListDomain getSkillResV1TemplateItemCardItemListDomainCache(String itemlistId) {
        SkillResV1TemplateItemCardItemListEntity entity = repository.getReferenceById(UUID.fromString(itemlistId));
        SkillResV1TemplateItemCardItemListDomain domain = new SkillResV1TemplateItemCardItemListDomain();
        if (Objects.nonNull(entity.getItemlistId())) { domain.setItemListId(entity.getItemlistId()); }
        if (StringUtils.hasText(entity.getTitle())) { domain.setTitle(entity.getTitle()); }
        if (StringUtils.hasText(entity.getDesc())) { domain.setDesc(entity.getDesc()); }
        if (Objects.nonNull(entity.getSkillResV1TemplateItemCardEntity()) && Objects.nonNull(entity.getSkillResV1TemplateItemCardEntity().getComponentId())) {
            domain.setComponentId(entity.getSkillResV1TemplateItemCardEntity().getComponentId());
        }
        logger.info("getSkillResV1TemplateItemCardItemListDomainCache^^SkillResV1TemplateItemCardItemListDomain :: {}", domain.toString());
        return domain;
    }

    @CachePut(value = "SkillResV1TemplateItemCardItemListDomain", key = "#itemlistId")
    public SkillResV1TemplateItemCardItemListDomain setSkillResV1TemplateItemCardItemListDomainCache(String itemlistId) {
        SkillResV1TemplateItemCardItemListEntity entity = repository.getReferenceById(UUID.fromString(itemlistId));
        SkillResV1TemplateItemCardItemListDomain domain = new SkillResV1TemplateItemCardItemListDomain();
        if (Objects.nonNull(entity.getItemlistId())) { domain.setItemListId(entity.getItemlistId()); }
        if (StringUtils.hasText(entity.getTitle())) { domain.setTitle(entity.getTitle()); }
        if (StringUtils.hasText(entity.getDesc())) { domain.setDesc(entity.getDesc()); }
        if (Objects.nonNull(entity.getSkillResV1TemplateItemCardEntity()) && Objects.nonNull(entity.getSkillResV1TemplateItemCardEntity().getComponentId())) {
            domain.setComponentId(entity.getSkillResV1TemplateItemCardEntity().getComponentId());
        }
        logger.info("setSkillResV1TemplateItemCardItemListDomainCache^^SkillResV1TemplateItemCardItemListDomain :: {}", domain.toString());
        return domain;
    }

    @CacheEvict(value = "SkillResV1TemplateItemCardItemListDomain", key = "#itemlistId")
    public void deleteSkillResV1TemplateItemCardItemListDomainCache(String itemlistId) {
        logger.info("SkillResV1TemplateItemCardItemListDomain Cache is deleted ... itemlistId : {}", itemlistId);
    }
}
