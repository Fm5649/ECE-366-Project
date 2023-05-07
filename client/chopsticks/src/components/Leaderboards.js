import '../styles/Leaderboards.css';
import SideBar from './SideBar';
import styles from '../styles/HomeStyles'
import React, { useState } from 'react';
import { useRef, useEffect} from "react";
import { useNavigate } from 'react-router-dom';
import axios from "axios";
import { useParams } from 'react-router-dom';

function Leaderboards() {
    const [connected,setConnected] = useState(false);
    const [players, setPlayers] = useState([]);
   
    const [playerInfo, setPlayerInfo] = useState({
    playerId: null,
    playerName: null,
    playerElo: null
    }); 

    const navigate = useNavigate();
    const clientRef = useRef();
    const joinHandler = () => {
        console.log(clientRef.current);
        setConnected(true);
    }
    console.log('poo');
    console.log(players);

    const f = async () => {
        try {
            const res = await axios.get(`http://localhost:8080/getPlayers`);
            const players = res.data.map(player=> ({
                playerId: player.playerId,
                playerName: player.playerName,
                playerElo: player.playerElo
            }));
            console.log(players);
            setPlayers(players);
        } catch (error) {
            console.log(error);
        }
    } 

    useEffect(()=>{}, [players]);

    if (players.length === 0) {
        console.log('poo2');
        f();
        console.log(players);
    }

    const sortedPlayers = [...players].sort((a, b) => b.playerElo - a.playerElo);

    return (
        <div style={styles.wrapper}>
            <div style={styles.sideBarContainer}> 
                <SideBar></SideBar>
            </div>
            <div style={styles.centerContainer}>
                <div className="leaderboard">
                    <div className="leaderboard-header">
                    <div className="leaderboard-rank">#</div>
                    <div className="leaderboard-player">Player</div>
                    <div className="leaderboard-elo">Elo</div>
                    </div>
                {sortedPlayers.map((player, index) => (
                    <div className="leaderboard-row" key={player.playerId}>
                    <div className="leaderboard-rank">{index + 1}</div>
                    <div className="leaderboard-player" onClick={()=>navigate(`/settings/${player.playerId}`)}>{player.playerName}</div>
                    <div className="leaderboard-elo">{player.playerElo}</div>
                    </div>
                ))}
                </div>
        </div></div>
    );
}

export default Leaderboards;