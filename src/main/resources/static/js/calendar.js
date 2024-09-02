document.addEventListener('DOMContentLoaded', function() {
    // 현재 날짜
    let today = new Date();
    let thisYear = today.getFullYear();
    let thisMonth = today.getMonth();

    // 캘린더 생성 함수
    function generateCalendar(year, month, events) {
        const weekdays = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];
        const section = document.querySelector('section');
        section.innerHTML = ''; // 이전 캘린더 내용 제거

        // 캘린더 헤더
        let header = document.createElement('div');
        header.id = 'header';
        header.innerHTML = `
            <div id="leftHeader">
            </div>
            <div id="moveLastMonth">
                <h1>⬅️</h1>
            </div>
            <div id="todayDate">
                <div id="thisYear">${year}</div>
                <div id="thisMonth">${(month + 1).toString().padStart(2, '0')}</div>
            </div>
            <div id="moveNextMonth">
                <h1>➡️</h1>
            </div>
            <div id="rightHeader">
            </div>
        `;
        section.appendChild(header);

        // 캘린더 생성
        let calendar = document.createElement('div');
        calendar.id = 'calendar';
        section.appendChild(calendar);

        let firstDayOfMonth = new Date(year, month, 1);
        let startingDay = firstDayOfMonth.getDay();
        let lastDayOfMonth = new Date(year, month + 1, 0);
        let lastDate = lastDayOfMonth.getDate();

        let lastDayOfLastMonth = new Date(year, month, 0);
        let lastDateOfLastMonth = lastDayOfLastMonth.getDate();

        let dayElement;
        for (let j = 0; j < 7; j++) {
            dayElement = document.createElement('div');
            dayElement.textContent = weekdays[j];
            dayElement.classList.add('day', 'header-day');
            calendar.appendChild(dayElement);
        }

        // events가 배열인지 확인하고, 배열이 아닐 경우 빈 배열로 초기화
        if (!Array.isArray(events)) {
            events = [];
        }

        for (let i = 0; i < 42; i++) {
            dayElement = document.createElement('div');
            let date;
            let dateId;

            if (i < startingDay) {
                // 이전 달의 날짜
                date = lastDateOfLastMonth - startingDay + i + 1;
                let prevMonth = month === 0 ? 11 : month - 1;
                let prevMonthYear = month === 0 ? year - 1 : year;
                dateId = `${prevMonthYear}-${(prevMonth + 1).toString().padStart(2, '0')}-${date.toString().padStart(2, '0')}`;
                dayElement.textContent = date;
                dayElement.classList.add('day', 'disabled');
                dayElement.id = dateId;
            } else if (i >= startingDay + lastDate) {
                // 다음 달의 날짜
                date = i - startingDay - lastDate + 1;
                let nextMonth = month === 11 ? 0 : month + 1;
                let nextMonthYear = month === 11 ? year + 1 : year;
                dateId = `${nextMonthYear}-${(nextMonth + 1).toString().padStart(2, '0')}-${date.toString().padStart(2, '0')}`;
                dayElement.textContent = date;
                dayElement.classList.add('day', 'disabled');
                dayElement.id = dateId;
            } else {
                // 현재 달의 날짜
                date = i - startingDay + 1;
                dayElement.textContent = date;
                dayElement.classList.add('day');
                let currentDate = new Date(year, month, date);
                if (currentDate.toDateString() === today.toDateString()) {
                    dayElement.classList.add('today');
                }
                dateId = `${year}-${(month + 1).toString().padStart(2, '0')}-${date.toString().padStart(2, '0')}`;
                dayElement.id = dateId;

                // 이벤트 추가
                let event = events.find(event => event.date === dateId);
                if (event) {
                    dayElement.classList.add('event');
                    dayElement.title = event.title;  // Hover title or other event info
                }
            }

            calendar.appendChild(dayElement);
        }

        // 월 이동 이벤트 리스너
        document.getElementById('moveLastMonth').addEventListener('click', function() {
            thisMonth--;
            if (thisMonth < 0) {
                thisMonth = 11;
                thisYear--;
            }
            fetchCalendarData(thisYear, thisMonth);
        });

        document.getElementById('moveNextMonth').addEventListener('click', function() {
            thisMonth++;
            if (thisMonth > 11) {
                thisMonth = 0;
                thisYear++;
            }
            fetchCalendarData(thisYear, thisMonth);
        });
    }

    // 서버에서 캘린더 데이터 가져오기
    function fetchCalendarData(year, month) {
        const dateString = `${year}-${(month + 1).toString().padStart(2, '0')}-01`;
        fetch(`/api/calendar?date=${dateString}`)
            .then(response => response.json())
            .then(data => {
                generateCalendar(year, month, data);
            })
            .catch(error => console.error('Error fetching calendar data:', error));
    }

    // 초기 캘린더 로드
    fetchCalendarData(thisYear, thisMonth);
});
