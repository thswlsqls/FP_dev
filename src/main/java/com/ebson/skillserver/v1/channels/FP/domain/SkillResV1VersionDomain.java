package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID; // UUID 타입을 사용하기 위한 import 추가

@Data
@NoArgsConstructor
public class SkillResV1VersionDomain {
    private UUID versionId;       // byte[] 대신 UUID 사용
    private String blockId;         // byte[] 대신 UUID 사용
    private String blockCode;
    private Integer major;
    private Integer minor;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedDate;
    private UUID creator;         // byte[] 대신 UUID 사용
    private UUID lastUpdater;     // byte[] 대신 UUID 사용
}

