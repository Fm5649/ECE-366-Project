import React, { useState } from 'react';
import { useParams } from 'react-router-dom';
import SockJsClient from "react-stomp";
import { useNavigate } from 'react-router-dom';
import { useRef, useEffect} from "react";
import axios from "axios";

import { auth } from '..';
import { database } from '..';

function ProfileAndSettings() {
    const [playerInfo, setPlayerInfo] = useState({
    username:null,
    totalGames:null,
    totalWins:null,
    totalLosses:null,
    ELO: null
    }); 
    
    const navigate = useNavigate();

    useEffect(() => {
        const f = async () => {
            const res = await axios.get(`http://localhost:8080/getPlayerById/${sessionStorage.getItem("id")}`);
            const {username, totalGames, totalWins, totalLosses, ELO} = res.data;
            playerInfo.username = username;
            playerInfo.totalGames = totalGames;
            playerInfo.totalWins = totalWins;
            playerInfo.totalLosses = totalLosses;
            playerInfo.ELO = ELO;
            setPlayerInfo({...playerInfo});
            console.log(playerInfo)
        }
        f();
    },[])
    
    console.log(playerInfo);

    return (
        <div className ="ProfileAndSettings">
        <h1>{playerInfo.username}</h1>
        <span>Matches Played: {playerInfo.totalGames}  </span>
        <span>Total Wins: {playerInfo.totalWins}  </span>
        <span>Total Losses: {playerInfo.totalLosses}  </span>
        <span>ELO: {playerInfo.ELO}  </span>
        </div>  
    );
}

export default ProfileAndSettings;
