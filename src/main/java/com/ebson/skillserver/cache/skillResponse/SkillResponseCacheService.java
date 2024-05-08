package com.ebson.skillserver.cache.skillResponse;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1ContextEntity;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1ContextParamEntity;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1DataEntity;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1VersionEntity;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1ContextEntityRepository;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1ContextParamEntityRepository;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1DataEntityRepository;
import com.ebson.skillserver.v1.channels.FP.repository.SkillResV1VersionEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SkillResponseCacheService {

    private static final Logger logger = LoggerFactory.getLogger(SkillResponseCacheService.class);

    @Autowired
    private SkillResV1ContextCacheService skillResV1ContextCacheService;

    @Autowired
    private SkillResV1ContextEntityRepository skillResV1ContextEntityRepository;

    @Autowired
    private SkillResV1ContextParamCacheService skillResV1ContextParamCacheService;

    @Autowired
    private SkillResV1ContextParamEntityRepository skillResV1ContextParamEntityRepository;

    @Autowired
    private SkillResV1DataCacheService skillResV1DataCacheService;

    @Autowired
    private SkillResV1DataEntityRepository skillResV1DataEntityRepository;

    @Autowired
    private SkillResV1VersionCacheService skillResV1VersionCacheService;

    @Autowired
    private SkillResV1VersionEntityRepository skillResV1VersionEntityRepository;

    @Transactional
    @EventListener(value= ApplicationReadyEvent.class)
    public void init() {
        List<SkillResV1ContextEntity> list1 = skillResV1ContextEntityRepository.findAll();
        for (SkillResV1ContextEntity entity : list1) {
            skillResV1ContextCacheService.setSkillResV1ContextDomainCache(UUIDFormatter.formatToUUID(entity.getContextId().toString()));
        }
        List<SkillResV1ContextParamEntity> list2 = skillResV1ContextParamEntityRepository.findAll();
        for (SkillResV1ContextParamEntity entity : list2) {
            skillResV1ContextParamCacheService.setSkillResV1ContextParamDomainCache(UUIDFormatter.formatToUUID(entity.getContextId().toString()), entity.getParamNo());
        }
        List<SkillResV1DataEntity> list3 = skillResV1DataEntityRepository.findAll();
        for (SkillResV1DataEntity entity : list3) {
            skillResV1DataCacheService.setSkillResV1DataDomainCache(UUIDFormatter.formatToUUID(entity.getDataId().toString()));
        }
        List<SkillResV1VersionEntity> list4 = skillResV1VersionEntityRepository.findAll();
        for (SkillResV1VersionEntity entity : list4) {
            skillResV1VersionCacheService.setSkillResV1VersionDomainCache(UUIDFormatter.formatToUUID(entity.getVersionId().toString()));
        }
    }

}


