package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class BuilderV1ChannelDomain {
    private UUID channelId;
    private String channelName;
    private UUID creator;
    private UUID lastUpdater;
}



