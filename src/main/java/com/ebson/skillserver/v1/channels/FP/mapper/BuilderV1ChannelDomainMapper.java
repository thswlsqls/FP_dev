package com.ebson.skillserver.v1.channels.FP.mapper;

import com.ebson.skillserver.v1.channels.FP.domain.BuilderV1ChannelDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.UUID;

@Mapper
public interface BuilderV1ChannelDomainMapper {

    BuilderV1ChannelDomain selectByChannelId(UUID channelId);
    List<BuilderV1ChannelDomain> selectAll();
    void insertBuilderV1Channel(BuilderV1ChannelDomain builderV1ChannelDomain);
    void updateBuilderV1Channel(BuilderV1ChannelDomain builderV1ChannelDomain);
    void deleteByChannelId(UUID channelId);
}


