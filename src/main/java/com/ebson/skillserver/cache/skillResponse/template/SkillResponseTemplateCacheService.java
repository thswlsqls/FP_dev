package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateCarouselEntity;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateComponentEntity;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateEntity;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateOutputEntity;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1TemplateCarouselEntityRepository;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1TemplateComponentEntityRepository;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1TemplateEntityRepository;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1TemplateOutputEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void init() {
        logger.info("SkillResV1TemplateCacheService initialized ... ");
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


}
