package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SkillResV1TemplateItemCardItemListDomain {
    private UUID itemListId; // ITEMLIST_ID 컬럼과 매핑, BINARY(16)을 UUID로 매핑
    private UUID componentId; // COMPONENT_ID 컬럼과 매핑, BINARY(16)을 UUID로 매핑
    private String title; // TITLE 컬럼과 매핑, VARCHAR(45)
    private String desc; // DESC 컬럼과 매핑, VARCHAR(255)
    private UUID creator; // CREATOR 컬럼과 매핑, BINARY(16)을 UUID로 매핑, NULL 가능
    private UUID lastUpdater; // LAST_UPDATER 컬럼과 매핑, BINARY(16)을 UUID로 매핑, NULL 가능
}
