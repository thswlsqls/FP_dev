package com.ebson.skillserver.v1.channels.FP.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SkillBusiV1UserDomain {
    private UUID userId;
    private UUID channelId;
    private String channelName;
    private String userName;
    private String email;
    private String phone;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedDate;
    private UUID creator;
    private UUID lastUpdater;
}
