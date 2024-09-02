package com.co.coupleDiary.calendar.service;

import com.co.coupleDiary.calendar.model.CalendarEvent;
import com.co.coupleDiary.calendar.repository.CalendarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalendarService {

    private final CalendarRepository calendarRepository;

    public List<CalendarEvent> getAllCalendarEvents() {
        return calendarRepository.findAll();
    }

    public List<CalendarEvent> getCalendarEvents(LocalDate date) {
        return calendarRepository.findByYearAndMonth(date.getYear(), date.getMonthValue());
    }

}
