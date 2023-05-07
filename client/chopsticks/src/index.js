import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter, Routes, Route } from "react-router-dom";

import './index.css';
import { initializeApp } from "firebase/app";
import { getAuth } from "firebase/auth";
import { getAnalytics } from "firebase/analytics";
import reportWebVitals from './tests/reportWebVitals';

import Landing from './components/Landing'
import Login from './components/Login'
import Register from './components/Register'
import Home from './components/Home'
import Game from './components/GameUI'
import GameList from './components/GameList'
import Settings from './components/Settings'
import Leaderboards from './components/Leaderboards'

const root = ReactDOM.createRoot(document.getElementById('root'));

/* The entry point of the application. */
// set up of all paths
root.render(
    <BrowserRouter>
        <Routes>
            <Route path="*" element={<Landing/>} />
            <Route path="/login" element={<Login/>} />
            <Route path="/register" element={<Register/>} />
            <Route path="/home" element={<Home/>}/>
            <Route path="/game/:id" element={<Game/>}/>
            <Route path="/gamelist" element={<GameList/>}/>
            <Route path="/leaderboards" element={<Leaderboards/>}/>
            <Route path="/settings" element={<Settings/>}/>
        </Routes>
    </BrowserRouter>
);

// Import the functions you need from the SDKs you need

// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
/**const firebaseConfig = {
    apiKey: "AIzaSyDTIO7R9ies2-Kx3cihkgb1Dli80tCbN84",
    authDomain: "chopsticks-137ff.firebaseapp.com",
    databaseURL: "https://chopsticks-137ff-default-rtdb.firebaseio.com",
    projectId: "chopsticks-137ff",
    storageBucket: "chopsticks-137ff.appspot.com",
    messagingSenderId: "185246451443",
    appId: "1:185246451443:web:78714feeeb3acced521986",
    measurementId: "G-YRHW81P15K"
  };**/

  // Import the functions you need from the SDKs you need
//import { initializeApp } from "firebase/app";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
const firebaseConfig = {
  apiKey: "AIzaSyC6UMjWn6gviVd-pM04cNb54PuTGk4esNg",
  authDomain: "ece366-99550.firebaseapp.com",
  projectId: "ece366-99550",
  storageBucket: "ece366-99550.appspot.com",
  messagingSenderId: "565061901157",
  appId: "1:565061901157:web:7172f3673fd1f56507df8c"
};

// Initialize Firebase

const app = initializeApp(firebaseConfig);
const auth = getAuth(app);

export {app};
export {auth};
