import React from 'react';
import smoothieBowlImage from '../../../Assets/Smoothie-bowl-Breakfast.jpg';
import lunch from '../../../Assets/Healthy-chicken-burritos-lunch.jpg';
import dinner from '../../../Assets/Healthy-chicken-pad-Thai-dinner.jpg';
import VerticalNavbar from "../../Navbar";

const NutritionList = () => {
    return (
        <div className='d-flex'>
            <div className="navbar-container">
                <VerticalNavbar/>
            </div>
            <div className="card-group" style={{display: 'flex', flexWrap: 'wrap', justifyContent: "space-around", marginTop: "50px"}}>
                {/* First set of four cards */}
                <div style={{ display: 'flex', flexWrap: 'wrap' }}>
                    <div className="card" style={{height: "170px", marginRight: '10px'}}>
                        <img className="card-img-top" src={smoothieBowlImage} alt="Smoothie Bowl" style={{width: "150px", height: "150px"}}/>
                        <h5 className="card-title">Smoothie Bowl</h5>
                    </div>
                    <div className="card" style={{height: "170px", marginRight: '10px'}}>
                        <img className="card-img-top" src={lunch} alt="Lunch" style={{width: "150px", height: "150px"}}/>
                        <h5 className="card-title">Lunch</h5>
                    </div>
                    <div className="card" style={{height: "170px", marginRight: '10px'}}>
                        <img className="card-img-top" src={dinner} alt="Dinner" style={{width: "150px", height: "150px"}}/>
                        <h5 className="card-title">Dinner</h5>
                    </div>
                    <div className="card" style={{height: "170px", marginRight: '10px'}}>
                        <img className="card-img-top" src={smoothieBowlImage} alt="Smoothie Bowl" style={{width: "150px", height: "150px"}}/>
                        <h5 className="card-title">Smoothie Bowl</h5>
                    </div>
                </div>


                {/* Second set of four cards */}
                <div style={{ display: 'flex', flexWrap: 'wrap' }}>
                    <div className="card" style={{height: "170px", marginRight: '10px'}}>
                        <img className="card-img-top" src={smoothieBowlImage} alt="Smoothie Bowl" style={{width: "150px", height: "150px"}}/>
                        <h5 className="card-title">Smoothie Bowl</h5>
                    </div>
                    <div className="card" style={{height: "170px", marginRight: '10px'}}>
                        <img className="card-img-top" src={lunch} alt="Lunch" style={{width: "150px", height: "150px"}}/>
                        <h5 className="card-title">Lunch</h5>
                    </div>
                    <div className="card" style={{height: "170px", marginRight: '10px'}}>
                        <img className="card-img-top" src={dinner} alt="Dinner" style={{width: "150px", height: "150px"}}/>
                        <h5 className="card-title">Dinner</h5>
                    </div>
                    <div className="card" style={{height: "170px", marginRight: '10px'}}>
                        <img className="card-img-top" src={smoothieBowlImage} alt="Smoothie Bowl" style={{width: "150px", height: "150px"}}/>
                        <h5 className="card-title">Smoothie Bowl</h5>
                    </div>
                </div>
            </div>
            {/* Add the right sidebar here */}
            <div style={{width: '100px', backgroundColor: "#4d2158"}}>
                {/* Content for the right sidebar */}
                <i className="fas fa-futbol" style={{fontSize: '24px', color: 'white'}}></i>
            </div>
        </div>
    );
};

export default NutritionList;
