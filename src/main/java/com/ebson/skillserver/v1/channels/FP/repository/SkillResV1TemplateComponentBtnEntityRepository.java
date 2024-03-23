package com.ebson.skillserver.v1.channels.FP.repository;

import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateComponentBtnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SkillResV1TemplateComponentBtnEntityRepository extends JpaRepository<SkillResV1TemplateComponentBtnEntity, UUID> {

    List<SkillResV1TemplateComponentBtnEntity> findBySkillResV1TemplateComponentEntity_ComponentId(UUID component);
}
