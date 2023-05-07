// File containing the styles of UI for settings/profile page

const SettingsStyles = {
    wrapper: {
        display: 'grid',
        gridTemplateRows: '25% 75%',
        gridTemplateColumns: '5% 95%',
        width: '100vw',
        height: '100vh',
        fontFamily: 'sans-serif',
    },
    sideBarContainer: {
        gridRow: 'span 2',
        gridColumn: '1',
        borderRight: '2px solid black'
    },
    centerContainer: {
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        gridRow: 2,
        gridColumn: 2,
    },
    startMsg: {
        fontSize: '40px',
    },
    buttonContainer: {
        display: 'flex', 
        flexDirection: 'row',
        marginTop: '70px',
    },
    startButton: {
        fontSize: '1vw',
        marginRight: '10px',
    },
    joinButton: {
        fontSize: '1vw',
        marginLeft: '10px',
    },
}   

export default SettingsStyles;