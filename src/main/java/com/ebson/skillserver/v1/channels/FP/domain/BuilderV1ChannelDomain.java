package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class BuilderV1ChannelDomain implements Serializable {
    private UUID channelId;
    private String channelName;
}



