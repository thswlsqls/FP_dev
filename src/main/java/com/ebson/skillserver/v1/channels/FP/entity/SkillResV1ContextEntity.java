package com.ebson.skillserver.v1.channels.FP.entity;

import com.ebson.skillserver.converter.UUIDToBytesConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @OneToOne(fetch = FetchType.LAZY)
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
