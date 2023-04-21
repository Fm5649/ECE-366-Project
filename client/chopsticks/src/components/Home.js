import styles from '../styles/HomeStyles'
import SideBar from "./SideBar";
import { Button } from '@mui/material'
import axios from "axios";
import { useNavigate } from 'react-router-dom';

function Home() {
    const navigate = useNavigate();
    // async function to create game when button start is pressed
    const createHandler = async () => {
        // inserts game into database
        // gameid is automatically created by sql code
        // p1 id is stored as player 1
        // p2 is null as waiting for 2nd player
        const res = await axios.post("http://localhost:8080/insertGame",{p1:sessionStorage.getItem("id"),p2:null});
        console.log(res);
        // navigate to new page dedicated to gameID
        navigate(`/game/${res.data.gameId}`)
    }
    
    // displays message and start/join buttons to start/join a game
    return (
        <div style={styles.wrapper}>
            <div style={styles.sideBarContainer}> 
                <SideBar></SideBar>
            </div>
            <div style={styles.centerContainer}>
                <div style={styles.startMsg}>
                    Start or Join a Chopsticks Match!
                </div>
                <div style={styles.buttonContainer}>
                    <Button variant="contained" style={styles.startButton} onClick={createHandler}>
                        Start
                    </Button>
                    <Button variant="contained" style={styles.joinButton} onClick={()=>{navigate('/gamelist')}}>
                        Join
                    </Button>
                </div>
            </div>
        </div>
    );
}

export default Home;