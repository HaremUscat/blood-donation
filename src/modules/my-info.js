import React from "react";
import BlockButton from "../components/blockButton";
import Navbar from "../components/navbar";
import Form from "../components/form";
import Input from "../components/input";
const usersApi = require('../api/users-api');

class MyInfo extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            firstName: '',
            lastName: '',
            dateOfBirth: '',
            gender: '',
            CNP: '',
            bloodGroup: '',
            Rh: '',
            email: '',
            phone: '',
            homeAddress: '',      //din buletin
            city: '',             //din buletin
            country: '',          //din buletin
            currentHomeAddress: '',
            currentCity: '',
            currentCountry: '',
            allergies: '',
            diseases: '',
            chronicIllness: '',
            username: localStorage.getItem("loggedInUser")
        };

        this.handleChangedTextField = this.handleChangedTextField.bind(this);
        this.handleChangedAllergies = this.handleChangedAllergies.bind(this);
        this.handleChangedDiseases = this.handleChangedDiseases.bind(this);
        this.handleChangedChronic = this.handleChangedChronic.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.submitMyInfo = usersApi.submitMyInfo.bind(this);
        this.prefillFields = usersApi.getMyInfo.bind(this);
    }

    componentWillMount() {
        this.setState(this.prefillFields(), function() {

            if (this.state["allergies"] === 'yes') {
                this.refs.allergiesYes.checked = true;
            } else
                if (this.state["allergies"] !== '') {
                    this.refs.allergiesNo.checked = true;
                }

            if (this.state["diseases"] === 'yes') {
                this.refs.diseasesYes.checked = true;
            } else
                if (this.state["diseases"] !== '') {
                    this.refs.diseasesNo.checked = true;
                }

            if (this.state["chronicIllness"] === 'yes') {
                this.refs.chronicYes.checked = true;
            } else
                if (this.state["chronicIllness"] !== '') {
                    this.refs.chronicNo.checked = true;
                }

        });
    }

    handleChangedTextField(event) {
        let field = event.target.name;
        let value = event.target.value;
        let myInfo = this.state;
        myInfo[field]=value;
        this.setState(myInfo);
    }

    handleChangedAllergies(event) {
        if (event.target.id==='allergiesYes' && event.target.checked) {
            this.setState({allergies: 'yes'});
        } else {
            this.setState({allergies: 'no'});
        }
    }

    handleChangedDiseases(event) {
        if (event.target.id==='diseasesYes' && event.target.checked) {
            this.setState({diseases: 'yes'});
        } else {
            this.setState({diseases: 'no'});
        }
    }

    handleChangedChronic(event) {
        if (event.target.id==='chronicYes' && event.target.checked) {
            this.setState({chronicIllness: 'yes'});
        } else {
            this.setState({chronicIllness: 'no'});
        }
    }

    handleSubmit(event) {
        event.preventDefault();
        let ok = true;
        for (let field in this.state) {
            if (this.state.hasOwnProperty(field) && this.state[field] === '') {
                alert("All fields are mandatory!");     //TODO: remove all alerts!
                ok = false;
            }
        }
        if (ok) {
            this.submitMyInfo(this.state);
            window.location.reload();
        }
    }

    render() {
        return (
            <div>
                <Navbar notLoggedIn={false} extraLinks={[
                    {text: "DASHBOARD", reference: "/user-dashboard", extraClasses: ''},
                    {text: "NEXT DONATION", reference: "/next-donation", extraClasses: ''},
                    {text: "TEST RESULTS", reference: "/test-results-history", extraClasses: ''},
                    {text: "MY INFORMATION", reference: "/my-info", extraClasses: 'active-navbar-link'}
                ]}/>

                {/* Add Personal Information Form */}
                <div className="container">
                    <div className="row above-footer align-items-center justify-content-center">
                        <div className="col-11" style={{textAlign: 'center'}}>
                            <h1 className="questrial-font" style={{marginBottom: '90px', marginTop: '100px', fontSize: '40px'}}>Edit Personal Information</h1>
                        </div>
                        <div className="col-11 col-sm-8 col-md-6 col-lg-5" style={{textAlign: 'center'}}>
                            <Form handleSubmit={this.handleSubmit} onChange={this.handleChangedTextField}>
                                <h3 className="questrial-font" style={{fontWeight: '100', marginBottom: '20px'}}>General Information</h3>
                                <Input name="firstName" label="First name" type="text" placeholder={this.state.firstName}/>
                                <Input name="lastName" label="Last name" type="text" placeholder={this.state.lastName}/>
                                <Input name="dateOfBirth" label="Date of birth" type="text" placeholder={this.state.dateOfBirth}/>
                                <Input name="gender" label="Gender" type="text" placeholder={this.state.gender}/>
                                <Input name="CNP" label="CNP" type="text" placeholder={this.state.CNP}/>
                                <Input name="bloodGroup" label="Blood group" type="text" placeholder={this.state.bloodGroup}/>
                                <Input name="Rh" label="Rh" type="text"  placeholder={this.state.Rh}/>
                                <Input name="email" label="Email (one address, please)" type="text" placeholder={this.state.email}/>
                                <Input name="phone" label="Phone number" type="text" placeholder={this.state.phone}/>

                                <h3 className="questrial-font" style={{fontWeight: '100', marginBottom: '20px', marginTop: '50px'}}>Address</h3>
                                <Input name="homeAddress" label="Permanent home address (from your ID)" type="text" placeholder={this.state.homeAddress}/>
                                <Input name="city" label="City (from your ID)" type="text" placeholder={this.state.city}/>
                                <Input name="country" label="Country (from your ID)" type="text" placeholder={this.state.country}/>
                                <Input name="currentHomeAddress" label="Current address" type="text" placeholder={this.state.currentHomeAddress}/>
                                <Input name="currentCity" label="Current city" type="text" placeholder={this.state.currentCity}/>
                                <Input name="currentCountry" label="Current country" type="text" placeholder={this.state.currentCountry}/>
                            </Form>

                                <h3 className="questrial-font" style={{fontWeight: '100', marginBottom: '20px', marginTop: '50px'}}>General Health Survey</h3>

                                <p style={{fontWeight: 'lighter', fontSize: '18px', textAlign: 'left', paddingTop: '5px', marginBottom: '5px'}}>Do you suffer from severe allergies?</p>
                                <div className="form-check" style={{textAlign: 'left', marginLeft: '20px'}}>
                                    <input className="form-check-input" type="radio" name="allergiesRadioOptions" id="allergiesYes" value="yes" ref="allergiesYes" onChange={this.handleChangedAllergies}/>
                                    <label className="form-check-label">Yes</label>
                                </div>
                                <div className="form-check" style={{textAlign: 'left', marginLeft: '20px', marginTop: '-7px'}}>
                                    <input className="form-check-input" type="radio" name="allergiesRadioOptions" id="allergiesNo" value="no" ref="allergiesNo" onChange={this.handleChangedAllergies}/>
                                    <label className="form-check-label">No</label>
                                </div>

                                <p style={{fontWeight: 'lighter', fontSize: '18px', textAlign: 'left', paddingTop: '25px', marginBottom: '5px'}}>
                                    Do you or have you ever suffered from any of the following diseases:
                                    <br/>
                                    hepatitis, tuberculosis, malaria, syphilis, pox, mental/neurological illness, brucellosis, ulcer, rheumatism, hypertension, heart disease,
                                    kidney disease, endocrine affections, diabetes, epilepsy, skin disease (psoriasis, vitiligo), myopia over +/- 6 diopters?
                                </p>
                                <div className="form-check" style={{textAlign: 'left', marginLeft: '20px'}}>
                                    <input className="form-check-input" type="radio" name="diseasesRadioOptions" id="diseasesYes" value="yes" ref="diseasesYes" onChange={this.handleChangedDiseases}/>
                                    <label className="form-check-label">Yes</label>
                                </div>
                                <div className="form-check" style={{textAlign: 'left', marginLeft: '20px', marginTop: '-7px'}}>
                                    <input className="form-check-input" type="radio" name="diseasesRadioOptions" id="diseasesNo" ref="diseasesNo" value="no" onChange={this.handleChangedDiseases}/>
                                    <label className="form-check-label">No</label>
                                </div>

                                <p style={{fontWeight: 'lighter', fontSize: '18px', textAlign: 'left', paddingTop: '25px', marginBottom: '5px'}}>Are you under chronic medical treatment (antibiotics, etc.)?</p>
                                <div className="form-check" style={{textAlign: 'left', marginLeft: '20px'}}>
                                    <input className="form-check-input" type="radio" name="chronicRadioOptions" id="chronicYes" value="yes" ref="chronicYes" onChange={this.handleChangedChronic}/>
                                    <label className="form-check-label">Yes</label>
                                </div>
                                <div className="form-check" style={{textAlign: 'left', marginLeft: '20px', marginTop: '-7px'}}>
                                    <input className="form-check-input" type="radio" name="chronicRadioOptions" id="chronicNo" value="no" ref="chronicNo" onChange={this.handleChangedChronic}/>
                                    <label className="form-check-label">No</label>
                                </div>

                            <div style={{marginTop: '90px', marginBottom: '100px'}}>
                                <BlockButton onClick={this.handleSubmit} color="#ec0a0b" width="220px" fontFamily="Questrial">SAVE CHANGES</BlockButton>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default MyInfo;