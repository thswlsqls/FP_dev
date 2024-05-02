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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BuilderV1ScenarioCacheService {

    private static final Logger logger = LoggerFactory.getLogger(BuilderV1ScenarioCacheService.class);

    @Autowired
    BuilderV1ScenarioEntityRepository repository;

    @Cacheable(value = "BuilderV1ScenarioDomain", key = "#scenarioId")
    public BuilderV1ScenarioDomain getBuilderV1ScenarioDomainCache(String scenarioId) {
        BuilderV1ScenarioEntity bvse = repository.getReferenceById(scenarioId);
        BuilderV1ScenarioDomain bvsd = new BuilderV1ScenarioDomain();
        bvsd.setChannelId(bvse.getBuilderV1ChannelEntity().getChannelId());
        bvsd.setScenarioId(bvse.getScenarioId());
        bvsd.setScenarioCode(bvse.getScenarioCode());
        bvsd.setScenarioName(bvse.getScenarioName());
        logger.info("getBuilderV1ScenarioDomainCache^^BuilderV1ScenarioDomain :: {}", bvsd.toString());
        return bvsd;
    }

    @CachePut(value = "BuilderV1ScenarioDomain", key = "#scenarioId")
    public BuilderV1ScenarioDomain setBuilderV1ScenarioDomainCache(String scenarioId) {
        BuilderV1ScenarioEntity bvse = repository.getReferenceById(scenarioId);
        BuilderV1ScenarioDomain bvsd = new BuilderV1ScenarioDomain();
        bvsd.setChannelId(bvse.getBuilderV1ChannelEntity().getChannelId());
        bvsd.setScenarioId(bvse.getScenarioId());
        bvsd.setScenarioCode(bvse.getScenarioCode());
        bvsd.setScenarioName(bvse.getScenarioName());
        logger.info("setBuilderV1ScenarioDomainCache^^BuilderV1ScenarioDomain :: {}", bvsd.toString());
        return bvsd;
    }

    @CacheEvict(value = "BuilderV1ScenarioDomain", key = "#scenarioId")
    public void deleteBuilderV1ScenarioDomainCache(String scenarioId) {
        logger.info("BuilderV1ScenarioDomain Cache is deleted ... scenarioId : {}", scenarioId);
    }

    @Transactional
    public void setAllBuilderV1ScenarioDomainCache() {
        List<BuilderV1ScenarioEntity> list2 = repository.findAll();
        for (BuilderV1ScenarioEntity entity : list2) {
            String scenarioId = entity.getScenarioId();
            setBuilderV1ScenarioDomainCache(scenarioId);
        }
    }

}
