package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SkillResV1TemplateBasicCardDomain implements Serializable {
    private UUID carouselId; // This field can be null if the basic card is not part of a carousel.
    private UUID componentId;
    private Integer cardOrd;
    private String dataType;
    private String title;
    private String desc;

    private String thumbImgUrl;
    private String thumbLinkWeb;
    private String thumbLinkPc;

    private String thumbLinkMobile;
    private String thumbFixedRatio;
}
