package com.ebson.skillserver.v1.channels.FP.repository;

import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateOutputEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SkillResV1TemplateOutputEntityRepository extends JpaRepository<SkillResV1TemplateOutputEntity, UUID>  {

    // TEMPLATE_ID를 사용하여 SkillResV1TemplateOutputEntity의 리스트를 조회하는 메서드
    List<SkillResV1TemplateOutputEntity> findBySkillResV1TemplateEntity_TemplateId(UUID templateId);
}
