package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SkillResV1TemplateCommerceCardDomain {
    private UUID carouselId; // May be null if not part of a carousel
    private UUID componentId;
    private Integer cardOrd;
    private Character dataType;
    private String title;
    private String desc;
    private Integer price;
    private String currency;
    private Integer discount;
    private Integer discountRate;
    private Integer discountedPrice;
    private String thumbImgUrl;
    private String thumbLinkWeb;
    private String thumbLinkPc;
    private String thumbLinkMobile;
    private String thumbFixedRatio;
    private String profileNickname;
    private String profileImgUrl;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedDate;
    private UUID creator;
    private UUID lastUpdater;

}
