import styles from '../styles/HomeStyles'
import SideBar from "./SideBar";
import { Button } from '@mui/material'
import axios from "axios";
import { useNavigate } from 'react-router-dom';
import {useState,useEffect} from 'react';

function Home() {
    const navigate = useNavigate();
    const [games,setGames] = useState([]);
    const createHandler = async () => {
        const res = await axios.post("http://localhost:8080/insertGame",{p1:sessionStorage.getItem("id"),p2:null},
        {headers:
    {"Authorization":`Bearer ${sessionStorage.getItem("idToken")}`}});
        console.log(res);
        navigate(`/game/${res.data.gameId}`)
    }
    useEffect(()=>{
        const f = async () => {
            const res = await axios.get(`http://localhost:8080/getOngoingGames/${sessionStorage.getItem("id")}`)
            console.log(res);
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
                <h6>Ongoing Games</h6>
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