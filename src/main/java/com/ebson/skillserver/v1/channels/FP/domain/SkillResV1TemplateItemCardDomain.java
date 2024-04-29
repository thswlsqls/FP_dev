package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class SkillResV1TemplateItemCardDomain implements Serializable {
    private UUID carouselId; // NULL 가능
    private UUID componentId; // NOT NULL
    private Integer cardOrd;
    private String dataType;
    private String thumbYn;
    private String thumbImgUrl;
    private Integer thumbWidth;
    private Integer thumbHeight;
    private String thumbLinkPc;
    private String thumbLinkMob;
    private String thumbLinkWeb;
    private String headYn;
    private String headTitle;
    private String profileYn;
    private String profileImgUrl;
    private Integer profileWidth;
    private Integer profileHeight;
    private String profileTitle;
    private String imgTitleYn;
    private String imgTitleTitle;
    private String imgTitleDesc;
    private String imgTitleImgUrl;
    private String itemListAlign; // NOT NULL, 기본값 'left'
    private String itemListSummaryYn;
    private String itemListSummaryTitle;
    private String itemListSummaryDesc;
    private String title;
    private String desc;
    private String btnLayout; // NOT NULL, 기본값 'vertical'
}
