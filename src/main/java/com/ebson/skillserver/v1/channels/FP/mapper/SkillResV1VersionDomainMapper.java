package com.ebson.skillserver.v1.channels.FP.mapper;

import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1VersionDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.UUID;

@Mapper
public interface SkillResV1VersionDomainMapper {
    SkillResV1VersionDomain selectByVersionId(UUID versionId);
    List<SkillResV1VersionDomain> selectAll();
    void insert(SkillResV1VersionDomain skillResV1Version);
    void update(SkillResV1VersionDomain skillResV1Version);
    void deleteByVersionId(UUID versionId);
}
