import React from 'react';
import './index.css';

const WorkoutRecommended = ({ togglePhotos }) => {
    const handleClick = () => {
        togglePhotos(); // Appeler la fonction pour masquer l'annotation et afficher les photos
    };

    return (
        <div className="workout-recommended-container">
            <h5 className="workout-recommended-title">Workouts Recommended</h5>
            <div className="workout-list">
                <div className="workout-item">
                    <a className="workout-link" href="#" onClick={handleClick}>Workout for beginners</a>
                </div>
                <div className="workout-item">
                    <a className="workout-link" href="#" onClick={handleClick}>Workout for intermediate</a>
                </div>
                <div className="workout-item">
                    <a className="workout-link" href="#" onClick={handleClick}>Workout for advanced</a>
                </div>
                {/* Ajoutez d'autres workouts recommandés ici */}
            </div>
        </div>
    );
};

export default WorkoutRecommended;
