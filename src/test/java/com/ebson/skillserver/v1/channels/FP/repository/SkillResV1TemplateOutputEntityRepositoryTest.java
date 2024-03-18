package com.ebson.skillserver.v1.channels.FP.repository;

import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateOutputEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.UUID;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SkillResV1TemplateOutputEntityRepositoryTest {
    private static final Logger logger = LoggerFactory.getLogger(SkillResV1TemplateOutputEntityRepositoryTest.class);

    @Autowired
    SkillResV1TemplateOutputEntityRepository skillResV1TemplateOutputEntityRepository;

    @Test
    public void testFindBySkillResV1TemplateEntity_TemplateId(){

        List<SkillResV1TemplateOutputEntity> skillResV1TemplateOutputEntityList = skillResV1TemplateOutputEntityRepository.findBySkillResV1TemplateEntity_TemplateId(UUID.randomUUID());

        Assertions.assertEquals(skillResV1TemplateOutputEntityList.size(), 0);
    }

}
