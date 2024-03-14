package com.ebson.skillserver.v1.channels.FP.entity;

import com.ebson.skillserver.converter.UUIDToBytesConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "SKILL_RES_V1_TEMPLATE_CAROUSEL")
@Getter @Setter
public class SkillResV1TemplateCarouselEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "CAROUSEL_ID", nullable = false, columnDefinition = "BINARY(16)")
    @Convert(converter = UUIDToBytesConverter.class)
    private UUID carouselId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPONENT_ID", referencedColumnName = "COMPONENT_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_CAROUSEL_COMPONENT_ID"))
    private SkillResV1TemplateComponentEntity skillResV1TemplateComponentEntity;

    @Column(name = "CARD_TYPE", length = 15)
    private String cardType;

    @Column(name = "HEADER_TITLE", length = 45)
    private String headerTitle;

    @Column(name = "HEADER_DESC", length = 255)
    private String headerDesc;

    @Column(name = "HEADER_THUMB", length = 255)
    private String headerThumb;

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

