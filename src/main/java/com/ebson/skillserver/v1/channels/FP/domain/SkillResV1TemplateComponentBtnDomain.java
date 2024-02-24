package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SkillResV1TemplateComponentBtnDomain {
    private UUID btnId;
    private UUID componentId;
    private String label;
    private String action;
    private String webLinkUrl;
    private String messageText;
    private String phone;
    private UUID blockId; // Optional, may be null if not linked to a block
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedDate;
    private UUID creator;
    private UUID lastUpdater;
}
