import React, { useState } from 'react';
import './App.css';
import VerticalNavbar from './components/Navbar';
import Header from './components/Header';
import Calendar from './components/Calendar';
import WorkoutRecommended from './components/WorkoutRecommended';
import WeightCard from "./components/Weight";
import HeightCard from "./components/Height";
import Body from "./components/Body";
import NutritionCard from "./components/Nutritions";
import Dashboard from "./components/Dashboard";


function App() {
    return (
        <Dashboard/>
    );
}

export default App;
