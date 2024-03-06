package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SkillResV1ContextDomain {
    private UUID contextId;
    private String blockId; // UUID -> String
    private String blockCode;
    private String contextName;
    private String contextType;
    private Integer lifespan;
    private Integer ttl;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedDate;
    private UUID creator;
    private UUID lastUpdater;
}
