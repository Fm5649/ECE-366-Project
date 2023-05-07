import styles from '../styles/HomeStyles'
import SideBar from "./SideBar";
import { Button } from '@mui/material'
import {useEffect,useState} from "react";
import axios from "axios";
import { useNavigate } from 'react-router-dom';


function GameList() {
    const [games,setGames] = useState([]);
    const navigate = useNavigate();


    // executes one time when taken to the gamelist page
    useEffect(() => {
        const a = sessionStorage.getItem("id");
        if (!a) return;
        const f = async() => {
            // obtains a list of the available games to display
            const res = await axios.get(`http://localhost:8080/getAvailableGames/${a}`);
            console.log(res)
            setGames(res.data);
        }
        f();
    },[])

    // UI to show the available games including the playerone name (the player that created the game)
    // as well as a join button next to it so that the user can choose which game to join
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
                    <div>{game.playerOneName}:</div>
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