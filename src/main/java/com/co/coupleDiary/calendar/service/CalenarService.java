package com.co.coupleDiary.calendar.service;

import com.co.coupleDiary.calendar.dao.CalendarDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalenarService {

    private final CalendarDao dao;
}
