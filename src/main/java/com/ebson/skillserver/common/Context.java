package com.ebson.skillserver.common;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Context {
    // context 내부 구조에 따라 필드 추가
    private List<Value> values;

    @Data
    public class Value {
        private String name;
        private int lifeSpan;
        private Integer ttl; // Optional, so using Integer to allow null
        private Map<String, String> params;
    }
}
