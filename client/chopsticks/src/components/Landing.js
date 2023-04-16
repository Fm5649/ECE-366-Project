import { useNavigate } from 'react-router-dom';

import styles from '../styles/LandingStyles'
import { Button } from '@mui/material';

function Landing() {
    const navigate = useNavigate();

    function navigateLogin() {
        navigate("/login")
    }   

    function navigateRegister() {
        navigate("/register")
    }

    return (
        <div style={styles.wrapper}>
            <div style={styles.centerContainer}>
                <div style={styles.appName}>
                    Welcome to the Chopsticks Game!
                </div>
               <div style={styles.buttonContainer}>
                    <Button onClick={navigateLogin} variant="contained" style={styles.loginButton}>
                        Login
                    </Button>   
                    <Button onClick={navigateRegister} variant="contained" style={styles.registerButton}>
                        Register
                    </Button>
               </div>
            </div>
        </div>
    );
}

export default Landing;