package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.entity.*;
import com.ebson.skillserver.v1.channels.FP.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class SkillResponseTemplateCacheService {

    private static final Logger logger = LoggerFactory.getLogger(SkillResponseTemplateCacheService.class);

    @Autowired
    private SkillResV1TemplateCacheService skillResV1TemplateCacheService;

    @Autowired
    private SkillResV1TemplateEntityRepository skillResV1TemplateEntityRepository;

    @Autowired
    private SkillResV1TemplateOutputCacheService skillResV1TemplateOutputCacheService;

    @Autowired
    private SkillResV1TemplateOutputEntityRepository skillResV1TemplateOutputEntityRepository;

    @Autowired
    private SkillResV1TemplateComponentCacheService skillResV1TemplateComponentCacheService;

    @Autowired
    private SkillResV1TemplateComponentEntityRepository skillResV1TemplateComponentEntityRepository;

    @Autowired
    private SkillResV1TemplateCarouselCacheService skillResV1TemplateCarouselCacheService;

    @Autowired
    private SkillResV1TemplateCarouselEntityRepository skillResV1TemplateCarouselEntityRepository;


    @Transactional
    @EventListener(value= ApplicationReadyEvent.class)
    public void init1() {
        logger.info("SkillResV1TemplateCacheService initialized : no 1 ... ");
        List<SkillResV1TemplateEntity> list1 = skillResV1TemplateEntityRepository.findAll();
        for (SkillResV1TemplateEntity entity : list1) {
            skillResV1TemplateCacheService.setSkillResV1TemplateDomainCache(UUIDFormatter.formatToUUID(entity.getTemplateId().toString()));
        }
        List<SkillResV1TemplateOutputEntity> list2 = skillResV1TemplateOutputEntityRepository.findAll();
        for (SkillResV1TemplateOutputEntity entity : list2) {
            skillResV1TemplateOutputCacheService.setSkillResV1TemplateOutputDomainCache(UUIDFormatter.formatToUUID(entity.getOutputId().toString()));
        }
        List<SkillResV1TemplateComponentEntity> list3 = skillResV1TemplateComponentEntityRepository.findAll();
        for (SkillResV1TemplateComponentEntity entity : list3) {
            skillResV1TemplateComponentCacheService.setSkillResV1TemplateComponentDomainCache(UUIDFormatter.formatToUUID(entity.getComponentId().toString()));
        }
        List<SkillResV1TemplateCarouselEntity> list4 = skillResV1TemplateCarouselEntityRepository.findAll();
        for (SkillResV1TemplateCarouselEntity entity : list4) {
            skillResV1TemplateCarouselCacheService.setSkillResV1TemplateCarouselDomainCache(UUIDFormatter.formatToUUID(entity.getCarouselId().toString()));
        }
    }

    @Autowired
    private SkillResV1TemplateSimpleTextEntityRepository skillResV1TemplateSimpleTextEntityRepository;

    @Autowired
    private SkillResV1TemplateSimpleTextCacheService skillResV1TemplateSimpleTextCacheService;

    @Autowired
    private SkillResV1TemplateSimpleImageEntityRepository skillResV1TemplateSimpleImageEntityRepository;

    @Autowired
    private SkillResV1TemplateSimpleImageCacheService skillResV1TemplateSimpleImageCacheService;

    @Autowired
    private SkillResV1TemplateTextCardEntityRepository skillResV1TemplateTextCardEntityRepository;

    @Autowired
    private SkillResV1TemplateTextCardCacheService skillResV1TemplateTextCardCacheService;

    @Autowired
    private SkillResV1TemplateBasicCardEntityRepository skillResV1TemplateBasicCardEntityRepository;

    @Autowired
    private SkillResV1TemplateBasicCardCacheService skillResV1TemplateBasicCardCacheService;

    @Transactional
    @EventListener(value= ApplicationReadyEvent.class)
    public void init2() {
        logger.info("SkillResV1TemplateCacheService initialized : no 2 ... ");
        List<SkillResV1TemplateSimpleTextEntity> list1 = skillResV1TemplateSimpleTextEntityRepository.findAll();
        for (SkillResV1TemplateSimpleTextEntity entity : list1) {
            skillResV1TemplateSimpleTextCacheService.setSkillResV1TemplateSimpleTextDomainCache(UUIDFormatter.formatToUUID(entity.getComponentId().toString()));
        }
        List<SkillResV1TemplateSimpleImageEntity> list2 = skillResV1TemplateSimpleImageEntityRepository.findAll();
        for (SkillResV1TemplateSimpleImageEntity entity : list2) {
            skillResV1TemplateSimpleImageCacheService.setSkillResV1TemplateSimpleImageDomainCache(UUIDFormatter.formatToUUID(entity.getComponentId().toString()));
        }
        List<SkillResV1TemplateTextCardEntity> list3 = skillResV1TemplateTextCardEntityRepository.findAll();
        for (SkillResV1TemplateTextCardEntity entity : list3) {
            skillResV1TemplateTextCardCacheService.setSkillResV1TemplateTextCardDomainCache(UUIDFormatter.formatToUUID(entity.getComponentId().toString()));
        }
        List<SkillResV1TemplateBasicCardEntity> list4 = skillResV1TemplateBasicCardEntityRepository.findAll();
        for (SkillResV1TemplateBasicCardEntity entity : list4) {
            skillResV1TemplateBasicCardCacheService.setSkillResV1TemplateBasicCardDomainCache(UUIDFormatter.formatToUUID(entity.getComponentId().toString()));
        }
    }

    @Autowired
    private SkillResV1TemplateCommerceCardEntityRepository skillResV1TemplateCommerceCardEntityRepository;

    @Autowired
    private SkillResV1TemplateCommerceCardCacheService skillResV1TemplateCommerceCardCacheService;

    @Autowired
    private SkillResV1TemplateItemCardEntityRepository skillResV1TemplateItemCardEntityRepository;

    @Autowired
    private SkillResV1TemplateItemCardCacheService skillResV1TemplateItemCardCacheService;

    @Autowired
    private SkillResV1TemplateItemCardItemListEntityRepository skillResV1TemplateItemCardItemListEntityRepository;

    @Autowired
    private SkillResV1TemplateItemCardItemListCacheService skillResV1TemplateItemCardItemListCacheService;

    @Transactional
    @EventListener(value= ApplicationReadyEvent.class)
    public void init3() {
        logger.info("SkillResV1TemplateCacheService initialized : no 3 ... ");
        List<SkillResV1TemplateCommerceCardEntity> list1 = skillResV1TemplateCommerceCardEntityRepository.findAll();
        for (SkillResV1TemplateCommerceCardEntity entity : list1) {
            skillResV1TemplateCommerceCardCacheService.setSkillResV1TemplateCommerceCardDomainCache(UUIDFormatter.formatToUUID(entity.getComponentId().toString()));
        }
        List<SkillResV1TemplateItemCardEntity> list2 = skillResV1TemplateItemCardEntityRepository.findAll();
        for (SkillResV1TemplateItemCardEntity entity : list2) {
            skillResV1TemplateItemCardCacheService.setSkillResV1TemplateItemCardDomainCache(UUIDFormatter.formatToUUID(entity.getComponentId().toString()));
        }
        List<SkillResV1TemplateItemCardItemListEntity> list3 = skillResV1TemplateItemCardItemListEntityRepository.findAll();
        for (SkillResV1TemplateItemCardItemListEntity entity : list3) {
            skillResV1TemplateItemCardItemListCacheService.setSkillResV1TemplateItemCardItemListDomainCache(UUIDFormatter.formatToUUID(entity.getItemlistId().toString()));
        }
    }

    @Autowired
    private SkillResV1TemplateListCardCacheService skillResV1TemplateListCardCacheService;

    @Autowired
    private SkillResV1TemplateListCardEntityRepository skillResV1TemplateListCardEntityRepository;

    @Autowired
    private SkillResV1TemplateListCardListItemCacheService skillResV1TemplateListCardListItemCacheService;

    @Autowired
    private SkillResV1TemplateListCardListItemEntityRepository skillResV1TemplateListCardListItemEntityRepository;

    @Autowired
    private SkillResV1TemplateListCardListItemExtraCacheService skillResV1TemplateListCardListItemExtraCacheService;

    @Autowired
    private SkillResV1TemplateListCardListItemExtraEntityRepository skillResV1TemplateListCardListItemExtraEntityRepository;

    @Autowired
    private SkillResV1TemplateQrplCacheService skillResV1TemplateQrplCacheService;

    @Autowired
    private SkillResV1TemplateQrplEntityRepository skillResV1TemplateQrplEntityRepository;

    @Autowired
    private SkillResV1TemplateQrplExtraCacheService skillResV1TemplateQrplExtraCacheService;

    @Autowired
    private SkillResV1TemplateQrplExtraEntityRepository skillResV1TemplateQrplExtraEntityRepository;

    @Transactional
    @EventListener(value= ApplicationReadyEvent.class)
    public void init4() {
        logger.info("SkillResV1TemplateCacheService initialized : no 4 ... ");
        List<SkillResV1TemplateListCardEntity> list1 = skillResV1TemplateListCardEntityRepository.findAll();
        for (SkillResV1TemplateListCardEntity entity : list1) {
            skillResV1TemplateListCardCacheService.setSkillResV1TemplateListCardDomainCache(UUIDFormatter.formatToUUID(entity.getComponentId().toString()));
        }
        List<SkillResV1TemplateListCardListItemEntity> list2 = skillResV1TemplateListCardListItemEntityRepository.findAll();
        for (SkillResV1TemplateListCardListItemEntity entity : list2) {
            skillResV1TemplateListCardListItemCacheService.setSkillResV1TemplateListCardListItemDomainCache(UUIDFormatter.formatToUUID(entity.getListItemId().toString()));
        }
        List<SkillResV1TemplateListCardListItemExtraEntity> list3 = skillResV1TemplateListCardListItemExtraEntityRepository.findAll();
        for (SkillResV1TemplateListCardListItemExtraEntity entity : list3) {
            skillResV1TemplateListCardListItemExtraCacheService.setSkillResV1TemplateListCardListItemExtraDomainCache(UUIDFormatter.formatToUUID(entity.getExtraId().toString()));
        }
        List<SkillResV1TemplateQrplEntity> list4 = skillResV1TemplateQrplEntityRepository.findAll();
        for (SkillResV1TemplateQrplEntity entity : list4) {
            skillResV1TemplateQrplCacheService.setSkillResV1TemplateQrplDomainCache(UUIDFormatter.formatToUUID(entity.getQrplId().toString()));
        }
        List<SkillResV1TemplateQrplExtraEntity> list5 = skillResV1TemplateQrplExtraEntityRepository.findAll();
        for (SkillResV1TemplateQrplExtraEntity entity : list5) {
            skillResV1TemplateQrplExtraCacheService.setSkillResV1TemplateQrplExtraDomainCache(UUIDFormatter.formatToUUID(entity.getExtraId().toString()));
        }
    }

}

