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
@Table(name = "SKILL_RES_V1_TEMPLATE_BASICCARD")
@Getter @Setter
public class SkillResV1TemplateBasicCardEntity {

    @Id
    @Column(name = "COMPONENT_ID", nullable = false, columnDefinition = "BINARY(16)")
    @Convert(converter = UUIDToBytesConverter.class)
    private UUID componentId;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY) // carousel item 인 경우 N:1
    @JoinColumn(name = "COMPONENT_ID")
    private SkillResV1TemplateComponentEntity skillResV1TemplateComponentEntity;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "CAROUSEL_ID", referencedColumnName = "CAROUSEL_ID", foreignKey = @ForeignKey(name = "FK_BASICCARD_CAROUSEL_ID"))
    private SkillResV1TemplateCarouselEntity skillResV1TemplateCarouselEntity;

    @Column(name = "CARD_ORD")
    private Integer cardOrd;

    @Column(name = "DATA_TYPE", length = 1)
    private String dataType;

    @Column(name = "TITLE", length = 45)
    private String title;

    @Column(name = "DESC", length = 255)
    private String desc;

    @Column(name = "THUMB_IMG_URL", length = 255)
    private String thumbImgUrl;

    @Column(name = "THUMB_LINK_WEB", length = 255)
    private String thumbLinkWeb;

    @Column(name = "THUMB_LINK_PC", length = 255)
    private String thumbLinkPc;

    @Column(name = "THUMB_LINK_MOBILE", length = 255)
    private String thumbLinkMobile;

    @Column(name = "THUMB_FIXED_RATIO", length = 5)
    private String thumbFixedRatio;

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
