package com.ebson.skillserver.cache.builderRequest;

import com.ebson.skillserver.v1.channels.FP.domain.BuilderV1ScenarioDomain;
import com.ebson.skillserver.v1.channels.FP.repository.BuilderV1ScenarioEntityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BuilderV1ScenarioCacheServiceTest {

    @Autowired
    private BuilderV1ScenarioCacheService service;

    @Autowired
    private BuilderV1ScenarioEntityRepository repository;

    @Test
    @Transactional
    public void getBuilderV1ScenarioDomainCacheTest() {
        String channelName = "FP";
        String scenarioId = "6590ab21193392115b5a7ff5";
        String scenarioCode = "FP_S01";

        BuilderV1ScenarioDomain domain = service.getBuilderV1ScenarioDomainCache(channelName, scenarioId, scenarioCode);
        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getScenarioName(), "테스트 시나리오");
    }

    @Test
    @Transactional
    public void setBuilderV1ScenarioDomainCacheTest() {
        String channelName = "FP";
        String scenarioId = "6590ab21193392115b5a7ff5";
        String scenarioCode = "FP_S01";

        BuilderV1ScenarioDomain domain = service.setBuilderV1ScenarioDomainCache(channelName, scenarioId, scenarioCode);
        Assertions.assertNotNull(domain);
        Assertions.assertEquals(domain.getScenarioName(), "테스트 시나리오");
    }

    @Test
    public void deleteBuilderV1ScenarioDomainCacheTest() {
        String channelName = "FP";
        String scenarioId = "6590ab21193392115b5a7ff5";
        String scenarioCode = "FP_S01";
        service.deleteBuilderV1ScenarioDomainCache(channelName, scenarioId, scenarioCode);
    }

}
