import "./App.css";
import React, { useState } from 'react';
import { useRef } from 'react';
import { useEffect } from 'react';

function GameUI() {
  const [action, setAction] = useState("");
  const [transferAmount, setAmount] = useState(0);
  
  const [playerLeft, setPlayerLeft] = useState(1);
  const [playerRight, setPlayerRight] = useState(1);
  const [enemyLeft, setEnemyLeft] = useState(1);
  const [enemyRight, setEnemyRight] = useState(1);
    
  const onChoice = (choice) => {
    if (action === "Attack Left"){
      if(enemyLeft + transferAmount === 5){
        setEnemyLeft(0);
      }
      if(enemyLeft + transferAmount > 5){
        setEnemyLeft(enemyLeft + transferAmount - 5);
      }
      else
      {
        setEnemyLeft(enemyLeft + transferAmount);
      }
    }
    if (action === "Attack Right"){
      if(enemyRight + transferAmount === 5){
        setEnemyRight(0);
      }
      if(enemyRight + transferAmount > 5){
        setEnemyRight(enemyRight + transferAmount - 5);
      }
      else
      {
        setEnemyRight(enemyRight + transferAmount);
      }
    }
    if (action === "Transfer to Left"){
      setPlayerLeft(playerLeft - transferAmount);
      setPlayerRight(playerRight + transferAmount);
    }
    if (action === "Transfer to Right"){
      setPlayerRight(playerRight - transferAmount);
      setPlayerLeft(playerLeft + transferAmount);
    }
}
  
  
  return (
    <div className="GameUI">
      <h1>Enemy Hands</h1>
      <span>Left Hand: {enemyLeft} Right Hand: {enemyRight}</span>
      <h1>Your Hands</h1>
      <span>Left Hand: {playerLeft} Right Hand: {playerRight}</span>

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

      <StyledInput
        {...inputProps}
        placeholder="Type in value"
      />
      <span>Value: {inputProps.value} </span>

      <button 
        onClick={() => onChoice("Confirm")}>
        Confirm Choices
        </button>   
    </div>
  );
}
export default GameUI;
