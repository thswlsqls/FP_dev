package com.ebson.skillserver.component;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ScenarioServiceBeanIdProvider {

    private final Map<String, String> FPBeanIdMap = new HashMap<>();

    @PostConstruct
    private void FPinit() {
        // 여기에 서비스 빈의 아이디를 key-value 형태로 추가합니다.
        FPBeanIdMap.put("key1", "serviceBean1");
        FPBeanIdMap.put("key2", "serviceBean2");
    }

    public String getBeanId(String ChannelName, String ScenarioCode) {

        Map<String, String> beanIdMap = switch (ChannelName) {
            case "FP" -> {
                yield FPBeanIdMap;
            }
            // 여기에 더 많은 채널에 대한 케이스를 추가할 수 있습니다.
            default -> FPBeanIdMap; // 기본적으로 제공된 ScenarioCode 사용
        };

        return beanIdMap.get(ScenarioCode);
    }

}
