import React, { useState } from 'react';
import { useParams } from 'react-router-dom';
import SockJsClient from "react-stomp";
import { useNavigate } from 'react-router-dom';
import { useRef, useEffect} from "react";
import axios from "axios";

import { auth } from '..';
import { database } from '..';

function GameUI() {
  const [action, setAction] = useState("");
  const [transferAmount, setAmount] = useState(0);
  const [isMyTurn, setIsMyTurn] = useState(false);
  const [waiting, setWaiting] = useState(true);
  const [playerLeft, setPlayerLeft] = useState(1);
  const [playerRight, setPlayerRight] = useState(1);
  const [enemyLeft, setEnemyLeft] = useState(1);
  const [enemyRight, setEnemyRight] = useState(1);
  const [connected,setConnected] = useState(false);
  const [finished, setFinished] = useState(false);
  const [gameinfo, setGameinfo] = useState({
    playerOneId:null,
    playerTwoId:null,
    gameId:null,
    roundNumber:null,
    winner:null
  });
  useEffect(() => {
    if (playerLeft == 0 && playerRight == 0) {
    alert('you lost!');
    clientRef.current.disconnect();
  }}, [playerLeft,playerRight])
  useEffect(() => {
    if (enemyLeft == 0 && enemyRight == 0) {
    alert('you won!');
    clientRef.current.disconnect();
  }}, [enemyLeft,enemyRight])
  useEffect(() => {
    if (gameinfo.winner !== null) {
    setFinished(true)
  }}, [gameinfo])
  const navigate = useNavigate();
    const clientRef = useRef();
    const { id } = useParams();
    const joinHandler = () => {
        console.log(clientRef.current);
        setConnected(true);
    }
    useEffect(() => {
        if(!connected) return;
        const f = async () => {
          const res = await axios.get(`http://localhost:8080/getGameById/${id}`);
          const {playerOneId, playerTwoId, gameId, winnerId} = res.data;
          gameinfo.playerOneId = playerOneId;
          gameinfo.playerTwoId=playerTwoId;
          gameinfo.gameId = gameId;
          gameinfo.winnerId = winnerId;
          setGameinfo({...gameinfo});
          console.log(gameinfo)
          const myid = parseInt(sessionStorage.getItem("id"));
          if (gameId == id && myid != playerOneId && playerTwoId == 0) {
            clientRef.current.sendMessage('/ws-api/join',JSON.stringify({gameId:id, userId:sessionStorage.getItem("id")}));
          } else if (gameId == id && (myid == playerOneId && playerTwoId != 0) || myid == playerTwoId) {
            const res = await axios.get(`http://localhost:8080/getGameRoundById/${id}`);
            console.log(res);
            setWaiting(false);
            handleMessage(res.data);

          } else if (gameId == id && myid == playerOneId && playerTwoId == 0)
          {}else {
            alert('illegal game link');
            navigate('/home');
          }
        }
        f();
    },[connected])
    
    const handleMessage = async (msg) => {
      const {roundNumber} = msg;
      console.log(msg,roundNumber);
      if (roundNumber !== undefined && msg.gameId != 0) {
        const myid = parseInt(sessionStorage.getItem("id"));
        console.log(waiting,isMyTurn,gameinfo,gameinfo.playerOneId)
        if (roundNumber % 2 == 0 && myid == gameinfo.playerOneId) {
          setWaiting(false);
        } else if (roundNumber % 2 == 1 && myid == gameinfo.playerTwoId) {
          setWaiting(false);
        } else {
          setWaiting(true);
        }
        if (myid == gameinfo.playerTwoId) {
          setPlayerLeft(msg.p2Hand1);
          setPlayerRight(msg.p2Hand2);
          setEnemyLeft(msg.p1Hand1);
          setEnemyRight(msg.p1Hand2);
        } else if (myid == gameinfo.playerOneId) {
          setPlayerLeft(msg.p1Hand1);
          setPlayerRight(msg.p1Hand2);
          setEnemyLeft(msg.p2Hand1);
          setEnemyRight(msg.p2Hand2);
        }
        gameinfo.roundNumber = roundNumber;
        setGameinfo({...gameinfo});
      } else {
        const {playerOneId} = msg;
        gameinfo.playerTwoId=msg.playerTwoId;
        setGameinfo({...gameinfo});
        if (playerOneId == parseInt(sessionStorage.getItem("id"))) {
          const roundInit = {
            gameId: msg.gameId,
            roundNumber:0,
            playerTurn:sessionStorage.getItem("username"),
            playerChoice:"initial",
            playerHandUsed:"",
            playerTarget:""+msg.playerTwoId,
            playerActionAmount:0,
            p1Hand1:1,
            p1Hand2:1,
            p2Hand1:1,
            p2Hand2:1
          };
          console.log(roundInit);
          clientRef.current.sendMessage('/ws-api/insert',JSON.stringify(roundInit));
        }

      }
    }
    
  const onChoice = (choice) => {
    let el = enemyLeft;
    let er = enemyRight;
    let pl = playerLeft;
    let pr = playerRight;
    if (action === "Attack Left"){
      if(transferAmount != playerLeft && transferAmount != playerRight) {
        alert('invalid number of fingers to attack.');
        return;
      }
      if(enemyLeft + transferAmount === 5){
        setEnemyLeft(0);
        el=0;
      } else if(enemyLeft + transferAmount > 5){
        setEnemyLeft(enemyLeft + transferAmount - 5);
        el=el+transferAmount-5;
      }
      else
      {
        setEnemyLeft(enemyLeft + transferAmount);
        el += transferAmount;
      }
    }else if (action === "Attack Right"){
      if(transferAmount != playerLeft && transferAmount != playerRight) {
        alert('invalid number of fingers to attack.');
        return;
      }
      if(enemyRight + transferAmount === 5){
        setEnemyRight(0);
        er=0;
      }else if(enemyRight + transferAmount > 5){
        setEnemyRight(enemyRight + transferAmount - 5);
        er += transferAmount - 5;
      }
      else
      {
        setEnemyRight(enemyRight + transferAmount);
        er += transferAmount;
      }
    }else if (action === "Transfer to Left"){
      if(transferAmount >= playerRight) {
        alert('invalid number of fingers to transfer.');
        return;
      }
      setPlayerLeft(playerLeft + transferAmount);
      setPlayerRight(playerRight - transferAmount);
      pl += transferAmount;
      pr -= transferAmount;
    }else if (action === "Transfer to Right"){
      if(transferAmount >= playerLeft) {
        alert('invalid number of fingers to transfer.');
        return;
      }
      setPlayerRight(playerRight + transferAmount);
      setPlayerLeft(playerLeft - transferAmount);
      pr += transferAmount;
      pl -= transferAmount;
    }
    console.log(pl,pr,el,er)
    const myid = parseInt(sessionStorage.getItem("id"));
    console.log(gameinfo.gameId);
    console.log(gameinfo);
    const roundInit = {
      gameId: gameinfo.gameId,
      roundNumber: gameinfo.roundNumber+1,
      turnPlayerName:sessionStorage.getItem("username"),
      playerChoice:"",
      playerHandUsed:"",
      playerTarget:""+ gameinfo.roundNumber % 2 == 0 ? gameinfo.playerTwoId : gameinfo.playerOneId,
      amount:transferAmount,
      p1Hand1:myid == gameinfo.playerOneId ? pl : el,
      p1Hand2:myid == gameinfo.playerOneId ? pr : er,
      p2Hand1:myid != gameinfo.playerOneId ? pl : el,
      p2Hand2:myid != gameinfo.playerOneId ? pr : er,
    };
    console.log(roundInit);
    clientRef.current.sendMessage('/ws-api/insert',JSON.stringify(roundInit));
}
  

  return (
    <><SockJsClient url='http://localhost:8080/ws-message' topics={['/topics/join','/topics/insert']}
    onMessage={(msg) => { console.log(msg); handleMessage(msg);}}
    ref={ (client) => { clientRef.current = client; }}
    onConnect={joinHandler}
     />
    <div className="GameUI">
      <h1>Enemy Hands</h1>
      <span>Left Hand: {enemyLeft} Right Hand: {enemyRight}</span>
      <h1>Your Hands</h1>
      <span>Left Hand: {playerLeft} Right Hand: {playerRight}</span>
      {!waiting && !finished ? <>
      <h1>Current action is {action}</h1>
      <button onClick={() => setAction("Attack Left")}>
        Attack Left
      </button>
      <button onClick={() => setAction("Attack Right")}>
        Attack Right
      </button>
      <button
        onClick={() => setAction("Transfer to Left")}>
        Transfer to Left
      </button>
      <button
        onClick={() => setAction("Transfer to Right")}>
        Transfer to Right
      </button>

      <h1>Transfer amount is {transferAmount}</h1>
      <button onClick={() => setAmount(1)}>
        1
      </button>
      <button onClick={() => setAmount(2)}>
        2
      </button>
      <button onClick={() => setAmount(3)}>
        3
      </button>
      <button onClick={() => setAmount(4)}>
        4
      </button>
      <h1> </h1>

      <button 
        onClick={() => onChoice("Confirm")}>
        Confirm Choices
        </button></> : <h1>waiting...</h1>}
        {finished ? <h1>Game Finished</h1> : <></>}
    </div></>
  );
}
export default GameUI;
