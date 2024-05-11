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
@Table(name = "BUILDER_V1_SCENARIO")
@Getter @Setter
public class BuilderV1ScenarioEntity {
    @Id
    @Column(name = "SCENARIO_ID", nullable = false, length = 45)
    private String scenarioId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CHANNEL_ID", nullable = false, referencedColumnName = "CHANNEL_ID")
    private BuilderV1ChannelEntity builderV1ChannelEntity;

    @Column(name = "SCENARIO_CODE", nullable = false, length = 45)
    private String scenarioCode;

    @Column(name = "SCENARIO_NAME", length = 45)
    private String scenarioName;

    @Column(name = "CREATED_DATE", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "LAST_UPDATED_DATE", nullable = false)
    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @Column(name = "CREATOR", nullable = false, length = 45)
    private String creator;

    @Column(name = "LAST_UPDATER", nullable = false, length = 45)
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

