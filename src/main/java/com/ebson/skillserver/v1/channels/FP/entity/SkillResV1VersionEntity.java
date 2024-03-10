package com.ebson.skillserver.v1.channels.FP.entity;

import com.ebson.skillserver.converter.UUIDToBytesConverter;
import jakarta.persistence.*;
// import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "SKILL_RES_V1_VERSION")
@Getter
@Setter
public class SkillResV1VersionEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "VERSION_ID", nullable = false, columnDefinition = "BINARY(16)")
    @Convert(converter = UUIDToBytesConverter.class)
    private UUID versionId;

    @Column(name = "BLOCK_ID", nullable = false, length = 45)
    private String blockId;

    @Column(name = "BLOCK_CODE", nullable = false, length = 45)
    private String blockCode;

    @Column(name = "MAJOR")
    private Integer major;

    @Column(name = "MINOR")
    private Integer minor;

    @Column(name = "CREATED_DATE", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "LAST_UPDATED_DATE", nullable = false)
    private LocalDateTime lastUpdatedDate;

    @Column(name = "CREATOR", nullable = false, length = 45)
    private String creator;

    @Column(name = "LAST_UPDATER", nullable = false, length = 45)
    private String lastUpdater;

}
