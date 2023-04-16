import { useRef } from 'react';
import { useNavigate } from 'react-router-dom';
import { getAuth, createUserWithEmailAndPassword} from 'firebase/auth';

import styles from '../styles/RegisterStyles'
import { Button, TextField } from '@mui/material'
import { auth } from '..';

function Register() {
    const navigate = useNavigate();

    const usernameRef = useRef(null);
    const emailRef = useRef(null);
    const passwordRef = useRef(null);

    function handleRegister() {
        const username = usernameRef?.current?.querySelector("input").value;
        const email = emailRef?.current?.querySelector("input").value;
        const password = passwordRef?.current?.querySelector("input").value;

        if (emailValidation(email) === false || passwordValidation(password) === false) {
            alert('Invalid Email/password')
            return
        }

        createUserWithEmailAndPassword(auth, email, password)
        .then(function() {
            var user = auth.currentUser

            var user_data = {
                email : email,
                username : username,
            }

            alert ('user created')

            navigate("/login")
        })
        .catch(function(error) { 
            var error_code = error.code
            var error_message = error.message

            alert(error_message)
        })

        /*if(username && password) {
            // Call register controller function here. 
            // If error:
            //    -> do nothing or show error message.
            // If success:
            //    -> navigate to login page.
            navigate("/login")
        }*/
    }

    function emailValidation(email) {
        if (/^[^@]+@\w+(\.\w+)+\w$/.test(email) === true) {
            return true
        } else {
            return false
        }
    }

    function passwordValidation(password) {
        if (password < 6) {
            return false
        } else {
            return true
        }
    }

    return (
        <div style={styles.wrapper}>
            <div style={styles.centerContainer}>
                <div style={styles.registerMsg}>
                    Register:
                </div>  
                <TextField ref={usernameRef} label="Username" style={styles.usernameTextfield}></TextField>
                <TextField ref={emailRef} label="Email" style={styles.emailTextfield}></TextField>
                <TextField ref={passwordRef} label="Password" style={styles.passwordTextfield}></TextField>
                <Button onClick={handleRegister} variant="contained" style={styles.confirmButton}>
                    Confirm
                </Button>
            </div>
        </div>
    );
}

export default Register;