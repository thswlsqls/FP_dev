package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SkillResV1TemplateComponentBtnExtraDomain implements Serializable {
    private UUID extraId;
    private UUID btnId;
    private String key;
    private String value;
}
