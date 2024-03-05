package com.ebson.skillserver.v1.channels.FP.mapper;

import com.ebson.skillserver.v1.channels.FP.domain.BuilderV1BlockDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.UUID;

@Mapper
public interface BuilderV1BlockDomainMapper {
    BuilderV1BlockDomain selectByBlockId(String blockId);
    List<BuilderV1BlockDomain> selectAll();
    void insertBuilderV1Block(BuilderV1BlockDomain builderV1BlockDomain);
    void updateBuilderV1Block(BuilderV1BlockDomain builderV1BlockDomain);
    void deleteByBlockId(String blockId);
}

