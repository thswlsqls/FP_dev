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
@Table(name = "SKILL_RES_V1_TEMPLATE_COMPONENT_BTN")
@Getter @Setter
public class SkillResV1TemplateComponentBtnEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "BTN_ID", nullable = false, columnDefinition = "BINARY(16)")
    @Convert(converter = UUIDToBytesConverter.class)
    private UUID btnId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPONENT_ID", referencedColumnName = "COMPONENT_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_BTN_COMPONENT_ID"))
    private SkillResV1TemplateComponentEntity skillResV1TemplateComponentEntity;

    @Column(name = "LABEL", length = 45)
    private String label;

    @Column(name = "ACTION", length = 45)
    private String action;

    @Column(name = "WEB_LINK_URL", length = 255)
    private String webLinkUrl;

    @Column(name = "MESSAGE_TEXT", length = 255)
    private String messageText;

    @Column(name = "PHONE", length = 45)
    private String phone;

    @Column(name = "BLOCK_ID", length = 45)
    private String blockId;

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

