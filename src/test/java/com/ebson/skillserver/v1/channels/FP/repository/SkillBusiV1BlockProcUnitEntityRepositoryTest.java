package com.ebson.skillserver.v1.channels.FP.repository;


import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.entity.SkillBusiV1BlockProcUnitEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.UUID;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SkillBusiV1BlockProcUnitEntityRepositoryTest {

    @Autowired
    SkillBusiV1BlockProcUnitEntityRepository skillBusiV1BlockProcUnitEntityRepository;

    @Test
    public void findBySkillBusiV1BlockProcEntity_ProcIdTest() {
        UUID procId = UUID.fromString(UUIDFormatter.formatToUUID("6DDA2A18F99111EEB5380A48BC1A5EE1"));
        List<SkillBusiV1BlockProcUnitEntity> skillBusiV1BlockProcUnitEntityList = skillBusiV1BlockProcUnitEntityRepository.findBySkillBusiV1BlockProcEntity_ProcId(procId);

        Assertions.assertNotNull(skillBusiV1BlockProcUnitEntityList);
        Assertions.assertEquals(skillBusiV1BlockProcUnitEntityList.get(0).getProcUnitName(), "FP_템플릿_01_테스트");
    }
}
