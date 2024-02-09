package com.ebson.skillserver.v1.channels.FP.entity;

import com.ebson.skillserver.config.UUIDToBytesConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "SKILL_RES_V1_VERSION")
@Getter
@Setter
public class SkillResV1VersionEntity {

    @Id
    @Column(name = "VERSION_ID", columnDefinition = "BINARY(16)")
    @Convert(converter = UUIDToBytesConverter.class)
    private UUID versionId;

    @Column(name = "BLOCK_ID", nullable = false, columnDefinition = "BINARY(16)")
    @Convert(converter = UUIDToBytesConverter.class)
    private UUID blockId;

    @Column(name = "MAJOR")
    private Integer major;

    @Column(name = "MINOR")
    private Integer minor;

    @Column(name = "CREATED_DATE", nullable = false)
    private Date createdDate;

    @Column(name = "LAST_UPDATED_DATE", nullable = false)
    private Date lastUpdatedDate;

    @Column(name = "CREATOR", columnDefinition = "BINARY(16)")
    @Convert(converter = UUIDToBytesConverter.class)
    private UUID creator;

    @Column(name = "LAST_UPDATER", columnDefinition = "BINARY(16)")
    @Convert(converter = UUIDToBytesConverter.class)
    private UUID lastUpdater;

}
