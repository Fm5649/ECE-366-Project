import "./App.css";
import { useState, useEffect } from "react";
import axios from "axios";

function App() {
    const [userChoice, setUserChoice] = useState("");
    const [compChoice, setCompChoice] = useState("");
    const [winner, setWinner] = useState("");

    useEffect(() => {
        console.log(`Userchoice: ${userChoice}`);
    }, [userChoice]);
    const onChoice = (choice) => {
        setUserChoice(choice);
        const computerChoice = Math.floor(Math.random() * 3 + 1);
        if (computerChoice === 1) {
            setCompChoice("Rock");
        } else if (computerChoice === 2) {
            setCompChoice("Paper");
        } else if (computerChoice === 3) {
            setCompChoice("Scissors");
        }
        if (choice === "Rock") {
            if (compChoice === "Rock") {
                setWinner("Tie");
            } else if (compChoice === "Paper") {
                setWinner("Computer");
            } else if (compChoice === "Scissors") {
                setWinner("User");
            }

        }
        else {
            setWinner("Prof. Hong is too lazy to determine a winner.")
        }
    }

    useEffect(() => {
        axios.get("")
    },[])

    return (
        <div className="App">
            <h1>Welcome to RPS!</h1>
            <h1>available games</h1>
            <div></div>
            <button onClick={() => onChoice("Rock")}
                /*disabled={winner}*/>
                Rock
            </button>
            <button onClick={() => onChoice("Paper")}
                /*disabled={winner}*/>
                Paper
            </button>
            <button onClick={() => onChoice("Scissors")}
                /*disabled={winner}*/>
                Scissors
            </button>
            <h2>User choice: {userChoice}</h2>
            <h2>Computer choice: {compChoice}</h2>
            <h2>Winner: {winner}</h2>

        </div>
    );
}

export default App;