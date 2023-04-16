const RegisterStyles = {
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
    registerMsg: {
        marginBottom: '20px',
        fontSize: '20px',
    },
    usernameTextfield: {
        marginTop: '10px',
    },
    emailTextField: {
        marginTop: '10px',
    },
    passwordTextfield: {
        marginTop: '10px',
    },
    confirmButton: {
        marginTop: '20px',
    }

}   

export default RegisterStyles;