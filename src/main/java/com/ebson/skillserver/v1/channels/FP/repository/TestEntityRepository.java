package com.ebson.skillserver.v1.channels.FP.repository;

import com.ebson.skillserver.v1.channels.FP.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface TestEntityRepository extends JpaRepository<TestEntity, UUID> {

    /** 1. JpaRepository 기본 제공 문법 */
    /** 1.1. 조회 */
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


    /** 1.2. 수 세기 */
    // 특정 이름을 가진 데이터의 수 세기
    long countByTestName(String testName);


    /** 1.3. 삭제 */
    // 특정 이름을 가진 데이터 삭제
    long deleteByTestName(String testName);

    /** 2. JPQL */
    /** 2.1. 조회 */
    // 이름으로 데이터 조회
    @Query("SELECT u FROM TestEntity tu WHERE tu.testName = :testName")
    List<TestEntity> findByTestNameWithJPQL(@Param("testName") String testName);

    // 플래그 값으로 데이터 조회
    @Query("SELECT tu FROM TestEntity tu WHERE tu.testFlag = true")
    List<TestEntity> findActiveUsersWithJPQL();

    // 특정 숫자 이상의 데이터 조회
    @Query("SELECT tu FROM TestEntity tu WHERE tu.testNo >= :testNo")
    List<TestEntity> findTestEntitiesGreaterThanWithJPQL(@Param("testNo") int testNo);

    /** 2.2. 수정 */
    @Transactional
    @Modifying
    @Query("UPDATE TestEntity tu SET t.testFlag = false WHERE tu.testNo < :testNo")
    int deactivateYoungUsers(@Param("testNo") int testNo);

    /** 3. Native Query */
    /** 3.1. 조회 */
    // 네이티브 SQL을 사용하여 이름으로 데이터 조회
    @Query(value = "SELECT * FROM TestEntity WHERE testName = :testName", nativeQuery = true)
    List<TestEntity> findByTestNameNative(@Param("testName") String testName);

    // 네이티브 SQL을 사용하여 플래그 값으로 데이터의 수 조회
    @Query(value = "SELECT COUNT(*) FROM test_entity WHERE test_flag = 1", nativeQuery = true)
    int countTestFlagTrueTestEntitiesNative();

    // 이름과 이메일로 데이터 조회
    @Query(value = "SELECT * FROM test_entity WHERE test_name = :testName AND test_email = :testEmail", nativeQuery = true)
    List<TestEntity> findByTestNameAndTestEmailNative(@Param("testName") String testName, @Param("testEmail") String testEmail);

    @Query(value = "SELECT * FROM users WHERE created_date >= :startDate AND created_date <= :endDate", nativeQuery = true)
    List<TestEntity> findByCreatedDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
