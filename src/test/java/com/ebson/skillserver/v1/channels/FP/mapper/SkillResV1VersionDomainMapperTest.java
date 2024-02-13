package com.ebson.skillserver.v1.channels.FP.mapper;

import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1VersionDomain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SkillResV1VersionDomainMapperTest {

    @Autowired
    private SkillResV1VersionDomainMapper skillResV1VersionDomainMapper;

    @Test
    public void selectAllTest(){
        SkillResV1VersionDomain skillResV1VersionDomain = new SkillResV1VersionDomain();
        List<SkillResV1VersionDomain> skillResV1VersionDomainList = skillResV1VersionDomainMapper.selectAll();

        assertNotNull(skillResV1VersionDomainList);
    }

}
