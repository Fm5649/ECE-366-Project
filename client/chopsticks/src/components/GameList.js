import styles from '../styles/HomeStyles'
import SideBar from "./SideBar";
import { Button } from '@mui/material'
import {useEffect,useState} from "react";
import axios from "axios";
import { useNavigate } from 'react-router-dom';


function GameList() {
    const [games,setGames] = useState([]);
    const navigate = useNavigate();
    useEffect(() => {
        const a = sessionStorage.getItem("id");
        if (!a) return;
        const f = async() => {
        const res = await axios.get(`http://localhost:8080/getAvailableGames/${a}`);
        console.log(res)
        setGames(res.data);
        }
        f();
    },[])

    return (
        <div style={styles.wrapper}>
            <div style={styles.sideBarContainer}> 
                <SideBar></SideBar>
            </div>
            <div style={styles.centerContainer}>
                <div style={styles.startMsg}>
                    Available games to join
                </div>
                { games.map((game,i) => 
                <div style={styles.buttonContainer} key={i}>
                    <Button variant="contained" style={styles.joinButton} onClick={() => navigate(`/game/${game.gameId}`)}>
                        Join
                    </Button>
                </div>)
                }
            </div>
        </div>
    );
}

export default GameList;