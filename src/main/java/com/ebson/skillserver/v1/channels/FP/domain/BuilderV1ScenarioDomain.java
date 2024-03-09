package com.ebson.skillserver.v1.channels.FP.domain;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class BuilderV1ScenarioDomain {
    private String scenarioId;
    private UUID channelId;
    private String scenarioCode;
    private String scenarioName;
    private UUID creator;
    private UUID lastUpdater;
}
