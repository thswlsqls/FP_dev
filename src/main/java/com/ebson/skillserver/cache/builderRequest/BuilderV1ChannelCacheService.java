package com.ebson.skillserver.cache.builderRequest;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.domain.BuilderV1ChannelDomain;
import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1ChannelEntity;
import com.ebson.skillserver.v1.channels.FP.repository.BuilderV1ChannelEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class BuilderV1ChannelCacheService {

    private static final Logger logger = LoggerFactory.getLogger(BuilderV1ChannelCacheService.class);

    @Autowired
    BuilderV1ChannelEntityRepository repository;

    // 케시를 조회 - 없으면 메서드 반환 값을 캐시에 저장
    @Cacheable(value = "BuilderV1ChannelDomain", key = "#channelId")
    public BuilderV1ChannelDomain getBuilderV1ChannelDomainCache(String channelId) {
        BuilderV1ChannelEntity bvcde = repository.getReferenceById(UUID.fromString(channelId));
        BuilderV1ChannelDomain bvcd = new BuilderV1ChannelDomain();
        bvcd.setChannelId(bvcde.getChannelId());
        bvcd.setChannelName(bvcde.getChannelName());
        logger.info("getBuilderV1ChannelDomainCache^^BuilderV1ChannelDomain :: {}", bvcd.toString());
        return bvcd;
    }

    // 캐시를 저장
    @CachePut(value = "BuilderV1ChannelDomain", key = "#channelId")
    public BuilderV1ChannelDomain setBuilderV1ChannelDomainCache(String channelId) {
        BuilderV1ChannelEntity bvcde = repository.getReferenceById(UUID.fromString(channelId));
        BuilderV1ChannelDomain bvcd = new BuilderV1ChannelDomain();
        bvcd.setChannelId(bvcde.getChannelId());
        bvcd.setChannelName(bvcde.getChannelName());
        logger.info("setBuilderV1ChannelDomainCache^^BuilderV1ChannelDomain :: {}", bvcd.toString());
        return bvcd;
    }

    // 캐시를 제거
    @CacheEvict(value = "BuilderV1ChannelDomain", key = "#channelId")
    public void deleteBuilderV1ChannelDomainCache(String channelId) {
        logger.info("BuilderV1ChannelDomain Cache is deleted ... channelId : {}", channelId);
    }

    @Transactional
    public void setAllBuilderV1ChannelDomainCache() {
        List<BuilderV1ChannelEntity> list1 = repository.findAll();
        for (BuilderV1ChannelEntity entity : list1) {
            String channelId = UUIDFormatter.formatToUUID(entity.getChannelId().toString());
            setBuilderV1ChannelDomainCache(channelId);
        }
    }

}
