package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class BuilderV1BlockDomain {
    private UUID blockId;
    private UUID scenarioId;
    private String blockName;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedDate;
    private UUID creator;
    private UUID lastUpdater;
}
