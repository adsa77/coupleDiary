package com.co.coupleDiary.calendar.dao;

import com.co.coupleDiary.calendar.mapper.CalendarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CalendarDao {

    private final CalendarMapper mapper;

}
