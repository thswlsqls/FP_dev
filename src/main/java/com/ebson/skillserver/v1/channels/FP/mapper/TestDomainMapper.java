package com.ebson.skillserver.v1.channels.FP.mapper;

import com.ebson.skillserver.v1.channels.FP.domain.TestDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.UUID;

@Mapper
public interface TestDomainMapper {
    List<TestDomain> selectAllTestDomains();
    void insertTestDomain(TestDomain testTomain);
    void updateTestDomain(TestDomain testTomain);
    void deleteTestDomain(UUID testId);
}
