package com.co.coupleDiary.calendar.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "CALENDAR")
public class CalendarEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CALENDAR_NO")
    @SequenceGenerator(name = "SEQ_CALENDAR_NO", sequenceName = "SEQ_CALENDAR_NO", allocationSize = 1)
    private Long no;

    private String title;
    private String content;
    private String code;
    private String category;

    @Column(name = "ENROLL_DATE", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime enrollDate;

    @Column(name = "DEL_YN", columnDefinition = "CHAR(1) DEFAULT 'N'")
    private String delYn;

    @Transient
    public int getYear() {
        return enrollDate.getYear();
    }

    @Transient
    public int getMonth() {
        return enrollDate.getMonthValue();
    }



}
