package com.ebson.skillserver.v1.channels.FP.mapper;

import com.ebson.skillserver.v1.channels.FP.domain.TestDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestDomainMapper {
    List<TestDomain> selectAllTestDomains();
}
