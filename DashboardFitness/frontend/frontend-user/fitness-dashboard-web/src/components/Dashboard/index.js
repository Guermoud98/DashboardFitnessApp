import React, {useState} from "react";
import VerticalNavbar from "../Navbar";
import HeightCard from "../Height";
import WeightCard from "../Weight";
import NutritionCard from "../Nutritions";
import WorkoutRecommended from "../WorkoutRecommended";
import Calendar from "../Calendar";

function Dashboard() {
    return (
        <div className='d-flex'>
            <div className="navbar-container">
                <VerticalNavbar/>
            </div>
            <div style={{marginTop: '30px'}}>
                <h3>Hello Maria</h3>
                <div className='d-flex justify-content-between'>
                    <div className="height-card-bg " style={{marginRight: '10px'}}>
                        <HeightCard/>
                    </div>

                    <div className="weight-card-bg">
                        <WeightCard/>
                    </div>

                </div>
                <div className="nutrition-container" style={{marginTop: '20px', width: '600px' }}>
                    <div className="nutrition-card-bg" style={{ margin: '10px' }}>
                        <NutritionCard/>
                    </div>
                </div>
            </div>

            <div className="main-content" style={{position: 'absolute', top: 0, right: 0}}>
                <div className="card-container">
                    <div className="card m-3 p-3">
                    <WorkoutRecommended />
                    </div>
                    <div className="card m-3 p-3">
                        <Calendar/>
                    </div>
                </div>
            </div>

        </div>
    );
}

export default Dashboard;
