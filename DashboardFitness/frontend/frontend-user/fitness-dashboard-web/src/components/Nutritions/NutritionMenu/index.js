import React, { useState, useEffect } from 'react';
import axios from 'axios'; // Importez Axios
import VerticalNavbar from "../../Navbar";

const images = [
    require('../../../Assets/HealthyMeals/cropped-miguel-b9e922f.jpg'),
    require('../../../Assets/HealthyMeals/Healthy-tuna-pasta-67b6fbb.jpg'),
    require('../../../Assets/HealthyMeals/Curried-Kale-Chickpea-Soup-8575285.jpg'),
    require('../../../Assets/HealthyMeals/Carrot-Pilaf-With-Coriander-Chutney-8b7acf4.jpg'),
    require('../../../Assets/HealthyMeals/Moroccan-Burgers-db3889d.jpg'),
    require('../../../Assets/HealthyMeals/Roasted-teriyaki-veg-bowl-7d9916a (1).jpg'),
    require('../../../Assets/HealthyMeals/Sausage-and-lentil-cassoulet-e3f0997.jpg'),
    require('../../../Assets/HealthyMeals/Scotch-broth-899f7bb.jpg'),
    require('../../../Assets/HealthyMeals/Smoothie-bowl-Breakfast.jpg'),
];
const NutritionList = () => {
    const [nutritionData, setNutritionData] = useState([]);

    useEffect(() => {
        fetchNutritionData(); // Appeler la fonction pour récupérer les données des nutriments depuis l'API
    }, []);

    const fetchNutritionData = async () => {
        try {
            const response = await axios.get('http://localhost:8085/api/Utilisateurs/nutritions/afficherTous'); // Utilisez Axios pour envoyer une requête GET
            const data = response.data; // Récupérez les données de la réponse
            console.log(data);
            // Mettre à jour l'état local avec les données récupérées
            setNutritionData(data);
        } catch (error) {
            console.error('Erreur lors de la récupération des données de nutrition : ', error);
        }
    };


    return (
        <div className='d-flex'>
            <div className="navbar-container">
                <VerticalNavbar/>
            </div>
            <div className="card-group" style={{ justifyContent: "center", marginTop: "50px", padding:"20px", display: "flex", flexWrap: "wrap"}}>
                {/* Affichage des données de nutrition récupérées */}
                {nutritionData.map((nutrition, index) => (
                    <div key={index} style={{marginRight: '10px', marginBottom: '10px'}}>
                        <div className="card" style={{
                            height: "170px",
                            padding: "8px",
                            display: "flex",
                            flexDirection: "column",
                            justifyContent: "center",
                            alignItems: "center"
                        }}>
                            <img className="card-img-top" src={images[index]} alt={nutrition.nomNutrition}
                                 style={{width: "100px", height: "100px", objectFit: "cover"}}/>
                            <span className="card-title">{nutrition.nomNutrition}</span>
                            <button className="btn btn-primary" style={{marginTop: "1px"}}>Read</button>
                        </div>
                    </div>
                ))}
            </div>
            {/* Right sidebar */}
            <div style={{width: '50px', backgroundColor: "#4d2158"}}>
            </div>
        </div>
    );

};

export default NutritionList;
