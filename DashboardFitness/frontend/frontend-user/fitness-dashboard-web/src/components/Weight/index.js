// WeightCard.jsx (ou tout autre nom de fichier approprié)
import React from 'react';

const WeightCard = () => {
    return (
        <div className="weight-card-container">
            <div className="card weight-card">
                <div className="card-body d-flex align-items-center justify-content-center">
                    <h5 className="card-title text-center">Your Weight</h5>
                    <p className="card-text text-center">Current Weight: XXX lbs</p>
                    {/* Add more content related to weight if needed */}
                </div>
            </div>
        </div>
    );
};

export default WeightCard;
