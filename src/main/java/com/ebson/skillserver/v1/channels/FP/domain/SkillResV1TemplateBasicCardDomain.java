package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SkillResV1TemplateBasicCardDomain {
    private UUID carouselId; // This field can be null if the basic card is not part of a carousel.
    private UUID componentId;
    private Integer cardOrd;
    private Character dataType;
    private String title;
    private String desc;
    private String thumb; // This field is marked as NOT NULL in the DB schema.
    private UUID creator;
    private UUID lastUpdater;
}
