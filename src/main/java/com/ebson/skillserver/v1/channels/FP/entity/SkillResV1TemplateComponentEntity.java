package com.ebson.skillserver.v1.channels.FP.entity;

import com.ebson.skillserver.converter.UUIDToBytesConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "SKILL_RES_V1_TEMPLATE_COMPONENT")
@Getter @Setter
public class SkillResV1TemplateComponentEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "COMPONENT_ID", nullable = false, columnDefinition = "BINARY(16)")
    @Convert(converter = UUIDToBytesConverter.class)
    private UUID componentId;

    @ManyToOne(fetch = FetchType.LAZY) // carousel 인 경우 N:1
    @JoinColumn(name = "OUTPUT_ID", referencedColumnName = "OUTPUT_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_COMPONENT_OUTPUT_ID"))
    private SkillResV1TemplateOutputEntity skillResV1TemplateOutputEntity;

    @Column(name = "COMPONENT_TYPE", length = 15)
    private String componentType;

    @Column(name = "COMPONENT_NAME", length = 45)
    private String componentName;

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
