package com.ebson.skillserver.cache.builderRequest;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1BlockContextEntity;
import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1BlockEntity;
import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1ChannelEntity;
import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1ScenarioEntity;
import com.ebson.skillserver.v1.channels.FP.repository.BuilderV1BlockContextEntityRepository;
import com.ebson.skillserver.v1.channels.FP.repository.BuilderV1BlockEntityRepository;
import com.ebson.skillserver.v1.channels.FP.repository.BuilderV1ChannelEntityRepository;
import com.ebson.skillserver.v1.channels.FP.repository.BuilderV1ScenarioEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BuilderRequestCacheService {

    @Autowired
    private BuilderV1ChannelCacheService builderV1ChannelCacheService;

    @Autowired
    private BuilderV1ChannelEntityRepository bilderV1ChannelEntityRepository;

    @Autowired
    private BuilderV1ScenarioCacheService builderV1ScenarioCacheService;

    @Autowired
    private BuilderV1ScenarioEntityRepository builderV1ScenarioEntityRepository;

    @Autowired
    private BuilderV1BlockCacheService builderV1BlockCacheService;

    @Autowired
    private BuilderV1BlockEntityRepository builderV1BlockEntityRepository;

    @Autowired
    private BuilderV1BlockContextCacheService builderV1BlockContextCacheService;

    @Autowired
    private BuilderV1BlockContextEntityRepository builderV1BlockContextEntityRepository;

    @Transactional
    @EventListener(value=ApplicationReadyEvent.class)
    public void init() {
        List<BuilderV1ChannelEntity> list1 = bilderV1ChannelEntityRepository.findAll();
        for (BuilderV1ChannelEntity entity : list1) {
            builderV1ChannelCacheService.setBuilderV1ChannelDomainCache(UUIDFormatter.formatToUUID(entity.getChannelId().toString()));
        }
        List<BuilderV1ScenarioEntity> list2 = builderV1ScenarioEntityRepository.findAll();
        for (BuilderV1ScenarioEntity entity : list2) {
            builderV1ScenarioCacheService.setBuilderV1ScenarioDomainCache(entity.getScenarioId());
        }
        List<BuilderV1BlockEntity> list3 = builderV1BlockEntityRepository.findAll();
        for (BuilderV1BlockEntity entity : list3) {
            builderV1BlockCacheService.setBuilderV1BlockDomainCache(entity.getBlockId());
        }
        List<BuilderV1BlockContextEntity> list4 = builderV1BlockContextEntityRepository.findAll();
        for (BuilderV1BlockContextEntity entity : list4) {
            builderV1BlockContextCacheService.setBuilderV1BlockContextDomainCache(UUIDFormatter.formatToUUID(entity.getContextId().toString()));
        }
    }

    @Transactional
    public void initByQuartzJobTest() {
        List<BuilderV1ChannelEntity> list1 = bilderV1ChannelEntityRepository.findAll();
        for (BuilderV1ChannelEntity entity : list1) {
            builderV1ChannelCacheService.setBuilderV1ChannelDomainCache(UUIDFormatter.formatToUUID(entity.getChannelId().toString()));
        }
        List<BuilderV1ScenarioEntity> list2 = builderV1ScenarioEntityRepository.findAll();
        for (BuilderV1ScenarioEntity entity : list2) {
            builderV1ScenarioCacheService.setBuilderV1ScenarioDomainCache(entity.getScenarioId());
        }
        List<BuilderV1BlockEntity> list3 = builderV1BlockEntityRepository.findAll();
        for (BuilderV1BlockEntity entity : list3) {
            builderV1BlockCacheService.setBuilderV1BlockDomainCache(entity.getBlockId());
        }
        List<BuilderV1BlockContextEntity> list4 = builderV1BlockContextEntityRepository.findAll();
        for (BuilderV1BlockContextEntity entity : list4) {
            builderV1BlockContextCacheService.setBuilderV1BlockContextDomainCache(UUIDFormatter.formatToUUID(entity.getContextId().toString()));
        }
    }

}
