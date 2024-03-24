package com.ebson.skillserver.v1.channels.FP.repository;

import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateItemCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SkillResV1TemplateItemCardEntityRepository extends JpaRepository<SkillResV1TemplateItemCardEntity, UUID> {
    List<SkillResV1TemplateItemCardEntity> findBySkillResV1TemplateCarouselEntity_CarouselId(UUID carouselId);
}
