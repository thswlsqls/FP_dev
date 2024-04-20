package com.ebson.skillserver.cache.builderRequest;

import com.ebson.skillserver.v1.channels.FP.domain.BuilderV1BlockDomain;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BuilderV1BlockCacheService {

    @Cacheable(value = "BuilderV1BlockDomains", key = "'BuilderV1BlockDomain:' + #channelCode + ':' + #blockId + ':' + #blockCode")
    public BuilderV1BlockDomain getBuilderV1BlockDomainByIdAndName(String channelCode, String blockId, String blockCode) {
        // 이는 캐시 키를 "BuilderV1BlockDomain:[channelCode]:[id]:[name]" 형식으로 생성하도록 합니다.
        // 캐시 조회 명령어는 $ GET BuilderV1BlockDomains::BuilderV1BlockDomain:[channelCode]:[blockId]:[blockCode] 와 같습니다.
        return null; // 캐시 미스 시 DB 조회 코드 생략
    }

}
