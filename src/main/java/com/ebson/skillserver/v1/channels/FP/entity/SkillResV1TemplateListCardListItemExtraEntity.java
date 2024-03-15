package com.ebson.skillserver.v1.channels.FP.entity;

import com.ebson.skillserver.converter.UUIDToBytesConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "SKILL_RES_V1_TESMPLATE_LISTCARD_LISTITEM_EXTRA")
@Getter @Setter
public class SkillResV1TemplateListCardListItemExtraEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "EXTRA_ID", nullable = false, columnDefinition = "BINARY(16)")
    @Convert(converter = UUIDToBytesConverter.class)
    private UUID extraId;

    @Column(name = "LISTITEM_ORD", nullable = false)
    private Integer listItemOrd;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LISTITEM_ID", referencedColumnName = "LISTITEM_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_LISTITEM_EXTRA_LISTITEM_ID"))
    private SkillResV1TemplateListCardListItemEntity skillResV1TemplateListCardListItemEntity;

    @Column(name = "KEY", length = 255)
    private String key;

    @Column(name = "VALUE", length = 255)
    private String value;

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
