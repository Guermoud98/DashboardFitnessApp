import React from 'react';
import smoothieBowlImage from '../../../Assets/Smoothie-bowl-Breakfast.jpg';
import lunch from '../../../Assets/Healthy-chicken-burritos-lunch.jpg';
import dinner from '../../../Assets/Healthy-chicken-pad-Thai-dinner.jpg';


const NutritionCard = () => {
    return (
        <div className="card-group" style = {{marginRight: "20px"}}>
            {/* Card 1 */}
            <div className="card" >
                {/* Image */}
                <img className="card-img-top" src={smoothieBowlImage} alt="Smoothie Bowl" width="180" height="180" />

                {/* Card body */}
                <div className="card-body">
                    {/* Title */}
                    <h5 className="card-title">Smoothie Bowl</h5>

                    <p className="card-text">A delicious and nutritious breakfast.</p>
                    <a href="#" className="btn btn-primary" style = {{justifyContent:"center"}}>Read more</a>
                </div>
            </div>

            {/* Card 2 */}
            <div className="card" >
                {/* Image */}
                <img className="card-img-top" src={lunch} alt="chicken burritos" width="180" height="180" />

                {/* Card body */}
                <div className="card-body">
                    {/* Title */}
                    <h5 className="card-title">chicken burritos</h5>
                    <p className="card-text">A healthy chicken burritos for lunch.</p>
                    <a href="#" className="btn btn-primary">Read more</a>
                </div>
            </div>

            {/* Card 3 */}
            <div className="card">
                {/* Image */}
                <img className="card-img-top" src={dinner} alt="Avocado Toast" width="180" height="180" />

                {/* Card body */}
                <div className="card-body">
                    {/* Title */}
                    <h5 className="card-title">Healthy pad Thai</h5>

                    <p className="card-text">Healthy pad Thai for dinner</p>
                    <a href="#" className="btn btn-primary">Read more</a>
                </div>
            </div>
        </div>
    );
};

export default NutritionCard;
