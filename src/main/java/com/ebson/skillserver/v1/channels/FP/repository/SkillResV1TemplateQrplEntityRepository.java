package com.ebson.skillserver.v1.channels.FP.repository;

import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateQrplEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SkillResV1TemplateQrplEntityRepository extends JpaRepository<SkillResV1TemplateQrplEntity, UUID> {
    List<SkillResV1TemplateQrplEntity> findBySkillResV1TemplateEntity_TemplateId(UUID templateId);
}
