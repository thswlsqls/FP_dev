package com.ebson.skillserver.v1.channels.FP.repository;

import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateBasicCardEntity;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateCarouselEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SkillResV1TemplateCarouselEntityRepository extends JpaRepository<SkillResV1TemplateCarouselEntity, UUID> {

    SkillResV1TemplateCarouselEntity findBySkillResV1TemplateComponentEntity_ComponentId(UUID componentId);
}
