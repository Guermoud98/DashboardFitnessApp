import React from 'react';
import './index.css';

const WorkoutRecommended = ({ hideNutritionCard }) => {
    return (
        <div className="workout-recommended-container">
            <h5 className="workout-recommended-title">Workouts Recommended</h5>
                <div className="workout-list">
                    <div className="workout-item">
                        <a className="workout-link" href="#">Workout 1 </a>
                    </div>
                    <div className="workout-item">
                        <a className="workout-link" href="#">Workout 2 </a>

                    </div>
                    <div className="workout-item">
                        <a className="workout-link" href="#">Workout 3 </a>
                    </div>
                    {/* Ajoutez d'autres workouts recommandés ici */}
                </div>

        </div>
    );
};

export default WorkoutRecommended;
