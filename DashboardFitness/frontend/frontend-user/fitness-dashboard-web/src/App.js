import React from 'react';
import './App.css';
import VerticalNavbar from './components/Navbar';
import Header from './components/Header';
import Calendar from './components/Calendar';
import WorkoutRecommended from './components/WorkoutRecommended';
import WeightCard from "./components/Weight";
import HeightCard from "./components/Height";
import Body from "./components/Body";
import NutritionCard from "./components/Nutritions";


function App() {
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
                        <WorkoutRecommended/>
                    </div>
                    <div className="card m-3 p-3">
                        <Calendar/>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default App;

