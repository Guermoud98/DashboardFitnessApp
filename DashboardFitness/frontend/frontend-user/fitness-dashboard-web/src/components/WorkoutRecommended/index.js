import React from 'react';
import './index.css';

const WorkoutRecommended = () => {
    return (
        <div className="workout-recommended-container">
            <h5 className="workout-recommended-title">Workouts Recommended</h5>
                <div className="workout-list">
                    <div className="workout-item">
                        <p>Workout 1</p>
                    </div>
                    <div className="workout-item">
                        <p>Workout 2</p>
                    </div>
                    <div className="workout-item">
                        <p>Workout 3</p>
                    </div>
                    {/* Ajoutez d'autres workouts recommandés ici */}
                </div>

        </div>
    );
};

export default WorkoutRecommended;
