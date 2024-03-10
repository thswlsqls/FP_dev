package com.ebson.skillserver.v1.channels.FP.repository;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1ChannelEntity;
import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1ScenarioEntity;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BuilderV1ScenarioEntityRepositoryTest {
    private static final Logger logger = LoggerFactory.getLogger(BuilderV1ScenarioEntityRepositoryTest.class);

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BuilderV1ScenarioEntityRepository builderV1ScenarioEntityRepository;

    @Autowired
    private BuilderV1ChannelEntityRepository builderV1ChannelEntityRepository;

    private BuilderV1ScenarioEntity createBuilderV1ScenarioEntity(BuilderV1ChannelEntity builderV1ChannelEntity){
        BuilderV1ScenarioEntity builderV1ScenarioEntity = new BuilderV1ScenarioEntity();
        builderV1ScenarioEntity.setScenarioId("test20240310");
        builderV1ScenarioEntity.setScenarioCode("testCode");
        builderV1ScenarioEntity.setScenarioName("testName");
        builderV1ScenarioEntity.setCreator("test");
        builderV1ScenarioEntity.setLastUpdater("test");

        builderV1ScenarioEntity.setBuilderV1ChannelEntity(builderV1ChannelEntity);

        return builderV1ScenarioEntity;
    }

    @Test
    @Rollback(value = false)
    public void testSaveAndFlush() {
        String formattedUUID = UUIDFormatter.formatToUUID("0AB4D8759506458D82E9671D1345F847");
        BuilderV1ChannelEntity builderV1ChannelEntity = builderV1ChannelEntityRepository.getReferenceById(UUID.fromString(formattedUUID));
        BuilderV1ScenarioEntity saveEntity = createBuilderV1ScenarioEntity(builderV1ChannelEntity);
        BuilderV1ScenarioEntity savedEntity = builderV1ScenarioEntityRepository.saveAndFlush(saveEntity);

        assertNotNull(savedEntity);
        assertNotNull(savedEntity.getScenarioId());
    }

    @Test
    public void testGetReferenceById() {
        BuilderV1ScenarioEntity findedEntity = builderV1ScenarioEntityRepository.getReferenceById("testScenarioId");

        logger.info("findedEntity.getScenarioId().toString() : " + findedEntity.getScenarioId().toString());
        logger.info("findedEntity.getBuilderV1ChannelEntity().getChannelId() : " + findedEntity.getBuilderV1ChannelEntity().getChannelId());

        assertNotNull(findedEntity);
        assertNotNull(findedEntity.getScenarioId());
        assertEquals(findedEntity.getScenarioId(), "testScenarioId");
    }


}
