package com.ebson.skillserver.v1.channels.FP.repository;

import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1VersionEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class SkillResV1VersionEntityRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SkillResV1VersionEntityRepository repository;

    private SkillResV1VersionEntity createEntity() {
        SkillResV1VersionEntity entity = new SkillResV1VersionEntity();
        entity.setBlockCode("TestBlockCode");
        entity.setMajor(1);
        entity.setMinor(0);
        entity.setCreatedDate(LocalDateTime.now());
        entity.setLastUpdatedDate(LocalDateTime.now());
        entity.setCreator("testCreator");
        entity.setLastUpdater("testLastUpdater");
        return entity;
    }

    @BeforeEach
    public void setUp() {
        repository.deleteAllInBatch();
    }

    @AfterEach
    public void tearDown() {
        repository.deleteAllInBatch();
    }

    @Test
    public void testSaveAndFlush() {
        SkillResV1VersionEntity entity = createEntity();
        SkillResV1VersionEntity savedEntity = repository.saveAndFlush(entity);

        assertThat(savedEntity).isNotNull();
        assertThat(savedEntity.getVersionId()).isNotNull();
    }
}
