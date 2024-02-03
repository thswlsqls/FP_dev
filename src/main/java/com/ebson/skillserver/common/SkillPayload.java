package com.ebson.skillserver.common;

import lombok.Data;
import java.util.List;

@Data
public class SkillPayload {
    private Bot bot;
    private Intent intent;
    private Action action;
    private UserRequest userRequest;
    private List<Object> contexts;
}

