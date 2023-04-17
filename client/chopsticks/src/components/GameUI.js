import "./App.css";
import React, { useState } from 'react';
import styled from 'styled-components';
import { useRef } from 'react';
import { useEffect } from 'react';

//https://react.school/ui/input
// Styling a regular HTML input
const StyledInput = styled.input`
  display: block;
  margin: 20px 0px;
  border: 1px solid lightblue;
`;

function useInput(defaultValue) {
  const [value, setValue] = useState(defaultValue);
  function onChange(e) {
    setValue(e.target.value);
  }
  return {
    value,
    onChange,
  };
}

function GameUI() {
  const [action, setAction] = useState("Attack");
  const inputProps = useInput();
  return (
    <div className="GameUI">
      <h1>Current action is {action}</h1>
      <button onClick={() => setAction("Attack")}>
        Attack
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
    </div>
  );
}
export default GameUI;
