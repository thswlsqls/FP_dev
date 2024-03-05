package com.ebson.skillserver.v1.channels.FP.mapper;

import com.ebson.skillserver.v1.channels.FP.domain.BuilderV1ScenarioDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.UUID;

@Mapper
public interface BuilderV1ScenarioDomainMapper {
    BuilderV1ScenarioDomain selectByScenarioId(String scenarioId);
    List<BuilderV1ScenarioDomain> selectAll();
    void insertBuilderV1Scenario(BuilderV1ScenarioDomain builderV1ScenarioDomain);
    void updateBuilderV1Scenario(BuilderV1ScenarioDomain builderV1ScenarioDomain);
    void deleteByScenarioId(String scenarioId);
}
