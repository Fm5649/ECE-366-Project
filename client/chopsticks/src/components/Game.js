import styles from '../styles/HomeStyles'
import SideBar from "./SideBar";
import { Button } from '@mui/material'
import { useParams } from 'react-router-dom';
import SockJsClient from "react-stomp";
import { useNavigate } from 'react-router-dom';
import {useState, useRef, useEffect} from "react";

function Game() {
    const [connected,setConnected] = useState(false);
    const clientRef = useRef();
    const { id } = useParams();
    const joinHandler = () => {
        console.log(clientRef.current);
        setConnected(true);
    }
    useEffect(() => {
        if(!connected) return;
        clientRef.current.sendMessage('/ws-api/join',JSON.stringify({gameId:id, userId:sessionStorage.getItem("id")}));
    },[connected])
    return (
        <>
        <SockJsClient url='http://localhost:8080/ws-message' topics={['/topics/join','/topics/insert']}
            onMessage={(msg) => { console.log(msg); }}
            ref={ (client) => { clientRef.current = client; }}
            onConnect={joinHandler}
             />
        <div style={styles.wrapper}>
            <div style={styles.sideBarContainer}> 
                <SideBar></SideBar>
            </div>
            <div style={styles.centerContainer}>
                <div style={styles.startMsg}>
                    Game
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
        </>
    );
}

export default Game;