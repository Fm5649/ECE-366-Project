import { useRef } from 'react';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import {getAuth, signInWithEmailAndPassword} from 'firebase/auth';

import styles from '../styles/LoginStyles'
import { Button, TextField } from '@mui/material'
import { auth } from '..';
import { database } from '..';

function Login() {
    const [error, setError] = useState('');
    const navigate = useNavigate();

    const usernameRef = useRef(null);
    const emailRef = useRef(null);
    const passwordRef = useRef(null);

    const handleLogin = async() => {
        try {
            await signInWithEmailAndPassword(getAuth(), email, password);
            navigate('/');
        } catch (e) {
            setError(e.message);
        };
        const email = emailRef?.curent?.querySelector("input").value;
        const username = usernameRef?.current?.querySelector("input").value;
        const password = passwordRef?.current?.querySelector("input").value;

        if(username && password) {
            // Call login controller function here. 
            // If error:
            //    -> do nothing or show error message.
            // If success:
            //    -> navigate to home page.
            navigate("/home")
        }
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
            </div>
        </div>
    );
}

export default Login;