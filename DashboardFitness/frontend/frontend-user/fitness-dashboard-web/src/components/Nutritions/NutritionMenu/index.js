import React, { useState, useEffect } from 'react';
import axios from 'axios'; // Importez Axios
import VerticalNavbar from "../../Navbar";

const NutritionList = () => {
    const [nutritionData, setNutritionData] = useState([]);

    useEffect(() => {
        fetchNutritionData(); // Appeler la fonction pour récupérer les données des nutriments depuis l'API
    }, []);

    const fetchNutritionData = async () => {
        try {
            const response = await axios.get('/nutritions/afficherTous'); // Utilisez Axios pour envoyer une requête GET
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
            <div className="card-group" style={{display: 'flex', flexWrap: 'wrap', justifyContent: "space-around", marginTop: "50px"}}>
                {/* Affichage des données de nutrition récupérées */}
                {nutritionData.map((nutrition, index) => (
                    <div key={index} style={{ display: 'flex', flexWrap: 'wrap' }}>
                        <div className="card" style={{height: "170px", marginRight: '10px'}}>
                            <img className="card-img-top" src={nutrition.image} alt={nutrition.title} style={{width: "150px", height: "150px"}}/>
                            <h5 className="card-title">{nutrition.title}</h5>
                        </div>
                    </div>
                ))}
                {/* Répétez les 4 divs précédentes pour afficher 8 divs au total */}
                {nutritionData.map((nutrition, index) => (
                    <div key={index + 100} style={{ display: 'flex', flexWrap: 'wrap' }}>
                        <div className="card" style={{height: "170px", marginRight: '10px'}}>
                            <img className="card-img-top" src={nutrition.image} alt={nutrition.title} style={{width: "150px", height: "150px"}}/>
                            <h5 className="card-title">{nutrition.title}</h5>
                        </div>
                    </div>
                ))}
            </div>
            {/* Right sidebar */}
            <div style={{width: '100px', backgroundColor: "#4d2158"}}>
                {/* Content for the right sidebar */}
                <i className="fas fa-futbol" style={{fontSize: '24px', color: 'white'}}></i>
            </div>
        </div>
    );
};

export default NutritionList;
