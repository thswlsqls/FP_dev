package com.ebson.skillserver.v1.channels.FP.repository;


import com.ebson.skillserver.v1.channels.FP.entity.SkillResV1TemplateComponentEntity;
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
public class SkillResV1TemplateComponentEntityRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(SkillResV1TemplateComponentEntityRepositoryTest.class);

    @Autowired
    SkillResV1TemplateComponentEntityRepository skillResV1TemplateComponentEntityRepository;

    @Test
    public void testFindBySkillResV1TemplateOutputEntity_OutputId(){

        SkillResV1TemplateComponentEntity skillResV1TemplateComponentEntity = skillResV1TemplateComponentEntityRepository.findBySkillResV1TemplateOutputEntity_OutputId(UUID.randomUUID());

        Assertions.assertNull(skillResV1TemplateComponentEntity);
    }
}
