package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class SkillResV1TemplateListCardDomain implements Serializable {
    private UUID carouselId; // This can be null if the list card is not part of a carousel.
    private UUID componentId; // BINARY(16)을 UUID로 매핑
    private Integer cardOrd;
    private String dataType;
}
