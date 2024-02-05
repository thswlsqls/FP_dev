package com.ebson.skillserver.common;

import lombok.Data;
import java.util.Map;

@Data
public class SkillResponse {
    private String version; // 필수O
    private Template template; // 응답을 스킬데이터로 사용 체크시 필수
    private Context context; // 필수X
    private Map<String, Object> data; // 필수X
}
