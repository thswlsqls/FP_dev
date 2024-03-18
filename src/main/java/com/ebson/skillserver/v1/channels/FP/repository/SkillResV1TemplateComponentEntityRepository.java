package com.ebson.skillserver.v1.channels.FP.repository;

import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateComponentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SkillResV1TemplateComponentEntityRepository extends JpaRepository<SkillResV1TemplateComponentEntity, UUID> {

    // OUTPUT_ID를 사용하여 SkillResV1TemplateComponentEntity를 조회하는 메서드
    SkillResV1TemplateComponentEntity findBySkillResV1TemplateOutputEntity_OutputId(UUID outputId);
}
