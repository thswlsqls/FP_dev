package com.ebson.skillserver.common;

import lombok.Data;

import java.util.Map;

@Data
public class Action {
    private String id;
    private String name;
    private Map<String, Object> params;
    private Map<String, Object> detailParams;
    private Map<String, Object> clientExtra;
}

