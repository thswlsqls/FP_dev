package com.ebson.skillserver.v1.channels.FP.repository;

import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1BlockContextEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BuilderV1BlockContextEntityRepository extends JpaRepository<BuilderV1BlockContextEntity, UUID>  {
    BuilderV1BlockContextEntity findByBuilderV1BlockEntity_BlockIdAndContextTypeAndContextName(String blockId, String contextType, String contextName);
}
