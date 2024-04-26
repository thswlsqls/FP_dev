package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SkillResV1ContextParamDomain {
    private int paramNo;
    private UUID contextId;
    private String key;
    private String value;
}
