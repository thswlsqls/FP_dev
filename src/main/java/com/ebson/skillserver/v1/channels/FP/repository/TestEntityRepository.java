package com.ebson.skillserver.v1.channels.FP.repository;

import com.ebson.skillserver.v1.channels.FP.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface TestEntityRepository extends JpaRepository<TestEntity, UUID> {

    /** 조회 */
    // 이름으로 데이터 찾기
    List<TestEntity> findByTestName(String testName);

    // 특정 정수값보다 큰 데이터 찾기
    List<TestEntity> findByTestNoGreaterThan(int testNo);

    // 이름에 특정 문자열을 포함하는 데이터 찾기
    List<TestEntity> findByTestNameContains(String keyword);

    // boolean 플래그 값으로 데이터 찾기
    List<TestEntity> findByTestFlagTrue();

    // 특정 날짜 이후에 생성된 사용자 찾기
    List<TestEntity> findByCreatedDateAfter(LocalDateTime date);

    // 이름으로 정렬하여 모든 데이터 조회
    List<TestEntity> findAllByOrderByTestNameAsc();

    // 이름과 활성 상태를 기준으로 데이터 찾기
    List<TestEntity> findByTestNameAndTestFlag(String username, boolean active);

    // 이름 또는 이메일로 데이터 찾기
    List<TestEntity> findByTestNameOrEmail(String username, String email);

    // 숫자 범위 내의 데이터 찾기
    List<TestEntity> findByTestNoBetween(int startTestNo, int endTestNo);

    // 특정 이름 리스트에 속하는 데이터 찾기
    List<TestEntity> findByTestNameIn(List<String> testNames);


    /** 수 세기 */
    // 특정 이름을 가진 데이터의 수 세기
    long countByTestName(String testName);


    /** 삭제 */
    // 특정 이름을 가진 데이터 삭제
    long deleteByTestName(String testName);

}
