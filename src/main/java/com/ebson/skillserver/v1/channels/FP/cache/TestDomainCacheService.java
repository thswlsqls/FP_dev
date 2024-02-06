package com.ebson.skillserver.v1.channels.FP.cache;

import lombok.Data;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TestDomainCacheService {

    @Cacheable(value = "TestDomains", key = "'TestDomain:' + #id + ':' + #name")
    public TestDomain getTestDomainByIdAndName(Long id, String name) {
        // 이는 캐시 키를 "TestDomain:[id]:[name]" 형식으로 생성하도록 합니다.
        // 여기서 #id와 #name은 메서드의 파라미터 id와 name을 참조합니다.
        // 캐시 조회 명령어는 $ GET TestDomains::TestDomain:[id]:[name] 와 같습니다.
        return null; // 캐시 미스 시 DB 조회 코드 생략
    }

    @Cacheable(value = "TestDomains", key = "'TestDomain:' + #testDomain.id + ':' + #testDomain.name")
    public TestDomain getTestDomain(TestDomain testDomain){
        // 이는 캐시 키를 "TestDomain:[testDomain.id]:[testDomain.name]" 형식으로 생성하도록 합니다.
        // 여기서 #testDomain.id와 #testDomain.name은 메서드의 파라미터 testDomain 객체를 참조합니다.
        // 캐시 조회 명령어는 $ GET TestDomains::TestDomain:[testDomain.id]:[testDomain.name] 와 같습니다.
        return null; // 캐시 미스 시 DB 조회 코드 생략
    }

    @Data
    public class TestDomain {
        private String id;
        private String name;
    }

}
