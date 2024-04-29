package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SkillResV1TemplateDomain implements Serializable {
    private UUID templateId; // BINARY(16)을 UUID로 매핑
    private String blockId; // UUID -> String
    private String blockCode;
    private String templateName;
    private UUID creator;
    private UUID lastUpdater;
}
