import React, { useState } from 'react';
import axios from 'axios';
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEnvelope, faLock, faUser } from '@fortawesome/free-solid-svg-icons';
import './index.css';
import {Link} from "react-router-dom";
//npm install @fortawesome/fontawesome-svg-core @fortawesome/free-solid-svg-icons @fortawesome/react-fontawesome

const Login = () => {
  const [formData, setFormData] = useState({
    email: '',
    password: ''
  });
  const [isLoading, setIsLoading] = useState(false);
  const [loginReussi, setLoginReussi] = useState(null);
  const [champsVides, setChampsVides] = useState(false);

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setIsLoading(true);

    // Vérifier les champs vides
    if (formData.email === '' || formData.password === '') {
      setChampsVides(true);
      setIsLoading(false);
      return;
    }

    try {
      const response = await axios.post('http://localhost:8085/api/Utilisateurs/login', null, {
        params: {
          email: formData.email,
          password: formData.password
        }
      });

      console.log('Response from backend:', response.data);

      if (response.status === 200) {
        toast.success('Connexion réussie !');
        setFormData({
          email: '',
          password: ''
        });
        setLoginReussi(true);
      } else {
        toast.error('Erreur lors de la connexion');
        setLoginReussi(false);
      }
    } catch (error) {
      console.error('Error during login:', error);
      toast.error('Erreur lors de la connexion');
      setLoginReussi(false);
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <div className="container">
      <div className="login-container">
        <h2>Connexion</h2>
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <FontAwesomeIcon icon={faUser} size="lg" />
            <input type="email" name="email" placeholder="Adresse e-mail" value={formData.email} onChange={handleChange} className="form-input" />
          </div>
          <div className="form-group">
            <FontAwesomeIcon icon={faLock} size="lg" />
            <input type="password" name="password" placeholder="Mot de passe" value={formData.password} onChange={handleChange} className="form-input" />
          </div>
          <Link to="/dashboard" className="dashboard-name">
          <button type="submit" disabled={isLoading || loginReussi} className={`submit-button ${isLoading ? 'loading' : ''}`}>
            {loginReussi ? 'Connexion réussie' : 'Se connecter'}
          </button>
          </Link>
        </form>


        {champsVides && <p>Veuillez remplir tous les champs</p>}
        {loginReussi && <p>Connexion réussie !</p>}
        {isLoading && <p>Chargement en cours...</p>}
        {!isLoading && loginReussi === false && <p>Erreur lors de la connexion</p>}
      </div>
    </div>
  );
};

export default Login;
