import { useRef } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from "axios";
import { createUserWithEmailAndPassword} from 'firebase/auth';

import styles from '../styles/RegisterStyles'
import { Button, TextField } from '@mui/material'
import { auth } from '..';

function Register() {
    const navigate = useNavigate();

    const usernameRef = useRef(null);
    const emailRef = useRef(null);
    const passwordRef = useRef(null);

    function handleRegister() {
        // asign constants to user inputs
        const username = usernameRef?.current?.querySelector("input").value;
        const email = emailRef?.current?.querySelector("input").value;
        const password = passwordRef?.current?.querySelector("input").value;

        // check for valid email and password
        if (emailValidation(email) === false || passwordValidation(password) === false) {
            alert('Invalid Email/password')
            return
        }

        // creates user in firebase
        createUserWithEmailAndPassword(auth, email, password)
        .then(function() {
            // insert player into database
            axios.post(`${process.env.REACT_APP_BACKEND_URL}/insertPlayer`,{userName:username,password:password,email:email},{headers: {
                    "Access-Control-Allow-Origin":
                      "*"
                  },}).then((res) => {alert ('user created'); console.log(res);
                  auth.currentUser.getIdToken(true).then((str) =>{
                    sessionStorage.setItem("idToken",str);
                    // store curren session user id
                    sessionStorage.setItem("id",res.data.id);
                    sessionStorage.setItem("username",username);
                    // navigate to home page if no errors
                    navigate("/home")} )});
        })
        .catch(function(error) { 
            var error_message = error.message

            alert(error_message)
        })
    }

    // valid email check
    function emailValidation(email) {
        if (/^[^@]+@\w+(\.\w+)+\w$/.test(email) === true) {
            return true
        } else {
            return false
        }
    }

    // valid password check
    function passwordValidation(password) {
        if (password < 6) {
            return false
        } else {
            return true
        }
    }

    // display username, email and password input boxes
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