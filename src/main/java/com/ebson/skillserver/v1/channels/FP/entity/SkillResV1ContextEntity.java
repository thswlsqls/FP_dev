package com.ebson.skillserver.v1.channels.FP.entity;

import com.ebson.skillserver.converter.UUIDToBytesConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "SKILL_RES_V1_CONTEXT")
@Getter @Setter
public class SkillResV1ContextEntity {

    @Id
    @Column(name = "CONTEXT_ID", nullable = false, columnDefinition = "BINARY(16)")
    @Convert(converter = UUIDToBytesConverter.class)
    private UUID contextId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CONTEXT_ID", referencedColumnName = "CONTEXT_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_RES_CONTEXT_CONTEXT_ID"))
    private BuilderV1BlockContextEntity builderV1BlockContextEntity;

    @Column(name = "BLOCK_CODE", nullable = false, length = 45)
    private String blockCode;

    @Column(name = "CONTEXT_NAME", length = 45)
    private String contextName;

    @Column(name = "CONTEXT_TYPE", length = 5)
    private String contextType;

    @Column(name = "LIFESPAN")
    private Integer lifespan;

    @Column(name = "TTL")
    private Integer ttl;

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
