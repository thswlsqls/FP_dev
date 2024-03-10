package com.ebson.skillserver.v1.channels.FP.repository;

import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1ChannelEntity;
import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1VersionEntity;
import com.ebson.skillserver.v1.channels.FP.mapper.BuilderV1ChannelDomainMapperTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BuilderV1ChannelEntityRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(BuilderV1ChannelEntityRepositoryTest.class);

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BuilderV1ChannelEntityRepository builderV1ChannelEntityRepository;

    private BuilderV1ChannelEntity createBuilderV1ChannelEntity(){
        BuilderV1ChannelEntity builderV1ChannelEntity = new BuilderV1ChannelEntity();
        builderV1ChannelEntity.setChannelName("testChannelName");
        builderV1ChannelEntity.setCreator(UUID.randomUUID());
        builderV1ChannelEntity.setLastUpdater(UUID.randomUUID());
        return builderV1ChannelEntity;
    }

//    @BeforeEach
//    public void setUp() {
//        builderV1ChannelEntityRepository.deleteAllInBatch();
//    }
//
//    @AfterEach
//    public void tearDown() {
//        builderV1ChannelEntityRepository.deleteAllInBatch();
//    }

    @Test
    public void testSaveAndFlush() {
        BuilderV1ChannelEntity entity = createBuilderV1ChannelEntity();
        BuilderV1ChannelEntity savedEntity = builderV1ChannelEntityRepository.saveAndFlush(entity);

        assertThat(savedEntity).isNotNull();
        assertThat(savedEntity.getChannelId()).isNotNull();
    }

    @Test
    public void testGetReferenceById() {
        BuilderV1ChannelEntity saveEntity = createBuilderV1ChannelEntity();
        BuilderV1ChannelEntity savedEntity = builderV1ChannelEntityRepository.saveAndFlush(saveEntity);
        BuilderV1ChannelEntity findedEntity = builderV1ChannelEntityRepository.getReferenceById(savedEntity.getChannelId());

        logger.info("savedEntity.getChannelId().toString() : " + savedEntity.getChannelId().toString());
        logger.info("findedEntity.getChannelId().toString() : " + findedEntity.getChannelId().toString());

        assertNotNull(findedEntity);
        assertNotNull(findedEntity.getChannelId());
        assertEquals(findedEntity.getChannelId(), savedEntity.getChannelId());
    }

}
