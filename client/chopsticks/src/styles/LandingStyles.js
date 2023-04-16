const LandingStyles = {
    wrapper: {
        display: 'grid',
        gridTemplateRows: '25% 75%',
        gridTemplateColumns: '1fr 1fr 1fr',
        height: '100vh',
        fontFamily: 'sans-serif',
    },
    centerContainer: {
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        gridRow: 2,
        gridColumn: 2,
    },
    appName: {
        fontSize: '2vw',
    },
    buttonContainer: {
        display: 'flex', 
        flexDirection: 'row',
        marginTop: '70px',
    },
    loginButton: {
        fontSize: '1vw',
        marginRight: '10px',
    },
    registerButton: {
        fontSize: '1vw',
        marginLeft: '10px',
    }
}   

export default LandingStyles;