import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faChartBar, faDumbbell, faUser, faUtensils, faSignOutAlt } from '@fortawesome/free-solid-svg-icons'; // Import des icônes nécessaires
import "./index.css"
import {Link} from "react-router-dom";

const VerticalNavbar = () => {
    return (
        <nav className="navbar navbar-expand-lg navbar-light ">
            <ul className="navbar-nav d-flex flex-column">
                <li className="nav-item">
                    <a className="nav-link" href="/dashboard">
                        <FontAwesomeIcon icon={faChartBar} /> Dashboard
                    </a>
                </li>
                <li className="nav-item">
                    <a className="nav-link" href="/profile">
                        <FontAwesomeIcon icon={faUser} /> Profile
                    </a>
                </li>

                <li className="nav-item">
                    <a className="nav-link" href="/nutritionsList">
                        <FontAwesomeIcon icon={faUtensils} /> Nutrition
                    </a>
                </li>

                <li className="nav-item">
                    <a className="nav-link" href="/login">
                        <FontAwesomeIcon icon={faSignOutAlt} /> Log out
                    </a>
                </li>
            </ul>
        </nav>
    );
};

export default VerticalNavbar;
