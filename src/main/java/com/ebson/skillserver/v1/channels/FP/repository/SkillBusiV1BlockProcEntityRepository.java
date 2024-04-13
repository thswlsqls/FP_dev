package com.ebson.skillserver.v1.channels.FP.repository;

import com.ebson.skillserver.v1.channels.FP.entity.SkillBusiV1BlockProcEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SkillBusiV1BlockProcEntityRepository extends JpaRepository<SkillBusiV1BlockProcEntity, UUID> {
    SkillBusiV1BlockProcEntity findByBuilderV1BlockContextEntity_ContextId(UUID contextId);
}
