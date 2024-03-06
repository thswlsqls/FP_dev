package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SkillResV1DataDomain {
    private UUID dataId;
    private String blockId;
    private String blockCode;
    private String key;
    private String value;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedDate;
    private UUID creator;
    private UUID lastUpdater;
}
