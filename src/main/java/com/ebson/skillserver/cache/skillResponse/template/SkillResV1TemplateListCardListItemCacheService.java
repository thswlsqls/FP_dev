package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1TemplateListCardListItemDomain;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateListCardListItemEntity;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1TemplateListCardListItemEntityRepository;
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
public class SkillResV1TemplateListCardListItemCacheService {

    private static final Logger logger = LoggerFactory.getLogger(SkillResV1TemplateListCardListItemCacheService.class);

    @Autowired
    SkillResV1TemplateListCardListItemEntityRepository repository;

    @Cacheable(value = "SkillResV1TemplateListCardListItemDomain", key = "#listitemId")
    public SkillResV1TemplateListCardListItemDomain getSkillResV1TemplateListCardListItemDomainCache(String listitemId) {
        SkillResV1TemplateListCardListItemEntity entity = repository.getReferenceById(UUID.fromString(listitemId));
        SkillResV1TemplateListCardListItemDomain domain = new SkillResV1TemplateListCardListItemDomain();
        if (Objects.nonNull(entity.getListItemId())) { domain.setListItemId(entity.getListItemId()); }
        if (Objects.nonNull(entity.getListItemOrd())) { domain.setListItemOrd(entity.getListItemOrd()); }
        if (StringUtils.hasText(entity.getHeaderYn())) { domain.setHeaderYn(entity.getHeaderYn()); }
        if (StringUtils.hasText(entity.getTitle())) { domain.setTitle(entity.getTitle()); }
        if (StringUtils.hasText(entity.getDesc())) { domain.setDesc(entity.getDesc()); }
        if (StringUtils.hasText(entity.getImgUrl())) { domain.setImgUrl(entity.getImgUrl()); }
        if (StringUtils.hasText(entity.getLinkPc())) { domain.setLinkPc(entity.getLinkPc()); }
        if (StringUtils.hasText(entity.getLinkMobile())) { domain.setLinkMobile(entity.getLinkMobile()); }
        if (StringUtils.hasText(entity.getLinkWeb())) { domain.setLinkWeb(entity.getLinkWeb()); }
        if (StringUtils.hasText(entity.getAction())) { domain.setAction(entity.getAction()); }
        if (StringUtils.hasText(entity.getBlockId())) { domain.setBlockId(entity.getBlockId()); }
        if (StringUtils.hasText(entity.getMessageText())) { domain.setMessageText(entity.getMessageText()); }
        if (Objects.nonNull(entity.getSkillResV1TemplateListCardEntity()) && Objects.nonNull(entity.getSkillResV1TemplateListCardEntity().getComponentId()) ) {
            domain.setComponentId(entity.getSkillResV1TemplateListCardEntity().getComponentId());
        }
        logger.info("getSkillResV1TemplateListCardListItemDomainCache^^SkillResV1TemplateListCardListItemDomain :: {}", domain.toString());
        return domain;
    }

    @CachePut(value = "SkillResV1TemplateListCardListItemDomain", key = "#listitemId")
    public SkillResV1TemplateListCardListItemDomain setSkillResV1TemplateListCardListItemDomainCache(String listitemId) {
        SkillResV1TemplateListCardListItemEntity entity = repository.getReferenceById(UUID.fromString(listitemId));
        SkillResV1TemplateListCardListItemDomain domain = new SkillResV1TemplateListCardListItemDomain();
        if (Objects.nonNull(entity.getListItemId())) { domain.setListItemId(entity.getListItemId()); }
        if (Objects.nonNull(entity.getListItemOrd())) { domain.setListItemOrd(entity.getListItemOrd()); }
        if (StringUtils.hasText(entity.getHeaderYn())) { domain.setHeaderYn(entity.getHeaderYn()); }
        if (StringUtils.hasText(entity.getTitle())) { domain.setTitle(entity.getTitle()); }
        if (StringUtils.hasText(entity.getDesc())) { domain.setDesc(entity.getDesc()); }
        if (StringUtils.hasText(entity.getImgUrl())) { domain.setImgUrl(entity.getImgUrl()); }
        if (StringUtils.hasText(entity.getLinkPc())) { domain.setLinkPc(entity.getLinkPc()); }
        if (StringUtils.hasText(entity.getLinkMobile())) { domain.setLinkMobile(entity.getLinkMobile()); }
        if (StringUtils.hasText(entity.getLinkWeb())) { domain.setLinkWeb(entity.getLinkWeb()); }
        if (StringUtils.hasText(entity.getAction())) { domain.setAction(entity.getAction()); }
        if (StringUtils.hasText(entity.getBlockId())) { domain.setBlockId(entity.getBlockId()); }
        if (StringUtils.hasText(entity.getMessageText())) { domain.setMessageText(entity.getMessageText()); }
        if (Objects.nonNull(entity.getSkillResV1TemplateListCardEntity()) && Objects.nonNull(entity.getSkillResV1TemplateListCardEntity().getComponentId()) ) {
            domain.setComponentId(entity.getSkillResV1TemplateListCardEntity().getComponentId());
        }
        logger.info("getSkillResV1TemplateListCardListItemDomainCache^^SkillResV1TemplateListCardListItemDomain :: {}", domain.toString());
        return domain;
    }

    @CacheEvict(value = "SkillResV1TemplateListCardListItemDomain", key = "#listitemId")
    public void deleteSkillResV1TemplateListCardListItemDomainCache(String listitemId) {
        logger.info("SkillResV1TemplateListCardListItemDomain Cache is deleted ... listitemId : {}", listitemId);
    }

}
