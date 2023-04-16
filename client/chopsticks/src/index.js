import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter, Routes, Route } from "react-router-dom";

import './index.css';
import Landing from './components/Landing'
import Login from './components/Login'
import Register from './components/Register'
import Home from './components/Home'

const root = ReactDOM.createRoot(document.getElementById('root'));

/* The entry point of the application. */
root.render(
    <BrowserRouter>
        <Routes>
            <Route path="*" element={<Landing/>} />
            <Route path="/login" element={<Login/>} />
            <Route path="/register" element={<Register/>} />
            <Route path="/home" element={<Home/>}/>
        </Routes>
    </BrowserRouter>
);