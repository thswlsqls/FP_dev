package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SkillResV1TemplateComponentDomain {
    private UUID componentId;
    private UUID outputId;
    private String componentType;
    private String componentName;
}

