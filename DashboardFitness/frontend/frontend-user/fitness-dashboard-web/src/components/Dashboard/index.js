import React, { useState, useEffect } from "react";
import VerticalNavbar from "../Navbar";
import HeightCard from "../Height";
import WeightCard from "../Weight";
import NutritionCard from "../Nutritions/NutritionDashboard";
import WorkoutRecommended from "../WorkoutRecommended";
import Calendar from "../Calendar";

const images = [
    require("../../Assets/WorkoutMoves/move1.png"),
    require("../../Assets/WorkoutMoves/move2.png"),
    require("../../Assets/WorkoutMoves/move3.png"),
];

const Dashboard = () => {
    const [showNutrition, setShowNutrition] = useState(true);
    const [showPhotos, setShowPhotos] = useState(false);
    const [currentImageIndex, setCurrentImageIndex] = useState(0);
    const [countdown, setCountdown] = useState(10); // Initial countdown value

    const togglePhotos = () => {
        setShowNutrition(false); // Hide the annotation
        setShowPhotos(true); // Show the photos
    };

    useEffect(() => {
        if (showPhotos) {
            const timeout = setTimeout(() => {
                setCurrentImageIndex(prevIndex => (prevIndex + 1) % images.length);
                setCountdown(10); // Reset countdown to 10 when changing the image
            }, 10000); // 10 seconds

            // Decrement countdown every second
            const interval = setInterval(() => {
                setCountdown(prevCountdown => prevCountdown - 1);
            }, 1000);

            // Clean up timers on component unmount or when showPhotos becomes false
            return () => {
                clearTimeout(timeout);
                clearInterval(interval);
            };
        }
    }, [showPhotos, currentImageIndex]);

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
                {/* Conditionally render either the NutritionCard or the photos */}
                {showNutrition ? (
                    <div className="nutrition-container" style={{marginTop: '20px', width: '600px' }}>
                        <div className="nutrition-card-bg" style={{ margin: '10px'}}>
                            <NutritionCard/>
                        </div>
                    </div>
                ) : (
                    <div>
                        {showPhotos && (
                            <div>
                                <img src={images[currentImageIndex]}  alt="Your Image" style={{ width: '250px', height:"250px", marginTop: '20px', marginLeft: '150px' }} />
                                <p style={{ marginLeft: '210px', fontWeight: 'bold'}}>Countdown: {countdown}</p>
                            </div>
                        )}
                    </div>
                )}
            </div>

            <div className="main-content" style={{position: 'absolute', top: 0, right: 0}}>
                <div className="card-container">
                    <div className="card m-3 p-3">
                        <WorkoutRecommended togglePhotos={togglePhotos} />
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
