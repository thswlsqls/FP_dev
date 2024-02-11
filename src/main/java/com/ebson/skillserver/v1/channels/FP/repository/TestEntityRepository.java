package com.ebson.skillserver.v1.channels.FP.repository;

import com.ebson.skillserver.v1.channels.FP.entity.TestEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
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


    /** 1.4. 수정 */
    @Transactional
    void updateTestEntityTestFlag(UUID id, boolean testFlag);
    /**  스프링 데이터 JPA에서는 직접적으로 메서드 이름을 통한 업데이트 쿼리의 생성을 지원하지 않습니다.
     * 엔티티를 조회한 후 변경하고자 하는 필드의 값을 수정하고 save() 메서드를 호출하여 변경사항을 적용하는 방식으로 수정 작업을 수행할 수 있습니다.
     * 예를 들어, TestEntityRepository 를 implements 한 클래스에서 아래와 같이 구현해야 합니다.
     {
        TestEntity tu = this.findById(id).orElseThrow(() -> new EntityNotFoundException("TestEntity not found"));
        tu.setTestFlag(testFlag);
        this.save(tu);
    } */


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

    /** 2.3. 삭제 */
    /** testName 으로 조건 조회해서 데이터 삭제 */
    @Transactional
    @Modifying
    @Query("DELETE FROM TestEntity tu WHERE tu.testName = :testName")
    void deleteTestEntityByTestNameWithJPQL(@Param("testName") String testName);


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

    // 생성 일시를 기준으로 데이터 조회
    @Query(value = "SELECT * FROM test_entity WHERE created_date >= :startDate AND created_date <= :endDate", nativeQuery = true)
    List<TestEntity> findByCreatedDateBetweenNative(@Param("startDate") Date startDate, @Param("endDate") Date endDate);


    /** 3.2. 생성 */
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO test_entity (test_name, test_email, test_flag) VALUES (:testName, :testEmail, :testFlag)", nativeQuery = true)
    void insertTestEntityNative(@Param("testName") String testName, @Param("testEmail") String testEmail, @Param("testFlag") boolean testFlag);


    /** 3.3. 수정 */
    /** testName 으로 조건 조회해서 testEmail 수정 */
    @Transactional
    @Modifying
    @Query(value = "UPDATE test_entity SET test_email = :testEmail WHERE test_name = :testName", nativeQuery = true)
    void updateTestEmailByTestNameNative(@Param("testEmail") String testEmail, @Param("testName") String testName);


    /** 3.4. 삭제 */
    /** testName 으로 조건 조회해서 데이터 삭제 */
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM test_entity WHERE test_name = :testName", nativeQuery = true)
    void deleteTestEntityByTestNameNative(@Param("testName") String testName);

}
