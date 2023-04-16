import { useRef } from 'react';
import { useNavigate } from 'react-router-dom';

import styles from '../styles/LoginStyles'
import { Button, TextField } from '@mui/material'

function Login() {
    const navigate = useNavigate();

    const usernameRef = useRef(null);
    const passwordRef = useRef(null);

    function handleLogin() {
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
                <TextField ref={passwordRef} label="Password" style={styles.passwordTextfield}></TextField>
                <Button onClick={handleLogin} variant="contained" style={styles.confirmButton}>
                    Confirm
                </Button>
            </div>
        </div>
    );
}

export default Login;