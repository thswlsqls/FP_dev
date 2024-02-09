package com.ebson.skillserver.v1.channels.FP.entity;

import com.ebson.skillserver.config.UUIDToBytesConverter;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

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
    private boolean testFlag;

    @Column(name = "creator", nullable = false, length = 100)
    private String creator;

    @CreationTimestamp
    @ColumnDefault("CURRENT_TIMESTAMP()")
    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Column(name = "last_updater", nullable = false, length = 100)
    private String lastUpdater;

    @ColumnDefault("CURRENT_TIMESTAMP()")
    @UpdateTimestamp
    @Column(name = "last_updated_date", nullable = false)
    private Date lastUpdatedDate;
}
