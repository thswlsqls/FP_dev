package com.ebson.skillserver.v1.channels.FP.repository;

import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateBasicCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SkillResV1TemplateBasicCardEntityRepository extends JpaRepository<SkillResV1TemplateBasicCardEntity, UUID> {
    List<SkillResV1TemplateBasicCardEntity> findBySkillResV1TemplateCarouselEntity_CarouselId(UUID carouselId);
}
