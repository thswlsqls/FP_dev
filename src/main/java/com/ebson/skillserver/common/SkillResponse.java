package com.ebson.skillserver.common;

import lombok.Data;
import java.util.Map;

@Data
public class SkillResponse {
    private String version;
    private Template template;
    private Context context;
    private Map<String, Object> data;
}
