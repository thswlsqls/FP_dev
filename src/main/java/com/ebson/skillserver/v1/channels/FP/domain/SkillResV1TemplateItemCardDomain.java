package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SkillResV1TemplateItemCardDomain {
    private UUID carouselId; // NULL 가능
    private UUID componentId; // NOT NULL
    private Integer cardOrd;
    private Character dataType;
    private Character thumbYn;
    private String thumbImgUrl;
    private Integer thumbWidth;
    private Integer thumbHeight;
    private String thumbLinkPc;
    private String thumbLinkMob;
    private String thumbLinkWeb;
    private Character headYn;
    private String headTitle;
    private Character profileYn;
    private String profileImgUrl;
    private Integer profileWidth;
    private Integer profileHeight;
    private String profileTitle;
    private Character imgTitleYn;
    private String imgTitleTitle;
    private String imgTitleDesc;
    private String imgTitleImgUrl;
    private String itemListAlign; // NOT NULL, 기본값 'left'
    private Character itemListSummaryYn;
    private String itemListSummaryTitle;
    private String itemListSummaryDesc;
    private String title;
    private String desc;
    private String btnLayout; // NOT NULL, 기본값 'vertical'
    private UUID creator;
    private UUID lastUpdater;
}
