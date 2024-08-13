let today = new Date();
let todayDate = today.getDate();
let thisMonth = today.getMonth();
let thisYear = today.getFullYear();

//캘린더 생성 함수
function generateCalendar(year, month){
    const weekdays = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];

    //캘린더 비우기
    let calendar = document.getElementById('calendar');
    calendar.innerHTML = '';

    //월의 첫 날
    let firstDayOfMonth = new Date(year, month, 1);
    let startingDay = firstDayOfMonth.getDay();

    //월의 마지막 날
    let lastDayOfMonth = new Date(year, month + 1, 0);
    let lastDate = lastDayOfMonth.getDate();

    //전월의 마지막 날
    let lastDayOfLastMonth = new Date(year, month, 0);
    let lastDateOfLastMonth = lastDayOfLastMonth.getDate();

    let dayElement, date;
	for (let j = 0; j < 7; j++) {
		dayElement = document.createElement('div');
		dayElement.textContent = weekdays[j];
		dayElement.classList.add('day', 'header-day');
		calendar.appendChild(dayElement);
	}

    for(let i = 0; i < 42; i++){
        let dayElement = document.createElement('div');
        let date;
        let dateId;

        if (i < startingDay) {
			// 이전 달 날짜 표시
			date = lastDateOfLastMonth - startingDay + i + 1;
			let prevMonth = month === 0 ? 11 : month - 1; // 이전 달
			let prevMonthYear = month === 0 ? year - 1 : year;
			dateId = `${prevMonthYear}-${(prevMonth + 1 < 10 ? '0' + (prevMonth + 1) : (prevMonth + 1))}-${(date < 10 ? '0' + date : date)}`;
			dayElement.textContent = date;
			dayElement.classList.add('day', 'disabled');
			dayElement.id = dateId;
		} else if (i >= startingDay + lastDate) {
			// 다음 달 날짜 표시
			date = i - startingDay - lastDate + 1;
			let nextMonth = month === 11 ? 0 : month + 1; // 다음 달
			let nextMonthYear = month === 11 ? year + 1 : year;
			dateId = `${nextMonthYear}-${(nextMonth + 1 < 10 ? '0' + (nextMonth + 1) : (nextMonth + 1))}-${(date < 10 ? '0' + date : date)}`;
			dayElement.textContent = date;
			dayElement.classList.add('day', 'disabled');
			dayElement.id = dateId;
		} else {
            date = i - startingDay + 1;
            dayElement.textContent = date;
            dayElement.classList.add('day');
            let currentDate = new Date(year, month, date);
            if(currentDate.toDateString() === today.toDateString()){
                dayElement.classList.add('today');
            }
            // 현재 월의 날짜인 경우 아이디 설정
            dateId = `${year}-${(month + 1 < 10 ? '0' + (month + 1) : (month + 1))}-${(date < 10 ? '0' + date : date)}`;
            dayElement.id = dateId;
        }


        calendar.appendChild(dayElement);
    }
}

//캘린더 생성
generateCalendar(thisYear, thisMonth);

document.querySelector('#todayDate').textContent = `${thisYear}/${thisMonth.toString().padStart(2, '0')}`;