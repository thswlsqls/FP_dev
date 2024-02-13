package com.ebson.skillserver.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@AutoConfigureAfter({DataSourceAutoConfiguration.class, MybatisAutoConfiguration.class})
@MapperScan(basePackages = "com.ebson.skillserver.v1.channels.FP.mapper") // MyBatis 매퍼 인터페이스가 위치한 패키지 지정
@PropertySource("classpath:application.properties") // 필요한 경우, 추가 설정을 위한 프로퍼티 파일 지정
public class MybatisTestConfiguration {
    // 이곳에 필요한 추가적인 빈 설정을 정의할 수 있습니다.
    // 예제에서는 추가적인 빈이 필요하지 않으므로, 구체적인 구현은 생략합니다.
}
