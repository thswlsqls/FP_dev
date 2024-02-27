package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SkillResV1TemplateListCardListItemDomain {
    private UUID listItemId;
    private Integer listItemOrd;
    private UUID componentId;
    private Character headerYn; // 'Y' for yes, 'N' for no, or null if not applicable
    private String title;
    private String desc;
    private String imgUrl;
    private String linkPc;
    private String linkMobile;
    private String linkWeb;
    private String action;
    private UUID blockId; // Can be null if not linked to a specific block
    private String messageText;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedDate;
    private UUID creator; // Can be null
    private UUID lastUpdater; // Can be null
}
