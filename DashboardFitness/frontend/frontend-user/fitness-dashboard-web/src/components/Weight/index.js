// WeightCard.jsx (ou tout autre nom de fichier approprié)
import React from 'react';

const WeightCard = () => {
    return (
        <div className="weight-card-container">
            <div className="card weight-card">
                <div className="card-body d-flex align-items-center justify-content-center weight">
                    <h5 className="card-title text-center">Your current Weight: 50kgs</h5>
                </div>
            </div>
        </div>
    );
};
export default WeightCard;
