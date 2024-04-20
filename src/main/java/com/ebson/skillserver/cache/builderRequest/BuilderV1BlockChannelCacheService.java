package com.ebson.skillserver.cache.builderRequest;

import com.ebson.skillserver.v1.channels.FP.domain.BuilderV1ChannelDomain;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BuilderV1BlockChannelCacheService {

    @Cacheable(value = "BuilderV1ChannelDomains", key = "'BuilderV1ChannelDomain:' + #channelId + ':' + #channelName")
    public BuilderV1ChannelDomain getBuilderV1ChannelDomainByIdAndName(String channelId, String channelName) {
        // 이는 캐시 키를 "BuilderV1BlockDomain:[channelCode]:[id]:[name]" 형식으로 생성하도록 합니다.
        // 캐시 조회 명령어는 $ GET BuilderV1BlockDomains::BuilderV1BlockDomain:[channelCode]:[blockId]:[blockCode] 와 같습니다.
        return null; // 캐시 미스 시 DB 조회 코드 생략
    }

    @CachePut(value = "BuilderV1ChannelDomains", key = "'BuilderV1ChannelDomain:' + #channelId + ':' + #channelName")
    public BuilderV1ChannelDomain setBuilderV1ChannelDomainByIdAndName(){

        return null;
    }

    @CacheEvict(value = "BuilderV1ChannelDomains", key = "'BuilderV1ChannelDomain:' + #channelId + ':' + #channelName")
    public BuilderV1ChannelDomain deleteBuilderV1ChannelDomainByIdAndName(){

        return null;
    }
}
