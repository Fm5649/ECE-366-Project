import '../styles/Leaderboards.css';
import SideBar from './SideBar';
import styles from '../styles/HomeStyles'
import React, { useState } from 'react';
import { useEffect} from "react";
import axios from "axios";
import { useNavigate } from 'react-router-dom';

function Leaderboards() {
    const [players, setPlayers] = useState([]);
    const navigate = useNavigate();

    // Asynchronous function to fetch all player data from database
    // Inserts this data into players array
    const f = async () => {
        try {
            const res = await axios.get(`${process.env.REACT_APP_BACKEND_URL}/getPlayers`);
            const players = res.data.map(player=> ({
                playerId: player.playerId,
                playerName: player.playerName,
                playerElo: player.playerElo
            }));
            setPlayers(players);
            console.log(players);
        } catch (error) {
            console.log(error);
        }
    }

    // Dependency array for useEffect is empty -> [], so only runs once when the
    // component is initially mounted. 
    useEffect(()=>{
        f();
    }, []);

    // Players are sorted in the leaderboard by their elo
    const sortedPlayers = [...players].sort((a, b) => b.playerElo - a.playerElo);

    // Displays three columns Rank # | Name | Elo
    // Sorted by elo
    // Placed on the screen into grid from sorted players array
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
                    {/*clicking on the names allows looking at the profile of other players*/}
                    <div className="leaderboard-player" onClick={()=>navigate(`/settings/${player.playerId}`)}>{player.playerName}</div>
                    <div className="leaderboard-elo">{player.playerElo}</div>
                    </div>
                ))}
                </div>
        </div></div>
    );
}

export default Leaderboards;