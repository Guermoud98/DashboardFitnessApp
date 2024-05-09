import React, { useState } from 'react';
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
    const [showNutritionCard, setShowNutritionCard] = useState(true);
    const [workoutImage, setWorkoutImage] = useState(null);

    // Fonction pour masquer la carte de nutrition
    const hideNutritionCard = () => {
        setShowNutritionCard(false);
    };

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
                {/* Condition pour afficher la carte de nutrition */}
                {showNutritionCard && (
                    <div className="nutrition-container">
                        <div className="nutrition-card-bg">
                            <NutritionCard/>
                        </div>
                    </div>
                )}
            </div>

            <div className="main-content">
                <div className="card-container">
                    <div className="card m-3 p-3">
                        {/* Passer la fonction hideNutritionCard en tant que prop */}
                        <WorkoutRecommended hideNutritionCard={hideNutritionCard} setWorkoutImage={setWorkoutImage} />
                    </div>
                    <div className="card m-3 p-3">
                        <Calendar/>
                    </div>
                </div>
            </div>

            {/* Afficher l'image de l'entraînement */}
            {workoutImage && (
                <div className="workout-image-container">
                    <img src={workoutImage} alt="Workout" />
                </div>
            )}
        </div>
    );
}

export default App;
