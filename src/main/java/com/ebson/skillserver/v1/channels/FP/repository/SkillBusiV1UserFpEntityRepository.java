package com.ebson.skillserver.v1.channels.FP.repository;

import com.ebson.skillserver.v1.channels.FP.entity.SkillBusiV1UserFpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SkillBusiV1UserFpEntityRepository extends JpaRepository<SkillBusiV1UserFpEntity, UUID> {

    SkillBusiV1UserFpEntity findByUserKey(String userKey);
}
