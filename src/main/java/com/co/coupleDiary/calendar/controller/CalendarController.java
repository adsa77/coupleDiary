package com.co.coupleDiary.calendar.controller;

import com.co.coupleDiary.calendar.service.CalenarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("calendar")
@RequiredArgsConstructor
public class CalendarController {

    private final CalenarService service;

    @GetMapping("calendar")
    public String calendar(){
        return "calendar/calendar";
    }

}
