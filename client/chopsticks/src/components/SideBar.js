import { useNavigate } from 'react-router-dom';

import styles from '../styles/SideBarStyles'
import { IconButton } from '@mui/material'
import SettingsIcon from '@mui/icons-material/Settings';
import LeaderboardIcon from '@mui/icons-material/Leaderboard';
import LogoutIcon from '@mui/icons-material/Logout';
import HomeIcon from '@mui/icons-material/Home';

function SideBar() {
    const navigate = useNavigate();

    // navigates to profile/settings on button press
    function navigateSettings() {
        navigate("/settings");
    }

    // navigates to leadboards on button press
    function navigateLeaderboards() {
        navigate("/leaderboards");
    }

    // navigates to landing page (login/register) on button press
    // essentially signs out
    function navigateLanding() {
        navigate("/")
    }

    // sidebar with settings/leaderboards/landing page button
    return (
        <div style={styles.wrapper}>
            <IconButton onClick={()=>{navigate("/home")}} style={styles.settingsButton}>
                <HomeIcon fontSize="large"/>
            </IconButton>
            <IconButton onClick={navigateSettings} style={styles.settingsButton}>
                <SettingsIcon fontSize="large"/>
            </IconButton>
            <IconButton onClick={navigateLeaderboards} style={styles.leaderboardsButton}>
                <LeaderboardIcon fontSize="large"/>
            </IconButton>
            <IconButton onClick={navigateLanding} style={styles.logoutButton}>
                <LogoutIcon fontSize="large"/>
            </IconButton>
        </div>
    );
}

export default SideBar;