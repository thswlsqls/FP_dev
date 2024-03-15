package com.ebson.skillserver.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ScenarioServiceBeanIdProviderTest {

    @Autowired
    private ScenarioServiceBeanIdProvider provider;

    @Test
    public void testGetBeanIdWithFPChannel() {
        // FP 채널과 key1 시나리오 코드에 대한 빈 ID를 검증합니다.
        Assertions.assertEquals("serviceBean1", provider.getBeanId("FP", "key1"));
    }

    @Test
    public void testGetBeanIdWithFPChannelAndUnknownScenarioCode() {
        // FP 채널과 알려지지 않은 시나리오 코드에 대해 null을 반환하는지 검증합니다.
        Assertions.assertNull(provider.getBeanId("FP", "unknown"));
    }

}
