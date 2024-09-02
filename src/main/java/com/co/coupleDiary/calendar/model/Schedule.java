package com.co.coupleDiary.calendar.model;

import lombok.Data;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "SCHEDULE")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SCHEDULE_NO")
    @SequenceGenerator(name = "SEQ_SCHEDULE_NO", sequenceName = "SEQ_SCHEDULE_NO", allocationSize = 1)
    private Long no;

    @Column(name = "WRITER_NO")
    private Long writerNo;

    private String title;

    private String content;

    @Column(name = "CATEGORY", columnDefinition = "VARCHAR2(100) DEFAULT 'SCHE'")
    private String category;

    @Column(name = "ENROLL_DATE", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime enrollDate;

    @Column(name = "MODIFY_DATE")
    private LocalDateTime modifyDate;

    @Column(name = "DEL_YN", columnDefinition = "CHAR(1) DEFAULT 'N'")
    private String delYn;

    @Column(name = "CHECK_DATE")
    private LocalDateTime checkDate;

    private String code;
}
