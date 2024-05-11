package com.ebson.skillserver.v1.channels.FP.entity;

import com.ebson.skillserver.converter.UUIDToBytesConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "SKILL_RES_V1_TEMPLATE")
@Getter @Setter
public class SkillResV1TemplateEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "TEMPLATE_ID", nullable = false, columnDefinition = "BINARY(16)")
    @Convert(converter = UUIDToBytesConverter.class)
    private UUID templateId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BLOCK_ID", referencedColumnName = "BLOCK_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_TEMPLATE_BLOCK_ID"))
    private BuilderV1BlockEntity builderV1BlockEntity;

    @Column(name = "BLOCK_CODE", nullable = false, length = 45)
    private String blockCode;

    @Column(name = "TEMPLATE_NAME", length = 45)
    private String templateName;

    @Column(name = "CREATED_DATE", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "LAST_UPDATED_DATE", nullable = false)
    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @Column(name = "CREATOR", length = 45)
    private String creator;

    @Column(name = "LAST_UPDATER", length = 45)
    private String lastUpdater;

    @PrePersist
    protected void onCreate() {
        /**
         * 저장 전 검증 로직 수행
         * LocalDateTime now = LocalDateTime.now();
         * this.createdDate = now;
         * this.lastUpdatedDate = now;
         */
    }

    @PreUpdate
    protected void onUpdate() {
        /**
         * 업데이트 전 검증 로직 수행
         * this.lastUpdatedDate = LocalDateTime.now();
         * */
    }
}
