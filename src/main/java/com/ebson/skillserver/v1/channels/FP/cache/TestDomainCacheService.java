package com.ebson.skillserver.v1.channels.FP.cache;

import lombok.Data;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TestDomainCacheService {

    @Cacheable(value = "TestCacheDomains", key = "'TestCacheDomain:' + #id + ':' + #name")
    public TestCacheDomain getTestCacheDomainByIdAndName(String id, String name) {
        // 이는 캐시 키를 "TestCacheDomain:[id]:[name]" 형식으로 생성하도록 합니다.
        // 여기서 #id와 #name은 메서드의 파라미터 id와 name을 참조합니다.
        // 캐시 조회 명령어는 $ GET TestCacheDomains::TestCacheDomain:[id]:[name] 와 같습니다.
        return null; // 캐시 미스 시 DB 조회 코드 생략
    }

    @Cacheable(value = "TestCacheDomains", key = "'TestCacheDomain:' + #testCacheDomain.id + ':' + #testCacheDomain.name")
    public TestCacheDomain getTestCacheDomain(TestCacheDomain testCacheDomain){
        // 이는 캐시 키를 "TestCacheDomain:[testCacheDomain.id]:[testCacheDomain.name]" 형식으로 생성하도록 합니다.
        // 여기서 #testDomain.id와 #testDomain.name은 메서드의 파라미터 testDomain 객체를 참조합니다.
        // 캐시 조회 명령어는 $ GET TestCacheDomains::TestCacheDomain:[testCacheDomain.id]:[testCacheDomain.name] 와 같습니다.
        return null; // 캐시 미스 시 DB 조회 코드 생략
    }

    @Cacheable(value = "TestCacheDomains", key = "'TestCacheDomain:' + #id + ':' + #name", condition = "#no > 10", unless = "#no == null", sync = true)
    public TestCacheDomain getTestCacheDomainCustom(String id, String name) {
        // condition: 캐시를 적용할 조건을 지정할 수 있습니다. 이 속성은 SpEL을 사용하여 평가되며, 조건이 true일 때만 캐싱이 적용됩니다.
        // unless: 메서드의 반환값을 캐싱하지 않을 조건을 지정합니다. 이 속성 역시 SpEL을 사용하여 평가되며, 조건이 true일 때 결과가 캐시에 저장되지 않습니다.
        // sync: 캐시 미스가 발생했을 때 여러 스레드가 동시에 같은 메서드를 호출하는 상황을 방지합니다.
        // sync = true로 설정하면 한 번에 하나의 스레드만 메서드를 실행하고 결과를 캐시에 저장할 수 있습니다. 이는 캐시 스톰(cache storm)을 방지하는 데 유용합니다.
        return null; // 캐시 미스 시 DB 조회 코드 생략
    }

    @Data
    public class TestCacheDomain {
        private String id;
        private String name;
        private Integer no;
    }

}
