package com.ebson.skillserver.cache.builderRequest;

import com.ebson.skillserver.v1.channels.FP.domain.BuilderV1ChannelDomain;
import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1ChannelEntity;
import com.ebson.skillserver.v1.channels.FP.repository.BuilderV1ChannelEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BuilderV1BlockChannelCacheService {

    @Autowired
    BuilderV1ChannelEntityRepository builderV1ChannelEntityRepository;

    // 메소드의 실행 결과
    @Cacheable(value = "BuilderV1ChannelDomains", key = "'BuilderV1ChannelDomain:' + #channelId + ':' + #channelName")
    public BuilderV1ChannelDomain getBuilderV1ChannelDomainByIdAndName(UUID channelId, String channelName) {
        BuilderV1ChannelEntity bvcde = builderV1ChannelEntityRepository.getReferenceById(channelId);
        BuilderV1ChannelDomain bvcd = new BuilderV1ChannelDomain();
        bvcd.setChannelId(bvcde.getChannelId());
        bvcd.setChannelName(bvcde.getChannelName());
        // 이는 캐시 키를 "BuilderV1ChannelDomain:[channelId]:[channelName]" 형식으로 생성하도록 합니다.
        // 캐시 조회 명령어는 $ GET BuilderV1ChannelDomains::BuilderV1ChannelDomain:[channelId]:[channelName] 와 같습니다.
        return bvcd; // 캐시 미스 시 DB 조회 코드 생략
    }

    // 캐시를 저장
    @CachePut(value = "BuilderV1ChannelDomains", key = "'BuilderV1ChannelDomain:' + #channelId + ':' + #channelName")
    public BuilderV1ChannelDomain setBuilderV1ChannelDomainByIdAndName(UUID channelId, String channelName) {
        BuilderV1ChannelEntity bvcde = builderV1ChannelEntityRepository.getReferenceById(channelId);
        BuilderV1ChannelDomain bvcd = new BuilderV1ChannelDomain();
        bvcd.setChannelId(bvcde.getChannelId());
        bvcd.setChannelName(bvcde.getChannelName());
        return bvcd;
    }

    // 캐시를 제거
    @CacheEvict(value = "BuilderV1ChannelDomains", key = "'BuilderV1ChannelDomain:' + #channelId + ':' + #channelName")
    public void deleteBuilderV1ChannelDomainByIdAndName(UUID channelId, String channelName) {}

}
