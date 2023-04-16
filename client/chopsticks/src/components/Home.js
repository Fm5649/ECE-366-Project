import styles from '../styles/HomeStyles'
import SideBar from "./SideBar";
import { Button } from '@mui/material'

function Home() {
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
                    <Button variant="contained" style={styles.startButton}>
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