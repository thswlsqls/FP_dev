package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SkillResV1TemplateSimpleTextDomain implements Serializable {
    private UUID componentId; // BINARY(16)을 UUID로 매핑
    private String text;
}
