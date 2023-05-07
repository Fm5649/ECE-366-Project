import { useRef } from 'react';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import {getAuth, signInWithEmailAndPassword} from 'firebase/auth';

import styles from '../styles/LoginStyles'
import { Button, TextField } from '@mui/material'
import { auth } from '..';
import { database } from '..';
import axios from "axios";

function Login() {
    const [error, setError] = useState('');
    const navigate = useNavigate();

    const usernameRef = useRef(null);
    const emailRef = useRef(null);
    const passwordRef = useRef(null);

    const handleLogin = async() => {
        const email = emailRef?.current?.querySelector("input").value;
        const username = usernameRef?.current?.querySelector("input").value;
        const password = passwordRef?.current?.querySelector("input").value;
        try {
            const a = await signInWithEmailAndPassword(auth, email, password);
            console.log(a);
            sessionStorage.setItem("username",username);
            const token = await auth.currentUser.getIdToken();
            sessionStorage.setItem("idToken",token);
            const res = await axios.get(`http://localhost:8080/getPlayerByName/${username}`,{headers: {
                "Access-Control-Allow-Origin":
                    "*",
                    "Authorization":`Bearer ${token}`
                }});
            console.log(res);
            sessionStorage.setItem("id",res.data.id);
            navigate("/home");
        } catch (e) {
            setError(e.message);
        };
    }

    return (
        <div style={styles.wrapper}>
            <div style={styles.centerContainer}>
                <div style={styles.loginMsg}>
                    Login:
                </div>  
                <TextField ref={usernameRef} label="Username" style={styles.usernameTextfield}></TextField>
                <TextField ref={emailRef} label="Email" style={styles.emailTextfield}></TextField>
                <TextField ref={passwordRef} label="Password" style={styles.passwordTextfield}></TextField>
                <Button onClick={handleLogin} variant="contained" style={styles.confirmButton}>
                    Confirm
                </Button>
                <div>{error}</div>
            </div>
        </div>
    );
}

export default Login;