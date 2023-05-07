import { useNavigate } from 'react-router-dom';

import styles from '../styles/LandingStyles'
import { Button } from '@mui/material';

function Landing() {
    const navigate = useNavigate();

    // navigate to login on buttonpress
    function navigateLogin() {
        navigate("/login")
    }   

    // navigate to register on buttonpress
    function navigateRegister() {
        navigate("/register")
    }

    // basic welcome page with login/register
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