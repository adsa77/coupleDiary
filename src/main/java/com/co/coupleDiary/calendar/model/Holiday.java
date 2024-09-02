package com.co.coupleDiary.calendar.model;

import lombok.Data;

import jakarta.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "HOLIDAY")
public class Holiday {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HOLIDAY_NO")
    @SequenceGenerator(name = "SEQ_HOLIDAY_NO", sequenceName = "SEQ_HOLIDAY_NO", allocationSize = 1)
    private Long no;

    private String title;

    private String content;

    @Column(name = "WRITER_NO")
    private Long writerNo;

    @Column(name = "HOLIDAY_DATE")
    private LocalDate holidayDate;

    @Column(name = "CATEGORY", columnDefinition = "VARCHAR2(100) DEFAULT 'HOLI'")
    private String category;

    private String code;

    @Column(name = "DEL_YN", columnDefinition = "CHAR(1) DEFAULT 'N'")
    private String delYn;
}
