package com.ebson.skillserver.v1.channels.FP.mapper;

import com.ebson.skillserver.v1.channels.FP.domain.BuilderV1BlockContextDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.UUID;

@Mapper
public interface BuilderV1BlockContextDomainMapper {
    BuilderV1BlockContextDomain selectByContextId(String contextId);
    List<BuilderV1BlockContextDomain> selectAll();
    void insertBuilderV1BlockContext(BuilderV1BlockContextDomain builderV1BlockContextDomain);
    void updateBuilderV1BlockContext(BuilderV1BlockContextDomain builderV1BlockContextDomain);
    void deleteByContextId(String contextId);
}
