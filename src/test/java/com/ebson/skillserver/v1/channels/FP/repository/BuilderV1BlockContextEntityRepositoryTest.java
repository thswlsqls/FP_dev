package com.ebson.skillserver.v1.channels.FP.repository;

import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1BlockContextEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BuilderV1BlockContextEntityRepositoryTest {

    @Autowired
    BuilderV1BlockContextEntityRepository builderV1BlockContextEntityRepository;

    @Test
    public void findByBuilderV1BlockEntity_BlockIdAndContextTypeAndContextNameTest(){
        String blockId = "6590ab5b193392115b5a7ff8";
        String contextType = "IN";
        String contextName = "S01_B01_테스트콘텍스트";

        BuilderV1BlockContextEntity bce = null;
        bce = builderV1BlockContextEntityRepository.findByBuilderV1BlockEntity_BlockIdAndContextTypeAndContextName(blockId, contextType, contextName);

        Assertions.assertNotNull(bce);
        Assertions.assertEquals(bce.getBlockCode(), "FP_S01_B01");
    }


}
