package com.ebson.skillserver.v1.channels.FP.repository;

import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1BlockEntity;
import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1ScenarioEntity;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BuilderV1BlockEntityRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(BuilderV1BlockEntityRepositoryTest.class);

    @Autowired
    private BuilderV1BlockEntityRepository builderV1BlockEntityRepository;

    @Autowired
    private BuilderV1ChannelEntityRepository builderV1ChannelEntityRepository;

    @Test
    public void testGetReferenceById() {
        BuilderV1BlockEntity findedEntity = builderV1BlockEntityRepository.getReferenceById("testBlockId");

        logger.info("findedEntity.getBlockId().toString() : " + findedEntity.getBlockId().toString());
        logger.info("findedEntity.getBuilderV1ScenarioEntity().getScenarioId() : " + findedEntity.getBuilderV1ScenarioEntity().getScenarioId());
        logger.info("findedEntity.getBuilderV1ScenarioEntity().getBuilderV1ChannelEntity().getChannelId() : " + findedEntity.getBuilderV1ScenarioEntity().getBuilderV1ChannelEntity().getChannelId());

        assertNotNull(findedEntity);
        assertNotNull(findedEntity.getBlockId());
        assertEquals(findedEntity.getBuilderV1ScenarioEntity().getScenarioId(), "testScenarioId");
        assertEquals(findedEntity.getBuilderV1ScenarioEntity().getBuilderV1ChannelEntity().getChannelId(), UUID.fromString(UUIDFormatter.formatToUUID("0AB4D8759506458D82E9671D1345F847")));
        assertEquals(findedEntity.getBuilderV1ScenarioEntity().getBuilderV1ChannelEntity().getChannelName(), "testChannelName");
    }

}
