package com.ebson.skillserver.v1.channels.FP.entity;

import com.ebson.skillserver.converter.UUIDToBytesConverter;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "SKILL_BUSI_V1_BLOCK_PROC")
@Getter @Setter
public class SkillBusiV1BlockProcEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "PROC_ID", nullable = false, columnDefinition = "BINARY(16)")
    @Convert(converter = UUIDToBytesConverter.class)
    private UUID procId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BLOCK_ID", referencedColumnName = "BLOCK_ID", foreignKey = @ForeignKey(name = "FK_PROC_BLOCK_ID"))
    private BuilderV1BlockEntity builderV1BlockEntity;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CONTEXT_ID", referencedColumnName = "CONTEXT_ID", foreignKey = @ForeignKey(name = "FK_PROC_CONTEXT_ID"))
    private BuilderV1BlockContextEntity builderV1BlockContextEntity;

    @Column(name = "BLOCK_CODE", length = 45)
    private String blockCode;

    @Column(name = "PROC_NAME", length = 45)
    private String procName;

    @Column(name = "IN_CONTEXT_NAME", length = 45)
    private String inContextName;

    @Column(name = "CREATED_DATE", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "LAST_UPDATE_DATE", nullable = false)
    @UpdateTimestamp
    private LocalDateTime lastUpdateDate;

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
