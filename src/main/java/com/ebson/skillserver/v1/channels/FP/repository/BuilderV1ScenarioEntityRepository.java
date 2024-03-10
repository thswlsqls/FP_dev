package com.ebson.skillserver.v1.channels.FP.repository;

import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1ScenarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BuilderV1ScenarioEntityRepository extends JpaRepository<BuilderV1ScenarioEntity, String>  {
}
