package com.ebson.skillserver.v1.channels.FP.entity;

import com.ebson.skillserver.converter.UUIDToBytesConverter;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
// import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "TEST_ENTITY")
@Getter
@Setter
public class TestEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Convert(converter = UUIDToBytesConverter.class)
    @Column(name = "test_id", nullable = false, columnDefinition = "BINARY(16)")
    private UUID testId;

    @Column(name = "test_name", nullable = true, length = 100)
    private String testName;

    @Column(name = "test_email", nullable = true, length = 100)
    private String testEmail;

    @Column(name = "test_no", nullable = true)
    private Integer testNo;

    @Column(name = "test_flag", nullable = true)
    private boolean testFlag; // MariaDB 의 경우 TINYINT(1) 형의 컬럼에 매핑됩니다.

    @Column(name = "creator", nullable = false, length = 100)
    private String creator;

    @CreationTimestamp // 엔티티가 생성되어 데이터베이스에 처음 저장될 때 현재 시간을 자동으로 기록합니다.
    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Column(name = "last_updater", nullable = false, length = 100)
    private String lastUpdater;

    @UpdateTimestamp // 엔티티가 생성되어 처음 저장될 때뿐만 아니라, 업데이트될 때마다 현재 시간을 자동으로 기록합니다.
    @Column(name = "last_updated_date", nullable = false)
    private Date lastUpdatedDate;
}
