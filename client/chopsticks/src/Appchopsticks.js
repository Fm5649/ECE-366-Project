import "./App.css";
import { useState, useEffect } from "react";

function App() {
    const [playerOne, setPlayerOne] = useState({leftHand: 1, rightHand: 1});
    const [playerTwo, setPlayertwo] = useState({leftHand: 1, rightHand: 1});
    const [currentPlayer, setCurrentPlayer] = useState(1);
    const [winner, setWinner] = useState("");
    const [transferAmount, setTransferAmount] = useState(1);

    const action = (fromHand, toHand) => {
        if (currentPlayer === 1) {
            if ((fromHand === 'P1H1' && toHand=='P1H2') || (fromHand === 'P1H2' && toHand=='P1H1')) {
                
            }
        }
    }

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

    return (
        <div className="App">
            <h1>Welcome to RPS!</h1>
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