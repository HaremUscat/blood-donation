import React from "react";
import Form from '../components/form';
import Input from '../components/input';
import BlockButton from '../components/block-button';
import Button from '../components/button';
const usersApi = require('../api/users-api');

class AdminDashboard extends React.Component {
    constructor() {
        super();
        this.state = {
            username: '',
            email: '',
            password: '',
            centerId: '',
            userType: ''
        };
        this.handleChangedTextField = this.handleChangedTextField.bind(this);
        this.handleChangedUserType = this.handleChangedUserType.bind(this);
        //this.registerDoctorOrStaff = usersApi.registerDoctorOrStaff.bind(this);     //TODO
        //this.deleteDoctorOrStaff = usersApi.deleteDoctorOrStaff.bind(this);         //TODO
    }

    handleChangedTextField(event) {

    }

    handleChangedUserType(event) {

    }

    registerDoctorOrStaff() {

    }

    deleteDoctorOrStaff() {

    }

    logout() {

    }

    render() {
        return (
            <div className="container" style={{minHeight: '100vh'}}>
                <div className="row align-items-center justify-content-center" style={{minHeight: '100vh'}}>
                    <div className="col-9 col-sm-8 col-md-6 col-lg-4">
                        <img src="/images/bloodyfast-logo.jpg" alt="BloodyFast logo" className="logo"/>

                        <Form>
                            <Input type="text" placeholder="Username" onChange={this.handleChangedTextField}/>
                            <Input type="text" placeholder="Email" onChange={this.handleChangedTextField}/>
                            <Input type="password" placeholder="Password" onChange={this.handleChangedTextField}/>
                            <Input type="centerId" placeholder="Center ID (only for center staff users)" onChange={this.handleChangedTextField}/>
                        </Form>

                        <br/>
                        <br/>

                        <BlockButton color='#ec0a0b' onClick={this.registerDoctorOrStaff} fontFamily="Questrial">REGISTER USER</BlockButton>

                        <BlockButton color='#ec0a0b' onClick={this.deleteDoctorOrStaff} fontFamily="Questrial">REMOVE USER*</BlockButton>

                        <h6 style={{marginBottom: '50px', fontSize: '16px', fontWeight: 'lighter'}}>* if you wish to remove a user, the only required field is the username.</h6>

                        <div className="row align-items-center justify-content-center">
                            <Button color='#ec0a0b' width="90px" onClick={this.logout} fontFamily="Questrial">Log Out</Button>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default AdminDashboard;
