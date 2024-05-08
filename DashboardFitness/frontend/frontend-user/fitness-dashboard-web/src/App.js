import React from 'react';
import './App.css';
import VerticalNavbar from './components/Navbar';
import Header from './components/Header';
import Calendar from './components/Calendar';
import WorkoutRecommended from './components/WorkoutRecommended';
import WeightCard from "./components/Weight";
import HeightCard from "./components/Height";


function App() {
    return (
        <div className='d-flex'>
            <div className="navbar-container">
                <VerticalNavbar/>
            </div>
            <div>
                <div className="header-container">
                    <Header/>
                </div>
                <div className="height-width-container">
                    <div className="height-container">
                        <div className="height-card-bg"> {/* Add this div for background color */}
                            <HeightCard/>
                        </div>
                    </div>
                    <div className="weight-container">
                        <div className="weight-card-bg"> {/* Add this div for background color */}
                            <WeightCard/>
                        </div>
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

