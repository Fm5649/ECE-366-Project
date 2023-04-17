//Figure out how to nicely list all entires

import React, { useState } from 'react';
import { useParams } from 'react-router-dom';
import SockJsClient from "react-stomp";
import { useNavigate } from 'react-router-dom';
import { useRef, useEffect} from "react";
import axios from "axios";

import { useNavigate } from 'react-router-dom';
import { auth } from '..';
import { database } from '..';
import axios from "axios";

function Leaderboard() {
  const data =[{"name":"test1"},{"name":"test2"}];
  const listItems = data.map((d) => <li key={d.name}>{d.name}</li>);

  const [leaderboardinfo, setLeaderboardinfo] = useState({
    rank:null,
    playerName:null,
    totalGames:null,
    totalWins:null,
    totalLosses:null,
    ELO:null
  });

  const res = await axios.get(`http://localhost:8080/getLeaderboardById/${id}`);
  const {rank, 
         playerName,
    totalGames,
    totalWins,
    totalLosses,
    ELO} = res.data;
  leaderboardinfo.rank = rank;
  leaderboardinfo.playerName = playerName;
leaderboardinfo.totalGames = totalGames;
leaderboardinfo.totalWins = totalWins;
leaderboardinfo.totalLosses = totalLosses;
leaderboardinfo.ELO = ELO;
  setLeaderboardInfo({...leaderboardinfo});
  console.log(leaderboardinfo)
  
  return (
      <div>
  
      </div>
    );
}
export default Leaderboard;
