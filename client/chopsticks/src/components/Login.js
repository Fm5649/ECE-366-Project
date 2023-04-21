import { useRef } from 'react';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import {signInWithEmailAndPassword} from 'firebase/auth';

import styles from '../styles/LoginStyles'
import { Button, TextField } from '@mui/material'
import { auth } from '..';
import axios from "axios";

function Login() {
    const [error, setError] = useState('');
    const navigate = useNavigate();

    const usernameRef = useRef(null);
    const emailRef = useRef(null);
    const passwordRef = useRef(null);

    // async function for login
    const handleLogin = async() => {
        // asign constants to user inputs
        const email = emailRef?.current?.querySelector("input").value;
        const username = usernameRef?.current?.querySelector("input").value;
        const password = passwordRef?.current?.querySelector("input").value;
        try {
            // check firebase to see if email and password match in its database
            const a = await signInWithEmailAndPassword(auth, email, password);
            console.log(a);
            // checks username, and stores id token from firebase
            sessionStorage.setItem("username",username);
            const token = await auth.currentUser.getIdToken();
            sessionStorage.setItem("idToken",token);
            const res = await axios.get(`http://localhost:8080/getPlayerByName/${username}`,{headers: {
                "Access-Control-Allow-Origin":
                    "*",
                }});
            console.log(res);
            // stores the id of the current session user
            sessionStorage.setItem("id",res.data.id);
            // navigates to home page if error doesn't occur b4hand
            navigate("/home");
        } catch (e) {
            setError(e.message);
        };
    }

    // displays input boxes for username, email, password
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