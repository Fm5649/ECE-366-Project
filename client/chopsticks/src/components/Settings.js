import styles from '../styles/HomeStyles'
import SideBar from "./SideBar";
import {useState,useEffect} from "react";
import axios from "axios";
import { useNavigate, useParams } from 'react-router-dom';
import Button from '@mui/material/Button';

function Settings() {
    const [data,setData] = useState();
    const [games,setGames] = useState([]);
    const navigate = useNavigate();
    //url can be /settings or /settings/(numeric id)
    let {id} = useParams();

    // async function to get player data given current session id or id on url variable (when looking at other players)
    // after fetching player data, then fetches finished game history
    const createHandler = async () => {
        //if url = /settings then use my own session id
        if (!id) id = sessionStorage.getItem("id");
        const res = await axios.get(`http://localhost:8080/getPlayerById/${id}`,{headers:
        {"Authorization":`Bearer ${sessionStorage.getItem("idToken")}`}});
        console.log(res);
        setData(res.data);
        const res2 = await axios.get(`http://localhost:8080/getFinishedGames/${id}`);
        setGames(res2.data);
    }

    // Dependency array for useEffect is empty -> [], so only runs once when the
    // component is initially mounted. 
    useEffect(()=>{createHandler();},[])

    // Display sidebar for navigation. Main screen shows name, email, elo, totalgames/wins/losses
    return (<>
        <div style={styles.wrapper}>
            <div style={styles.sideBarContainer}> 
                <SideBar></SideBar>
            </div>
            <div style={styles.centerContainer}>
                <h2>{data?.playerName}</h2>
                <h3>{data?.playerEmail}</h3>
                <h2>Elo: {data?.playerElo}</h2>
                <h3>Total games played: {data?.totalGames}</h3>
                <h3>Total games won: {data?.totalWins}</h3>
                <h3>Total games lost: {data?.totalLosses}</h3>
            </div>
        </div>
        <div>
            <div style={styles.centerContainer}>
                <h2>History</h2>
                {games.map((o,i) => 
                <div key={i} style={{display:'flex',flexDirection:'row'}}>
                        <div style={{padding:'10px'}}>{o.playerOneName} vs {o.playerTwoName}</div>
                    <Button variant="contained" style={styles.joinButton} onClick={()=>{navigate(`/game/${o.gameId}`)}}>
                    View
                </Button>
                <div style={{padding:'10px'}}>{parseInt(id) == data?.winner ? 'LOSS' : 'WIN'}</div>
                </div>
                )}
            </div>
        </div></>
    );
}


export default Settings;