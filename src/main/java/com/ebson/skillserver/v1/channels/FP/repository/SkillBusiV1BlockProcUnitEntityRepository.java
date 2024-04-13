package com.ebson.skillserver.v1.channels.FP.repository;

import com.ebson.skillserver.v1.channels.FP.entity.SkillBusiV1BlockProcUnitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SkillBusiV1BlockProcUnitEntityRepository extends JpaRepository<SkillBusiV1BlockProcUnitEntity, UUID> {
    List<SkillBusiV1BlockProcUnitEntity> findBySkillBusiV1BlockProcEntity_ProcId(UUID procId);
}
