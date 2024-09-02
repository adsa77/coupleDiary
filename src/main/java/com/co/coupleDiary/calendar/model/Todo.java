package com.co.coupleDiary.calendar.model;

import lombok.Data;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "TODO")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TODO_NO")
    @SequenceGenerator(name = "SEQ_TODO_NO", sequenceName = "SEQ_TODO_NO", allocationSize = 1)
    private Long no;

    @Column(name = "WRITER_NO")
    private Long writerNo;

    private String title;

    private String content;

    @Column(name = "CATEGORY", columnDefinition = "VARCHAR2(100) DEFAULT 'TODO'")
    private String category;

    @Column(name = "ENROLL_DATE", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime enrollDate;

    @Column(name = "MODIFY_DATE")
    private LocalDateTime modifyDate;

    @Column(name = "COMPLETE_YN", columnDefinition = "CHAR(1) DEFAULT 'N'")
    private String completeYn;

    @Column(name = "DEL_YN", columnDefinition = "CHAR(1) DEFAULT 'N'")
    private String delYn;

    @Column(name = "CHECK_DATE")
    private LocalDate checkDate;

    private String code;
}
