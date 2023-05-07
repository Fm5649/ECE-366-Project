const Finger = (props) => {
    const {finger} = props;
    const links = ["/zero.png","/one.png","/two.png","/three.png","/four.png"];
    return <img src={links[props.finger]} style={{width:"64px",height:"64px"}}/>
}

export default Finger;