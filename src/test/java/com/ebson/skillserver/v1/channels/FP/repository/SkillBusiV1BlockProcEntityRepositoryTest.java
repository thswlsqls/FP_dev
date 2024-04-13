package com.ebson.skillserver.v1.channels.FP.repository;


import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.entity.SkillBusiV1BlockProcEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.UUID;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SkillBusiV1BlockProcEntityRepositoryTest {

    @Autowired
    SkillBusiV1BlockProcEntityRepository skillBusiV1BlockProcEntityRepository;

    @Test
    public void findByBuilderV1BlockContextEntity_ContextIdTest() {
        UUID contextId = UUID.fromString(UUIDFormatter.formatToUUID("0334AEA5F95111EEB5380A48BC1A5EE1"));
        SkillBusiV1BlockProcEntity skillBusiV1BlockProcEntity = skillBusiV1BlockProcEntityRepository.findByBuilderV1BlockContextEntity_ContextId(contextId);

        Assertions.assertNotNull(skillBusiV1BlockProcEntity);
        Assertions.assertEquals(skillBusiV1BlockProcEntity.getProcName(), "S01_B01_테스트프로세스");
    }

}
