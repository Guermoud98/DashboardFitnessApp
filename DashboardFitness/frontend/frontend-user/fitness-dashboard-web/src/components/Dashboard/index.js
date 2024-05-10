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
            <div className="info">
                <h3>Welcome to My Fitness App</h3>
                <div className="height-width-container">
                    <div className="height-container">
                        <div className="height-card-bg">
                            <HeightCard/>
                        </div>
                    </div>
                    <div className="weight-container">
                        <div className="weight-card-bg">
                            <WeightCard/>
                        </div>
                    </div>
                </div>

                <div className="nutrition-container">
                    <div className="nutrition-card-bg">
                        <NutritionCard/>
                    </div>
                </div>

            </div>

            <div className="main-content">
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
