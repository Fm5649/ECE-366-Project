import "./App.css";
import { useState, useEffect } from "react";

export function Data() {
    const [data, setData] = useState(null);
    useEffect(() => {
        fetch(
            `http://localhost:8080/api/getPlayers`
        )
            .then((response) => response.json())
            .then(setData);
    }, []);
    if (data)
        return (
            <pre>{JSON.stringify(data, null, 2)}</pre>
        );
    return <h1>Data</h1>;
}


export function fetchHands(id) {
    const [data, setData] = useState(null);
    const [playerOne, setPlayerOne] = useState({Hand1: 1, Hand2: 1});
    const [playerTwo, setPlayertwo] = useState({Hand1: 1, Hand2: 1});

    useEffect(() => {
        fetch(
            'http://localhost:8080/api/getGameRoundById/${id}'
        )
            .then((response) => response.json())
            .then(setData)
            .catch(error => console.error(error));
    }, [id]);
    if (data) {
        setPlayerOne({Hand1: data.p1Hand1, Hand2: data.p1Hand2});
        setPlayertwo({Hand1: data.p2Hand1, Hand2: data.p2Hand2});
        return {playerOne, playerTwo}
    }
    return null;
}
