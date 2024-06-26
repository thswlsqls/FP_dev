package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SkillResV1DataDomain implements Serializable {
    private UUID dataId;
    private String blockId; // UUID -> String
    private String blockCode;
    private String key;
    private String value;
}
