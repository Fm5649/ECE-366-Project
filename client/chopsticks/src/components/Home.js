import styles from '../styles/HomeStyles'
import SideBar from "./SideBar";
import { Button } from '@mui/material'
import axios from "axios";
import { useNavigate } from 'react-router-dom';

function Home() {
    const navigate = useNavigate();
    const createHandler = async () => {
        const res = await axios.post("http://localhost:8080/insertGame",{p1:sessionStorage.getItem("id"),p2:null});
        console.log(res);
        navigate(`/game/${res.data.gameId}`)
    }
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
                    <Button variant="contained" style={styles.joinButton}>
                        Join
                    </Button>
                </div>
            </div>
        </div>
    );
}

export default Home;