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

    @Column(name = "create_user", nullable = false, length = 100)
    private String createUser;

    @CreationTimestamp
    @ColumnDefault("CURRENT_TIMESTAMP()")
    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Column(name = "last_update_user", nullable = false, length = 100)
    private String lastUpdateUser;

    @ColumnDefault("CURRENT_TIMESTAMP()")
    @UpdateTimestamp
    @Column(name = "last_update_date", nullable = false)
    private Date lastUpdateDate;
}
