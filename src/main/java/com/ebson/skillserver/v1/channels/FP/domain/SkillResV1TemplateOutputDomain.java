package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SkillResV1TemplateOutputDomain {
    private UUID outputId; // BINARY(16)을 UUID로 매핑
    private UUID templateId; // BINARY(16)을 UUID로 매핑
    private Integer outputOrd;
    private String outputName;
    private UUID creator;
    private UUID lastUpdater;
}
