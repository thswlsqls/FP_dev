package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SkillResV1TemplateSimpleTextDomain {
    private UUID componentId; // BINARY(16)을 UUID로 매핑
    private String text;
    private UUID creator;
    private UUID lastUpdater;
}
