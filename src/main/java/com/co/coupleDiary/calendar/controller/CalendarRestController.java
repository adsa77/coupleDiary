package com.co.coupleDiary.calendar.controller;

import com.co.coupleDiary.calendar.model.CalendarEvent;
import com.co.coupleDiary.calendar.service.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("api/calendar")
@RequiredArgsConstructor
public class CalendarRestController {

    private final CalendarService calendarService;

    @GetMapping("/current")
    public List<CalendarEvent> getCalendarEvents() {
        LocalDate today = LocalDate.now();
        return calendarService.getCalendarEvents(today);
    }
}
