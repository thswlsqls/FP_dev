package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class BuilderV1BlockContextDomain {
    private UUID contextId;
    private UUID blockId;
    private String contextType;
    private String contextName;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdateDate;
    private UUID creator;
    private UUID lastUpdater;
}
