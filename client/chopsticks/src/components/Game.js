import styles from '../styles/HomeStyles'
import SideBar from "./SideBar";
import { Button } from '@mui/material'
import { useParams } from 'react-router-dom';
import SockJsClient from "react-stomp";
import {useState, useRef, useEffect} from "react";

function Game() {
    const [connected,setConnected] = useState(false);
    const clientRef = useRef();
    const { id } = useParams();

    // used to obtain the current session users id
    const joinHandler = () => {
        console.log(clientRef.current);
        setConnected(true);
    }

    // when connected is changed (through joinHandler), effect is used
    useEffect(() => {
        if(!connected) return;
        // sends msg to websocket server with destination '/ws-api/join' and msg containing the gameID and userId
        clientRef.current.sendMessage('/ws-api/join',JSON.stringify({gameId:id, userId:sessionStorage.getItem("id")}));
    },[connected])
    
    // setup UI with start and join buttons
    return (
        // interface to communicate over web socket server
        // allows for real time data to be sent btwn server and client
        // without the need for http requests/responses
        <>
        <SockJsClient url={`${process.env.REACT_APP_BACKEND_URL}/ws-message`} topics={['/topics/join','/topics/insert']}
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