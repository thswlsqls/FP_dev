package com.ebson.skillserver.v1.channels.FP.repository;

import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateComponentBtnExtraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SkillResV1TemplateComponentBtnExtraEntityRepository extends JpaRepository<SkillResV1TemplateComponentBtnExtraEntity, UUID> {
}
