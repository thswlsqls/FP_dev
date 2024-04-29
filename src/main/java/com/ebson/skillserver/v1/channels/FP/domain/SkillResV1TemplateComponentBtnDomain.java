package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class SkillResV1TemplateComponentBtnDomain implements Serializable {
    private UUID btnId;
    private UUID componentId;
    private String label;
    private String action;
    private String webLinkUrl;
    private String messageText;
    private String phone;
    private String blockId; // Optional, may be null if not linked to a block
}
