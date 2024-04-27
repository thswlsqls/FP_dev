package com.ebson.skillserver.v1.channels.FP.mapper;

import com.ebson.skillserver.v1.channels.FP.domain.SkillResV1VersionDomain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SkillResV1VersionDomainMapperTest {

    private static final Logger logger = LoggerFactory.getLogger(SkillResV1VersionDomainMapperTest.class);

    @Autowired
    private SkillResV1VersionDomainMapper skillResV1VersionDomainMapper;

    @Test
    public void selectAllTest() {
        SkillResV1VersionDomain skillResV1VersionDomain = new SkillResV1VersionDomain();
        List<SkillResV1VersionDomain> skillResV1VersionDomainList = skillResV1VersionDomainMapper.selectAll();

        logger.info("selectAllTest 실행 결과: {}", skillResV1VersionDomainList);
        assertNotNull(skillResV1VersionDomainList);
    }

    @Test
    public void selectByVersionIdTest() {
        UUID versionId = UUID.fromString("377dceb9-ca71-11ee-9419-0a0df06f9f06");
        SkillResV1VersionDomain skillResV1VersionDomain = skillResV1VersionDomainMapper.selectByVersionId(versionId);

        logger.info("selectByVersionIdTest 실행 결과: {}", skillResV1VersionDomain);
        assertNotNull(skillResV1VersionDomain);
    }

    @Test
    public void insertSkillResV1VersionAndDeleteByVersionIdTest() {
        UUID versionId = UUID.randomUUID();
        String blockId = "blockIdTest";
        String blockCode = "blockCodeTest";
        Integer major = 2;
        Integer minor = 0;
        LocalDateTime createDate = LocalDateTime.now();
        LocalDateTime lastUpdatedDate = LocalDateTime.now();
        UUID creator = UUID.randomUUID();
        UUID lastUpdater = UUID.randomUUID();

        SkillResV1VersionDomain skillResV1VersionDomain = new SkillResV1VersionDomain();

        skillResV1VersionDomain.setVersionId(versionId);
        skillResV1VersionDomain.setBlockId(blockId);
        skillResV1VersionDomain.setBlockCode(blockCode);
        skillResV1VersionDomain.setMajor(major);
        skillResV1VersionDomain.setMinor(minor);

        skillResV1VersionDomainMapper.insertSkillResV1Version(skillResV1VersionDomain);

        SkillResV1VersionDomain selectedSkillResV1VersionDomain = skillResV1VersionDomainMapper.selectByVersionId(versionId);
        logger.info("selectByVersionId 실행 결과1: {}", selectedSkillResV1VersionDomain);
        assertNotNull(selectedSkillResV1VersionDomain);

        skillResV1VersionDomainMapper.deleteByVersionId(versionId);
        selectedSkillResV1VersionDomain = skillResV1VersionDomainMapper.selectByVersionId(versionId);
        logger.info("selectByVersionId 실행 결과2: {}", selectedSkillResV1VersionDomain);
        assertNull(skillResV1VersionDomainMapper.selectByVersionId(versionId));
    }

    @Test
    public void updateSkillResV1VersionTest(){
        UUID versionId = UUID.fromString("377dceb9-ca71-11ee-9419-0a0df06f9f06");
        SkillResV1VersionDomain skillResV1VersionDomain = skillResV1VersionDomainMapper.selectByVersionId(versionId);

        String updateBlockId = "updateBlockIdTest";
        String blockCode = "updateBlockCodeTest";
        Integer updateMajor = 2;
        Integer updateMinor = 0;
        LocalDateTime updateLastUpdatedDate = LocalDateTime.now();
        UUID updateLastUpdater = UUID.randomUUID();

        skillResV1VersionDomain.setBlockId(updateBlockId);
        skillResV1VersionDomain.setBlockCode(blockCode);
        skillResV1VersionDomain.setMajor(updateMajor);
        skillResV1VersionDomain.setMinor(updateMinor);

        skillResV1VersionDomainMapper.updateSkillResV1Version(skillResV1VersionDomain);
        SkillResV1VersionDomain updatedSkillResV1VersionDomain = skillResV1VersionDomainMapper.selectByVersionId(versionId);
        logger.info("updateSkillResV1Version 실행 결과: {}", updatedSkillResV1VersionDomain);
        assertNotNull(updatedSkillResV1VersionDomain);
        assertEquals(updatedSkillResV1VersionDomain.getBlockId(), updateBlockId);
        assertEquals(updatedSkillResV1VersionDomain.getMajor(), updateMajor);
        assertEquals(updatedSkillResV1VersionDomain.getMinor(), updateMinor);
    }

}
