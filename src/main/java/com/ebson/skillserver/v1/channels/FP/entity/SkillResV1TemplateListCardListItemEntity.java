package com.ebson.skillserver.v1.channels.FP.entity;

import com.ebson.skillserver.converter.UUIDToBytesConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "SKILL_RES_V1_TEMPLATE_LISTCARD_LISTITEM")
@Getter @Setter
public class SkillResV1TemplateListCardListItemEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "LISTITEM_ID", nullable = false, columnDefinition = "BINARY(16)")
    @Convert(converter = UUIDToBytesConverter.class)
    private UUID listItemId;

    @Column(name = "LISTITEM_ORD", nullable = false)
    private Integer listItemOrd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPONENT_ID", referencedColumnName = "COMPONENT_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_LISTITEM_COMPONENT_ID"))
    private SkillResV1TemplateListCardEntity skillResV1TemplateListCardEntity;

    @Column(name = "HEADER_YN", length = 1)
    private String headerYn;

    @Column(name = "TITLE", length = 45)
    private String title;

    @Column(name = "DESC", length = 255)
    private String desc;

    @Column(name = "IMG_URL", length = 255)
    private String imgUrl;

    @Column(name = "LINK_PC", length = 255)
    private String linkPc;

    @Column(name = "LINK_MOBILE", length = 255)
    private String linkMobile;

    @Column(name = "LINK_WEB", length = 255)
    private String linkWeb;

    @Column(name = "ACTION", length = 45)
    private String action;

    @Column(name = "BLOCK_ID", columnDefinition = "BINARY(16)")
    private UUID blockId;

    @Column(name = "MESSAGE_TEXT", length = 255)
    private String messageText;

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
