package com.ebson.skillserver.cache.builderRequest;

import com.ebson.skillserver.v1.channels.FP.domain.BuilderV1ChannelDomain;
import com.ebson.skillserver.v1.channels.FP.domain.BuilderV1ScenarioDomain;
import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1ScenarioEntity;
import com.ebson.skillserver.v1.channels.FP.repository.BuilderV1ScenarioEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BuilderV1ScenarioCacheService {

    @Autowired
    BuilderV1ScenarioEntityRepository repository;

    @CachePut(value = "BuilderV1ScenarioDomains", key = "'BuilderV1ScenarioDomain:' + #channelName + ':' + #scenarioId + ':' + #scenarioCode")
    public BuilderV1ScenarioDomain getBuilderV1ChannelDomainCache(String channelName
                                                               , String scenarioId
                                                               , String scenarioCode) {
        BuilderV1ScenarioEntity bvse = repository.getReferenceById(scenarioId);
        BuilderV1ScenarioDomain bvsd = new BuilderV1ScenarioDomain();
        bvsd.setChannelId(bvse.getBuilderV1ChannelEntity().getChannelId());
        bvsd.setScenarioId(bvse.getScenarioId());
        bvsd.setScenarioCode(bvse.getScenarioCode());
        bvsd.setScenarioName(bvse.getScenarioName());
        return bvsd;
    }

    @CachePut(value = "BuilderV1ScenarioDomains", key = "'BuilderV1ScenarioDomain:' + #channelName + ':' + #scenarioId + ':' + #scenarioCode")
    public BuilderV1ScenarioDomain setBuilderV1ChannelDomainCache(String channelName
            , String scenarioId
            , String scenarioCode) {
        BuilderV1ScenarioEntity bvse = repository.getReferenceById(scenarioId);
        BuilderV1ScenarioDomain bvsd = new BuilderV1ScenarioDomain();
        bvsd.setChannelId(bvse.getBuilderV1ChannelEntity().getChannelId());
        bvsd.setScenarioId(bvse.getScenarioId());
        bvsd.setScenarioCode(bvse.getScenarioCode());
        bvsd.setScenarioName(bvse.getScenarioName());
        return bvsd;
    }

    @CacheEvict(value = "BuilderV1ScenarioDomains", key = "'BuilderV1ScenarioDomain:' + #channelName + ':' + #scenarioId + ':' + #scenarioCode")
    public void deleteBuilderV1ChannelDomainCache() {}

}
