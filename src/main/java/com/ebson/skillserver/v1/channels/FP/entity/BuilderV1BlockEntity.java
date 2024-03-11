package com.ebson.skillserver.v1.channels.FP.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "BUILDER_V1_BLOCK")
@Getter @Setter
public class BuilderV1BlockEntity {
    @Id
    @Column(name = "BLOCK_ID", nullable = false, length = 45)
    private String blockId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCENARIO_ID", nullable = false, referencedColumnName = "SCENARIO_ID", foreignKey = @ForeignKey(name = "FK_BLOCK_SCENARIO_ID"))
    private BuilderV1ScenarioEntity builderV1ScenarioEntity;

    @Column(name = "BLOCK_CODE", nullable = false, length = 45)
    private String blockCode;

    @Column(name = "BLOCK_NAME", length = 45)
    private String blockName;

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
