package com.ebson.skillserver.v1.channels.FP.repository;

import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateListCardListItemExtraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SkillResV1TemplateListCardListItemExtraEntityRepository extends JpaRepository<SkillResV1TemplateListCardListItemExtraEntity, UUID> {

    SkillResV1TemplateListCardListItemExtraEntity findBySkillResV1TemplateListCardListItemEntity_ListItemId(UUID listItemId);
}
