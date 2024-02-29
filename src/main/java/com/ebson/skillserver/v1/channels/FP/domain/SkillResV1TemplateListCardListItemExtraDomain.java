package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SkillResV1TemplateListCardListItemExtraDomain {
    private UUID extraId; // BINARY(16)을 UUID로 매핑
    private Integer listItemOrd;
    private UUID listItemId;
    private String key;
    private String value;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedDate;
    private UUID creator; // Can be null
    private UUID lastUpdater; // Can be null
}
