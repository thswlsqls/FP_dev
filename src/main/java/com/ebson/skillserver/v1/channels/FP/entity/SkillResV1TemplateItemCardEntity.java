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
@Table(name = "SKILL_RES_V1_TEMPLATE_ITEMCARD")
@Getter @Setter
public class SkillResV1TemplateItemCardEntity {

    @Id
    @Column(name = "COMPONENT_ID", nullable = false, columnDefinition = "BINARY(16)")
    @Convert(converter = UUIDToBytesConverter.class)
    private UUID componentId;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY) // carousel item 인 경우 N:1
    @JoinColumn(name = "COMPONENT_ID")
    private SkillResV1TemplateComponentEntity skillResV1TemplateComponentEntity;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "CAROUSEL_ID", referencedColumnName = "CAROUSEL_ID", foreignKey = @ForeignKey(name = "FK_ITEMCARD_CAROUSEL_ID"))
    private SkillResV1TemplateCarouselEntity skillResV1TemplateCarouselEntity;

    @Column(name = "CARD_ORD")
    private Integer cardOrd;

    @Column(name = "DATA_TYPE", length = 1)
    private String dataType;

    @Column(name = "THUMB_YN", length = 1)
    private String thumbYn;

    @Column(name = "THUMB_IMG_URL", length = 255)
    private String thumbImgUrl;

    @Column(name = "THUMB_WIDTH")
    private Integer thumbWidth;

    @Column(name = "THUMB_HEIGHT")
    private Integer thumbHeight;

    @Column(name = "THUMB_LINK_PC", length = 255)
    private String thumbLinkPc;

    @Column(name = "THUMB_LINK_MOB", length = 255)
    private String thumbLinkMob;

    @Column(name = "THUMB_LINK_WEB", length = 255)
    private String thumbLinkWeb;

    @Column(name = "HEAD_YN", length = 1)
    private String headYn;

    @Column(name = "HEAD_TITLE", length = 45)
    private String headTitle;

    @Column(name = "PROFILE_YN", length = 1)
    private String profileYn;

    @Column(name = "PROFILE_IMG_URL", length = 255)
    private String profileImgUrl;

    @Column(name = "PROFILE_WIDTH")
    private Integer profileWidth;

    @Column(name = "PROFILE_HEIGHT")
    private Integer profileHeight;

    @Column(name = "PROFILE_TITLE", length = 45)
    private String profileTitle;

    @Column(name = "IMGTITLE_YN", length = 1)
    private String imgtitleYn;

    @Column(name = "IMGTITLE_TITLE", length = 45)
    private String imgtitleTitle;

    @Column(name = "IMGTITLE_DESC", length = 255)
    private String imgtitleDesc;

    @Column(name = "IMGTITLE_IMG_URL", length = 255)
    private String imgtitleImgUrl;

    @Column(name = "ITEMLIST_ALIGN", length = 15, nullable = false)
    private String itemlistAlign;

    @Column(name = "ITEMLIST_SUMMARY_YN", length = 1)
    private String itemlistSummaryYn;

    @Column(name = "ITEMLIST_SUMMARY_TITLE", length = 45)
    private String itemlistSummaryTitle;

    @Column(name = "ITEMLIST_SUMMARY_DESC", length = 255)
    private String itemlistSummaryDesc;

    @Column(name = "TITLE", length = 45)
    private String title;

    @Column(name = "DESC", length = 255)
    private String desc;

    @Column(name = "BTN_LAYOUT", length = 15, nullable = false)
    private String btnLayout;

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
