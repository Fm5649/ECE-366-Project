import { useNavigate } from 'react-router-dom';

import styles from '../styles/SideBarStyles'
import { IconButton } from '@mui/material'
import SettingsIcon from '@mui/icons-material/Settings';
import LeaderboardIcon from '@mui/icons-material/Leaderboard';
import LogoutIcon from '@mui/icons-material/Logout';

function SideBar() {
    const navigate = useNavigate();

    function navigateSettings() {
        navigate("/settings");
    }

    function navigateLeaderboards() {
        navigate("/leaderboards");
    }

    function navigateLanding() {
        navigate("/")
    }

    return (
        <div style={styles.wrapper}>
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