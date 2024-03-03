package com.ebson.skillserver.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// import javax.persistence.EntityManagerFactory;

@Configuration
// @EnableTransactionManagement // 트랜잭션 관리를 활성화합니다.
public class TransactionManagerConfig {

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);

        // 커스터마이징할 추가적인 설정을 여기에 구현하세요.
        // 예: transactionManager.setNestedTransactionAllowed(true);

        // 트랜잭션 롤백에 대한 설정
        // 특정 예외가 발생했을 때 롤백을 수행할지 여부를 결정합니다.
        // transactionManager.setGlobalRollbackOnParticipationFailure(false);

        // 트랜잭션 타임아웃 설정
        // 트랜잭션이 수행되는 최대 시간을 설정합니다. 시간 초과 시 트랜잭션이 롤백됩니다.
        // transactionManager.setDefaultTimeout(30); // 30초

        return transactionManager;
    }
}
