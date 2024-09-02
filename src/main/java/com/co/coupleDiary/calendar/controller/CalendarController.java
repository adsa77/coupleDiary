package com.co.coupleDiary.calendar.controller;

import com.co.coupleDiary.calendar.service.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("calendar")
@RequiredArgsConstructor
public class CalendarController {

    private final CalendarService calendarservice;

    @GetMapping("calendar")
    public String calendar(Model model){
//        model.addAttribute("events", calendarservice.getAllCalendarEvents());
        return "calendar/calendar";
    }

//    @GetMapping("calendar")
//    public String calendar(Model model){
//        return "calendar/calendar";
//    }

}
