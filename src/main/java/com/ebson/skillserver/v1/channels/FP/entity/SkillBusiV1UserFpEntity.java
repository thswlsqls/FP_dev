package com.ebson.skillserver.v1.channels.FP.entity;

import com.ebson.skillserver.converter.UUIDToBytesConverter;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "SKILL_BUSI_V1_USER_FP")
@Getter @Setter
public class SkillBusiV1UserFpEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "USER_ID", nullable = false, columnDefinition = "BINARY(16)")
    @Convert(converter = UUIDToBytesConverter.class)
    private UUID userId;

    @Column(name = "TASK_ID", columnDefinition = "BINARY(16)")
    private UUID taskId;

    @Column(name = "USER_KEY", length = 45)
    private String userKey;

    @Column(name = "USER_NAME", length = 45)
    private String userName;

    @Column(name = "GENDER", length = 1, nullable = false, columnDefinition = "CHAR(1) DEFAULT 'M'")
    private char gender = 'M';

    @Column(name = "EMAIL", length = 45)
    private String email;

    @Column(name = "PASSWORD", length = 45)
    private String password;

    @Column(name = "PHONE", length = 45)
    private String phone;

    @Column(name = "AUTH_YN", length = 1, nullable = false, columnDefinition = "CHAR(1) DEFAULT 'N'")
    private char authYn = 'N';

    @Column(name = "CREATED_DATE", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "LAST_UPDATED_DATE", nullable = false)
    private LocalDateTime lastUpdatedDate;

    @Column(name = "CREATOR", length = 45)
    private String creator;

    @Column(name = "LAST_UPDATER", length = 45)
    private String lastUpdater;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.createdDate = now;
        this.lastUpdatedDate = now;
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastUpdatedDate = LocalDateTime.now();
    }
}
