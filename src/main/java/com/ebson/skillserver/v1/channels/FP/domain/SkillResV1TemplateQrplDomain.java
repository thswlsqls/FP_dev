package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SkillResV1TemplateQrplDomain {
    private UUID qrplId; // BINARY(16)을 UUID로 매핑
    private UUID templateId; // BINARY(16)을 UUID로 매핑
    private String label;
    private String action;
    private String messageText;
}
