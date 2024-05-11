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
@Table(name = "SKILL_BUSI_V1_BLOCK_PROC_UNIT")
@Getter @Setter
public class SkillBusiV1BlockProcUnitEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "PROC_UNIT_ID", nullable = false, columnDefinition = "BINARY(16)")
    @Convert(converter = UUIDToBytesConverter.class)
    private UUID procUnitId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROC_ID", referencedColumnName = "PROC_ID", foreignKey = @ForeignKey(name = "FK_UNIT_PROC_ID"))
    private SkillBusiV1BlockProcEntity skillBusiV1BlockProcEntity;

    @Column(name = "PROC_UNIT_NO")
    private Integer procUnitNo;

    @Column(name = "PROC_UNIT_CODE", length = 45)
    private String procUnitCode;

    @Column(name = "PROC_UNIT_NAME", length = 45)
    private String procUnitName;

    @Column(name = "PROC_UNIT_TYPE", length = 5)
    private String procUnitType;

    @Column(name = "NEXT_PROC_UNIT_NO1")
    private Integer nextProcUnitNo1;

    @Column(name = "NEXT_PROC_UNIT_NO2")
    private Integer nextProcUnitNo2;

    @Column(name = "NEXT_PROC_UNIT_NO3")
    private Integer nextProcUnitNo3;

    @Column(name = "INTERFACE_CODE", length = 45)
    private String interfaceCode;

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

