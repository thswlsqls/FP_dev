package com.ebson.skillserver.v1.channels.FP.repository;

import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateTextCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SkillResV1TemplateTextCardEntityRepository extends JpaRepository<SkillResV1TemplateTextCardEntity, UUID> {
    List<SkillResV1TemplateTextCardEntity> findBySkillResV1TemplateCarouselEntity_CarouselId(UUID carouselId);
}
