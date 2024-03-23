package com.ebson.skillserver.v1.channels.FP.repository;

import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateComponentBtnEntity;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateComponentBtnExtraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SkillResV1TemplateComponentBtnExtraEntityRepository extends JpaRepository<SkillResV1TemplateComponentBtnExtraEntity, UUID> {

    SkillResV1TemplateComponentBtnExtraEntity findBySkillResV1TemplateComponentBtnEntity_BtnId(UUID btnId);
}
