package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SkillResV1TemplateSimpleImageDomain {
    private UUID componentId;
    private String imgUrl;
    private String altText;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedDate;
    private UUID creator;
    private UUID lastUpdater;
}
