package com.ebson.skillserver.v1.channels.FP.mapper;

import com.ebson.skillserver.v1.channels.FP.domain.BuilderV1ChannelDomain;
import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1VersionDomain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BuilderV1ChannelDomainMapperTest {

    private static final Logger logger = LoggerFactory.getLogger(BuilderV1ChannelDomainMapperTest.class);

    @Autowired
    private BuilderV1ChannelDomainMapper builderV1ChannelDomainMapper;

    @Test
    public void selectByChannelIdTest(){
        // 62cb542e-cf2e-11ee-9419-0a0df06f9f06
        UUID channelId = UUID.fromString("62cb542e-cf2e-11ee-9419-0a0df06f9f06");
        BuilderV1ChannelDomain builderV1ChannelDomain = builderV1ChannelDomainMapper.selectByChannelId(channelId);

        logger.info("selectByChannelIdTest 실행 결과: {}", builderV1ChannelDomain);
        assertNotNull(builderV1ChannelDomain);
    }

    @Test
    public void selectAllTest() {
        List<BuilderV1ChannelDomain> builderV1ChannelDomainList = builderV1ChannelDomainMapper.selectAll();

        logger.info("selectAllTest 실행 결과: {}", builderV1ChannelDomainList);
        assertNotNull(builderV1ChannelDomainList);
    }

    @Test
    public void insertBuilderV1ChannelAndDeleteByChannelIdTest() {
        UUID channelId = UUID.randomUUID();
        String channelName = "TEST";
        LocalDateTime createdDate = LocalDateTime.now();
        LocalDateTime lastUpdatedDate = LocalDateTime.now();
        UUID creator = UUID.randomUUID();
        UUID lastUpdater = UUID.randomUUID();

        BuilderV1ChannelDomain builderV1ChannelDomain = new BuilderV1ChannelDomain();

        builderV1ChannelDomain.setChannelId(channelId);
        builderV1ChannelDomain.setChannelName(channelName);
//        builderV1ChannelDomain.setCreator(creator);
//        builderV1ChannelDomain.setLastUpdater(lastUpdater);

        builderV1ChannelDomainMapper.insertBuilderV1Channel(builderV1ChannelDomain);

        BuilderV1ChannelDomain selectedBuilderV1ChannelDomain = builderV1ChannelDomainMapper.selectByChannelId(channelId);
        logger.info("selectByChannelId 실행 결과1: {}", selectedBuilderV1ChannelDomain);
        assertNotNull(selectedBuilderV1ChannelDomain);

        builderV1ChannelDomainMapper.deleteByChannelId(channelId);
        selectedBuilderV1ChannelDomain = builderV1ChannelDomainMapper.selectByChannelId(channelId);
        logger.info("selectByChannelId 실행 결과2: {}", selectedBuilderV1ChannelDomain);
        assertNull(builderV1ChannelDomainMapper.selectByChannelId(channelId));
    }

    @Test
    public void updateBuilderV1ChannelTest(){
        UUID channelId = UUID.fromString("62cb542e-cf2e-11ee-9419-0a0df06f9f06");
        BuilderV1ChannelDomain builderV1ChannelDomain = builderV1ChannelDomainMapper.selectByChannelId(channelId);

        LocalDateTime updateLastUpdatedDate = LocalDateTime.now();
        UUID updateLastUpdater = UUID.randomUUID();

//        builderV1ChannelDomain.setLastUpdater(updateLastUpdater);

        builderV1ChannelDomainMapper.updateBuilderV1Channel(builderV1ChannelDomain);

        BuilderV1ChannelDomain updatedBuilderV1ChannelDomain = builderV1ChannelDomainMapper.selectByChannelId(channelId);
        logger.info("updateBuilderV1Channel 실행 결과: {}", updatedBuilderV1ChannelDomain);
        assertNotNull(updatedBuilderV1ChannelDomain);
//        assertEquals(updatedBuilderV1ChannelDomain.getLastUpdater(), updateLastUpdater);
    }

}
