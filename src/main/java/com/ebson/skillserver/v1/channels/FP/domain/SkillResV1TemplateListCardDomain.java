package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SkillResV1TemplateListCardDomain {
    private UUID carouselId; // This can be null if the list card is not part of a carousel.
    private UUID componentId;
    private Integer cardOrd;
    private Character dataType;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedDate;
    private UUID creator;
    private UUID lastUpdater;
}
