import styles from '../styles/HomeStyles'
import SideBar from "./SideBar";
import { Button } from '@mui/material'
import {useState,useEffect} from "react";
import axios from "axios";
import { useNavigate } from 'react-router-dom';

function Settings() {
    const navigate = useNavigate();
    const [data,setData] = useState();
    const createHandler = async () => {
        const res = await axios.get(`http://localhost:8080/getPlayerById/${sessionStorage.getItem("id")}`);
        console.log(res);
        setData(res.data);
    }
    useEffect(()=>{createHandler();},[])
    return (
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
    );
}


export default Settings;