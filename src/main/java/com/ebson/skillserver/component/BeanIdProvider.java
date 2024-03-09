package com.ebson.skillserver.component;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BeanIdProvider {

    private final Map<String, String> beanIdMap = new HashMap<>();

    @PostConstruct
    private void init() {
        // 여기에 서비스 빈의 아이디를 key-value 형태로 추가합니다.
        beanIdMap.put("key1", "serviceBean1");
        beanIdMap.put("key2", "serviceBean2");
    }

    public String getBeanId(String key) {
        return beanIdMap.get(key);
    }

}
