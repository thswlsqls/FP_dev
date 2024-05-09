package com.ebson.skillserver.cache.skillResponse.template;

import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1TemplateOutputEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SkillResV1TemplateCacheService {

    private static final Logger logger = LoggerFactory.getLogger(SkillResV1TemplateCacheService.class);

    @Autowired
    private SkillResV1TemplateOutputCacheService skillResV1TemplateOutputCacheService;

    @Autowired
    private SkillResV1TemplateOutputEntityRepository skillResV1TemplateOutputEntityRepository;

    @Transactional
    @EventListener(value= ApplicationReadyEvent.class)
    public void init() {
        logger.info("SkillResV1TemplateCacheService initialized ... ");

    }


}
