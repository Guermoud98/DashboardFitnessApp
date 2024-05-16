// App.js
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Login from './components/Login';
import Dashboard from './components/Dashboard';
import NutritionList from "./components/Nutritions/NutritionMenu";
import NutritionMenu from "./components/Nutritions/NutritionMenu";
import NutritionDashboard from "./components/Nutritions/NutritionDashboard";
import SignUp from "./components/SignUp";
import UserProfile from "./components/UserProfile";


const App = () => {
    return (
        <Router>
            <Routes>
                <Route path="/login" element={<Login />} />
                <Route path="/signup" element={<SignUp />} />
                <Route path="/dashboard" element={<Dashboard />} />
                <Route path="/nutritionsList" element={<NutritionMenu />} />
                <Route path="/profile" element={<UserProfile />} />

            </Routes>
        </Router>
    );
};

export default App;
