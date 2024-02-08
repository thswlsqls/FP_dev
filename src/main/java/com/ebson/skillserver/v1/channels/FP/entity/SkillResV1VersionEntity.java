package com.ebson.skillserver.v1.channels.FP.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "SKILL_RES_V1_VERSION")
@Getter
@Setter
public class SkillResV1VersionEntity {

    @Id
    @Column(name = "VERSION_ID", columnDefinition = "BINARY(16)")
    private byte[] versionId;

    @Column(name = "BLOCK_ID", nullable = false, columnDefinition = "BINARY(16)")
    private byte[] blockId;

    @Column(name = "MAJOR")
    private Integer major;

    @Column(name = "MINOR")
    private Integer minor;

    @Column(name = "CREATED_DATE", nullable = false)
    private Date createdDate;

    @Column(name = "LAST_UPDATED_DATE", nullable = false)
    private Date lastUpdatedDate;

    @Column(name = "CREATOR", columnDefinition = "BINARY(16)")
    private byte[] creator;

    @Column(name = "LAST_UPDATER", columnDefinition = "BINARY(16)")
    private byte[] lastUpdater;

}
