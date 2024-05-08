import React, { useState } from 'react';
import Calendar from 'react-calendar';
import 'react-calendar/dist/Calendar.css';
import './index.css';

const CustomCalendar = () => {
    const [date, setDate] = useState(new Date());

    const onChange = date => {
        setDate(date);
    }

    return (
        <div >
            <h2>Calendrier</h2>
            <Calendar
                onChange={onChange}
                value={date}
            />
        </div>
    );
};

export default CustomCalendar;
