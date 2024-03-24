package com.ebson.skillserver.v1.channels.FP.repository;

import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateCommerceCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SkillResV1TemplateCommerceCardEntityRepository extends JpaRepository<SkillResV1TemplateCommerceCardEntity, UUID> {
    List<SkillResV1TemplateCommerceCardEntity> findBySkillResV1TemplateCarouselEntity_CarouselId(UUID carouselId);
}
