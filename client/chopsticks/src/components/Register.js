import { useRef } from 'react';
import { useNavigate } from 'react-router-dom';

import styles from '../styles/RegisterStyles'
import { Button, TextField } from '@mui/material'

function Register() {
    const navigate = useNavigate();

    const usernameRef = useRef(null);
    const passwordRef = useRef(null);

    function handleRegister() {
        const username = usernameRef?.current?.querySelector("input").value;
        const password = passwordRef?.current?.querySelector("input").value;

        if(username && password) {
            // Call register controller function here. 
            // If error:
            //    -> do nothing or show error message.
            // If success:
            //    -> navigate to login page.
            navigate("/login")
        }
    }

    return (
        <div style={styles.wrapper}>
            <div style={styles.centerContainer}>
                <div style={styles.registerMsg}>
                    Register:
                </div>  
                <TextField ref={usernameRef} label="Username" style={styles.usernameTextfield}></TextField>
                <TextField ref={passwordRef} label="Password" style={styles.passwordTextfield}></TextField>
                <Button onClick={handleRegister} variant="contained" style={styles.confirmButton}>
                    Confirm
                </Button>
            </div>
        </div>
    );
}

export default Register;