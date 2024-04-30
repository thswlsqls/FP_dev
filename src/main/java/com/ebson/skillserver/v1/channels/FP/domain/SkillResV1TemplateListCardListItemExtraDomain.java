package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SkillResV1TemplateListCardListItemExtraDomain implements Serializable {
    private UUID extraId; // BINARY(16)을 UUID로 매핑
    private Integer listItemOrd;
    private UUID listItemId;
    private String key;
    private String value;
}
