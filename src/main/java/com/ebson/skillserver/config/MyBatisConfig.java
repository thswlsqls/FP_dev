package com.ebson.skillserver.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.mybatis.spring.boot.autoconfigure.SqlSessionFactoryBeanCustomizer;
import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;



@org.springframework.context.annotation.Configuration
public class MyBatisConfig {

    @Bean
    ConfigurationCustomizer mybatisConfigurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
                // 여기에 다른 MyBatis 설정을 커스터마이징할 수 있습니다.
            }
        };
    }
    @Bean
    SqlSessionFactoryBeanCustomizer sqlSessionFactoryBeanCustomizer() {
        return new SqlSessionFactoryBeanCustomizer() {
            @Override
            public void customize(SqlSessionFactoryBean factoryBean) {
                // factoryBean.setTypeAliasesPackage("com.example.domain.model");
                // 여기에 다른 SqlSessionFactoryBean 설정을 커스터마이징할 수 있습니다.
            }
        };
    }

}

