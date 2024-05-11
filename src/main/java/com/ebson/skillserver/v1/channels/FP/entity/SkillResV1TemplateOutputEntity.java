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
@Table(name = "SKILL_RES_V1_TEMPLATE_OUTPUT")
@Getter @Setter
public class SkillResV1TemplateOutputEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "OUTPUT_ID", nullable = false, columnDefinition = "BINARY(16)")
    @Convert(converter = UUIDToBytesConverter.class)
    private UUID outputId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEMPLATE_ID", referencedColumnName = "TEMPLATE_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_OUTPUT_TEMPLATE_ID"))
    private SkillResV1TemplateEntity skillResV1TemplateEntity;

    @Column(name = "OUTPUT_ORD")
    private Integer outputOrd;

    @Column(name = "OUTPUT_NAME", length = 45)
    private String outputName;

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
