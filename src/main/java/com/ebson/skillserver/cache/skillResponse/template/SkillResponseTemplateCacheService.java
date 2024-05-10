package com.ebson.skillserver.cache.skillResponse.template;

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



    }


}
