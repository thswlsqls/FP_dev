package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class SkillResV1TemplateListCardListItemDomain implements Serializable {
    private UUID listItemId; // BINARY(16)을 UUID로 매핑
    private Integer listItemOrd;
    private UUID componentId;
    private String headerYn; // 'Y' for yes, 'N' for no, or null if not applicable
    private String title;
    private String desc;
    private String imgUrl;
    private String linkPc;
    private String linkMobile;
    private String linkWeb;
    private String action;
    private String blockId; // Can be null if not linked to a specific block
    private String messageText;
}
