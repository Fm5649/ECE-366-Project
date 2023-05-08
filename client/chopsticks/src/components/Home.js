import styles from '../styles/HomeStyles'
import SideBar from "./SideBar";
import { Button } from '@mui/material'
import axios from "axios";
import { useNavigate } from 'react-router-dom';
import {useState,useEffect} from 'react';

function Home() {
    const navigate = useNavigate();
    const [games,setGames] = useState([]);
    // async function to create game when button start is pressed
    const createHandler = async () => {
        // inserts game into database
        // gameid is automatically created by sql code
        // p1 id is stored as player 1
        // p2 is null as waiting for 2nd player
        const res = await axios.post(`${process.env.REACT_APP_BACKEND_URL}/insertGame`,{p1:sessionStorage.getItem("id"),p2:null},{headers:
        {"Authorization":`Bearer ${sessionStorage.getItem("idToken")}`}});
        console.log(res);
        // navigate to new page dedicated to gameID
        navigate(`/game/${res.data.gameId}`)
    }
    //startup get call to get all ongoing games (including games without opponent)
    useEffect(()=>{
        const f = async () => {
            const res = await axios.get(`${process.env.REACT_APP_BACKEND_URL}/getOngoingGames/${sessionStorage.getItem("id")}`)
            console.log(res);
            const l = res.data.filter((o) => o.winner == 0)
            setGames(l);
        }
        f();
        },[])
    
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
                {games.length > 0 ? <h6>Ongoing Games</h6> : <></>} {/*list of all ongoing games*/}
                <div style={styles.buttonContainer}>
                    {games.map((o,i) => <Button variant="contained"
                    style={{...styles.startButton,marginBottom:'10px'}}
                    onClick={()=>navigate(`/game/${o.gameId}`)}>Join({o.playerTwoName ? o.playerTwoId == sessionStorage.getItem("id") ? o.playerOneName : o.playerTwoName : "Waiting"})</Button>)}
                </div>
            </div>
        </div>
    );
}

export default Home;