package com.co.coupleDiary.calendar.repository;

import com.co.coupleDiary.calendar.model.CalendarEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CalendarRepository extends JpaRepository<CalendarEvent, Long> {

    @Query(value = "SELECT S.NO, S.TITLE, S.CONTENT, TO_CHAR(S.CHECK_DATE, 'YYYY-MM-DD') AS CHECK_DATE, S.CODE, S.CATEGORY, S.DEL_YN " +
            "FROM SCHEDULE S " +
            "WHERE S.CODE = :code " +
            "UNION ALL " +
            "SELECT A.NO, A.TITLE, A.CONTENT, TO_CHAR(A.CHECK_DATE, 'YYYY-MM-DD') AS CHECK_DATE, A.CODE, A.CATEGORY, A.DEL_YN " +
            "FROM ANNIVERSARY A " +
            "WHERE A.CODE = :code " +
            "UNION ALL " +
            "SELECT T.NO, T.TITLE, T.CONTENT, TO_CHAR(T.CHECK_DATE, 'YYYY-MM-DD') AS CHECK_DATE, T.CODE, T.CATEGORY, T.DEL_YN " +
            "FROM TODO T " +
            "WHERE T.CODE = :code",
            nativeQuery = true)
    List<CalendarEvent> getCalendarList(@Param("code") String code);

    @Query("SELECT e FROM CalendarEvent e WHERE FUNCTION('YEAR', e.enrollDate) = :year AND FUNCTION('MONTH', e.enrollDate) = :month")
    List<CalendarEvent> findByYearAndMonth(@Param("year") int year, @Param("month") int month);

}
