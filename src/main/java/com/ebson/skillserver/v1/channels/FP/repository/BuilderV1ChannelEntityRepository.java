package com.ebson.skillserver.v1.channels.FP.repository;

import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1ChannelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BuilderV1ChannelEntityRepository extends JpaRepository<BuilderV1ChannelEntity, UUID>  {
}
