package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SkillResV1TemplateItemCardItemListDomain implements Serializable {
    private UUID itemListId; // ITEMLIST_ID 컬럼과 매핑, BINARY(16)을 UUID로 매핑
    private UUID componentId; // COMPONENT_ID 컬럼과 매핑, BINARY(16)을 UUID로 매핑
    private String title; // TITLE 컬럼과 매핑, VARCHAR(45)
    private String desc; // DESC 컬럼과 매핑, VARCHAR(255)
}
