import React from 'react'
import "./index.css"


import Schedule from "../TestSchedule";
import List from "../List";
import Nutritions from "../Courses";

const courseDetails = [
    { id: 1, total: 2, text: 'Current Courses ', color: 'orange' },
    { id: 2, total: 5, text: 'Completed Courses', color: 'green', },
    { id: 3, total: 10, text: "Interested Courses", color: 'blue' },
];

const Body = () => {
    return (
        <div className='w-100 course-wrapper'>
            <div className='d-flex justify-content-around'>
                <div>
                    <div className='d-flex gap-5 mt-4 '>
                        {courseDetails.map(each => (
                            <Nutritions key={each.id} each={each} />
                        ))}
                    </div>
                    <div>
                        <List />
                    </div>
                </div>
                <Schedule />
            </div>
        </div>
    );
};

export default Body;


