package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SkillResV1TemplateCarouselDomain {
    private UUID carouselId;
    private UUID componentId;
    private String cardType;
    private String headerTitle;
    private String headerDesc;
    private String headerThumb;
}
