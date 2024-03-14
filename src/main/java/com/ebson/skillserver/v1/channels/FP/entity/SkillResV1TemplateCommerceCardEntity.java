package com.ebson.skillserver.v1.channels.FP.entity;

import com.ebson.skillserver.converter.UUIDToBytesConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "SKILL_RES_V1_TEMPLATE_COMMERCECARD")
@Getter @Setter
public class SkillResV1TemplateCommerceCardEntity {
    @Id
    @Column(name = "COMPONENT_ID", nullable = false, columnDefinition = "BINARY(16)")
    @Convert(converter = UUIDToBytesConverter.class)
    private UUID componentId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "COMPONENT_ID", referencedColumnName = "COMPONENT_ID")
    private SkillResV1TemplateComponentEntity skillResV1TemplateComponentEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAROUSEL_ID", referencedColumnName = "CAROUSEL_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_COMMERCECARD_CAROUSEL_ID"))
    private SkillResV1TemplateCarouselEntity skillResV1TemplateCarouselEntity;

    @Column(name = "CARD_ORD")
    private Integer cardOrd;

    @Column(name = "DATA_TYPE", length = 1)
    private String dataType;

    @Column(name = "TITLE", length = 45)
    private String title;

    @Column(name = "DESC", length = 255)
    private String desc;

    @Column(name = "PRICE")
    private Integer price;

    @Column(name = "CURRENCY", length = 45)
    private String currency;

    @Column(name = "DISCOUNT")
    private Integer discount;

    @Column(name = "DISCOUNT_RATE")
    private Integer discountRate;

    @Column(name = "DISCOUNTED_PRICE")
    private Integer discountedPrice;

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

    @Column(name = "PROFILE_NICKNAME", length = 45)
    private String profileNickname;

    @Column(name = "PROFILE_IMG_URL", length = 255)
    private String profileImgUrl;

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
