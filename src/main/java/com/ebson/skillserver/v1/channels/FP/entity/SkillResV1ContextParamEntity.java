package com.ebson.skillserver.v1.channels.FP.entity;

import com.ebson.skillserver.converter.UUIDToBytesConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "SKILL_RES_V1_CONTEXT_PARAM")
@IdClass(SkillResV1ContextParamEntity.PK.class)
@Getter @Setter
public class SkillResV1ContextParamEntity {

    @Id
    @Column(name = "PARAM_NO", nullable = false)
    private Integer paramNo;

    @Id
    @Column(name = "CONTEXT_ID", nullable = false, columnDefinition = "BINARY(16)")
    @Convert(converter = UUIDToBytesConverter.class)
    private UUID contextId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTEXT_ID", referencedColumnName = "CONTEXT_ID", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "FK_CONTEXT_PARAM_CONTEXT_ID"))
    private SkillResV1ContextEntity skillResV1ContextEntity;

    @Column(name = "KEY")
    private String key;

    @Column(name = "VALUE")
    private String value;

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

    // Composite Primary Key Class
    @Getter @Setter
    public static class PK implements Serializable {
        private Integer paramNo;
        private UUID contextId;

        // Constructors, getters, setters, equals, and hashcode
    }
}