package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class BuilderV1BlockContextDomain {
    private UUID contextId;
    private String blockId;
    private String blockCode;
    private String contextType;
    private String contextName;
    private UUID creator;
    private UUID lastUpdater;
}
