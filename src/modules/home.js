import React from "react";
import Navbar from "../components/navbar";
import Button from "../components/button";

class Home extends React.Component {
    constructor(props) {
        super(props);
        this.redirectToRegister = this.redirectToRegister.bind(this);
    }

    redirectToRegister() {
        this.props.history.push('/register');
    }

    render() {
        return (
            <div>
                {/* Navbar */}
                <Navbar notLoggedIn={true} extraLinks={[
                    {text: "Home", reference: "/home", extraClasses: ''},
                    {text: "FAQs", reference: "/faq", extraClasses: ''},
                    {text: "Contact", reference: "/contact", extraClasses: ''}
                ]}/>

                {/* Intro */}
                <div className="intro">
                    <div className="container">
                        <div className="row align-items-center justify-content-center" style={{minHeight: '90vh'}}>
                            <div className="col-11 col-sm-10 col-md-6" style={{textAlign: 'center'}}>
                                <h1 style={{marginBottom: '20px', fontWeight: 'lighter', fontSize: '38px'}}>The best approach to donating.</h1>
                                <h4 style={{marginBottom: '30px', fontWeight: 'lighter', fontSize: '25px'}}>BloodyFast has everything you need to donate, manage, and distribute blood. Fast.</h4>
                                <br/>
                                <br/>
                                <Button onClick={this.redirectToRegister} color="#ec0a0b" width="220px">SIGN ME UP</Button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Home;