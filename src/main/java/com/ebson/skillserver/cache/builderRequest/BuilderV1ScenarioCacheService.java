package com.ebson.skillserver.cache.builderRequest;

import com.ebson.skillserver.v1.channels.FP.domain.BuilderV1ScenarioDomain;
import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1ScenarioEntity;
import com.ebson.skillserver.v1.channels.FP.repository.BuilderV1ScenarioEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BuilderV1ScenarioCacheService {

    private static final Logger logger = LoggerFactory.getLogger(BuilderV1ScenarioCacheService.class);

    @Autowired
    BuilderV1ScenarioEntityRepository repository;

    @Cacheable(value = "BuilderV1ScenarioDomain", key = "#channelName + ':' + #scenarioId + ':' + #scenarioCode")
    public BuilderV1ScenarioDomain getBuilderV1ScenarioDomainCache(String channelName
                                                               , String scenarioId
                                                               , String scenarioCode) {
        BuilderV1ScenarioEntity bvse = repository.getReferenceById(scenarioId);
        BuilderV1ScenarioDomain bvsd = new BuilderV1ScenarioDomain();
        bvsd.setChannelId(bvse.getBuilderV1ChannelEntity().getChannelId());
        bvsd.setScenarioId(bvse.getScenarioId());
        bvsd.setScenarioCode(bvse.getScenarioCode());
        bvsd.setScenarioName(bvse.getScenarioName());
        logger.info("getBuilderV1ScenarioDomainCache^^BuilderV1ScenarioDomain :: {}", bvsd.toString());
        return bvsd;
    }

    @CachePut(value = "BuilderV1ScenarioDomain", key = "#channelName + ':' + #scenarioId + ':' + #scenarioCode")
    public BuilderV1ScenarioDomain setBuilderV1ScenarioDomainCache(String channelName
                                                                , String scenarioId
                                                                , String scenarioCode) {
        BuilderV1ScenarioEntity bvse = repository.getReferenceById(scenarioId);
        BuilderV1ScenarioDomain bvsd = new BuilderV1ScenarioDomain();
        bvsd.setChannelId(bvse.getBuilderV1ChannelEntity().getChannelId());
        bvsd.setScenarioId(bvse.getScenarioId());
        bvsd.setScenarioCode(bvse.getScenarioCode());
        bvsd.setScenarioName(bvse.getScenarioName());
        logger.info("setBuilderV1ScenarioDomainCache^^BuilderV1ScenarioDomain :: {}", bvsd.toString());
        return bvsd;
    }

    @CacheEvict(value = "BuilderV1ScenarioDomain", key = "#channelName + ':' + #scenarioId + ':' + #scenarioCode")
    public void deleteBuilderV1ScenarioDomainCache(String channelName
                                                 , String scenarioId
                                                 , String scenarioCode) {}

}
