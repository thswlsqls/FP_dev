package com.ebson.skillserver.v1.channels.FP.repository;

import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateQrplExtraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SkillResV1TemplateQrplExtraEntityRepository extends JpaRepository<SkillResV1TemplateQrplExtraEntity, UUID> {
    // Custom queries can be defined here if required
}
