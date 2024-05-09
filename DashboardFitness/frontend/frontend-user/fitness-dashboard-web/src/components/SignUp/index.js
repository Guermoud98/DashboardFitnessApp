import React, { useState } from 'react';
import axios from 'axios';
import './index.css';
import { Link } from 'react-router-dom';



const SignUp = () => {
  
  const [formData, setFormData] = useState({
    nom: '',
    prenom: '',
    email: '',
    password: '',
    poids: 0,
    taille: 0
  });
  const [isLoading, setIsLoading] = useState(false);
  const [inscriptionReussie, setInscriptionReussie] = useState(null);
  const [champsVides, setChampsVides] = useState(false);
  
  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setIsLoading(true);
    

    // Vérifier les champs vides
    if (Object.values(formData).some((value) => value === '')) {
      setChampsVides(true);
      setIsLoading(false);
      return;
    }

    try {
      const response = await axios.post('http://localhost:8085/api/Utilisateurs/create', formData);
      console.log('Response from backend:', response.data);
      setFormData({
        nom: '',
        prenom: '',
        email: '',
        password: '',
        poids: 0,
        taille: 0
      });
      setInscriptionReussie(true);
    } catch (error) {
      console.error('Error during sign up:', error.response.data.message);
      setInscriptionReussie(false);
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <div className="container">
      <div className="signup-container">
      <h2>Welcome to fitness App! Veuillez vous inscrire d'abord</h2>
        <form onSubmit={handleSubmit}>
          <input type="text" name="nom" placeholder="Nom" value={formData.nom} onChange={handleChange} />
          <input type="text" name="prenom" placeholder="Prénom" value={formData.prenom} onChange={handleChange} />
          <input type="email" name="email" placeholder="Adresse e-mail" value={formData.email} onChange={handleChange} />
          <input type="password" name="password" placeholder="Mot de passe" value={formData.password} onChange={handleChange} />
          <input type="number" name="poids" placeholder="Poids (en kg)" value={formData.poids} onChange={handleChange} />
          <input type="number" name="taille" placeholder="Taille (en m)" value={formData.taille} onChange={handleChange} />
          <button type="submit" disabled={isLoading || inscriptionReussie} className={`submit-button ${isLoading ? 'loading' : ''}`}>
            {inscriptionReussie ? 'Inscription réussie' : 'S\'inscrire'}
          </button>
          <Link to="/login" className="login-link">
          <button type="button">Login</button>
          </Link>
        </form>
        {champsVides && (
          <p>Remplissez tous les champs</p>
        )}
        {inscriptionReussie && (
          <p>Inscription réussie !</p>
        )}
        {isLoading && (
          <p>Chargement en cours...</p>
        )}
        {!isLoading && inscriptionReussie === false && (
          <p>Erreur lors de l'inscription</p>
        )}
      </div>
    </div>
  );
};

export default SignUp;