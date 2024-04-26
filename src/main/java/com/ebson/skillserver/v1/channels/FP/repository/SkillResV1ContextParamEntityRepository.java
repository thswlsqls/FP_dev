package com.ebson.skillserver.v1.channels.FP.repository;

import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1ContextParamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SkillResV1ContextParamEntityRepository extends JpaRepository<SkillResV1ContextParamEntity, SkillResV1ContextParamEntity.PK> {
    SkillResV1ContextParamEntity findByContextIdAndParamNo(UUID contextId, int paramNo);
}
