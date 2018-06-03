import React from 'react';
import Button from "../components/button";
import {printStandardDate} from "../utils/dates";
import {printBool} from '../utils/bools';
import Form from "../components/form";
import Input from "../components/input";
import DonorBox from "./donor-box";
const donationsApi = require('../api/donations-api');

class ReceivedDonationsTableBody extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            rows: props.rows,
            appointmentDate: '',
            rejectionReason: ''
        };
        this.saveAppointment = this.saveAppointment.bind(this);
        this.saveRejection = this.saveRejection.bind(this);
        this.handleChangedAppointmentDate = this.handleChangedAppointmentDate.bind(this);
        this.handleChangedRejectionReason = this.handleChangedRejectionReason.bind(this);
    }

    componentWillReceiveProps(newProps) {
        this.setState({rows: newProps.rows});
    }

    saveAppointment(form, event) {
        donationsApi.saveAppointment(form.donationId, this.state.appointmentDate)
            .then(() => {
                window.location.reload();
            });
    }

    saveRejection(form, event) {
        donationsApi.saveRejection(form.donationId, this.state.rejectionReason)
            .then(() => {
                window.location.reload();
            });
    }

    handleChangedAppointmentDate(event) {
        this.setState({appointmentDate: event.target.value});
    }

    handleChangedRejectionReason(event) {
        this.setState({rejectionReason: event.target.value});
    }

    render() {
        return (
            <tbody>
            {this.state.rows.map((form, index) =>
                <tr key={form.donationId}>
                    <td>
                        <div className="container">
                            <div className="row align-items-center" style={{minHeight: '40vh', paddingTop: '40px', paddingBottom: '40px'}}>
                                <DonorBox title="Donor Personal Info">
                                    <div className="donor-info-box">
                                        <h5 style={{color: '#ec0a0b'}}>Form ID: {form.donationId}</h5>
                                        <h5 style={{color: '#ec0a0b'}}>Name: {form.firstName} {form.lastName}</h5>
                                        <h5 style={{fontWeight: 'lighter', fontSize: '20px'}}>CNP: {form.cnp}</h5>
                                        <h5 style={{fontWeight: 'lighter', fontSize: '20px'}}>Phone: {form.phone}</h5>
                                        <h5 style={{fontWeight: 'lighter', fontSize: '20px'}}>Email: {form.email}</h5>
                                        <h6 style={{fontWeight: 'lighter'}}>Blood group: {form.bloodType}</h6>
                                        <h6 style={{fontWeight: 'lighter'}}>Rh: {form.rh}</h6>
                                        <h6 style={{fontWeight: 'lighter'}}>Gender: {form.gender}</h6>
                                        <h6 style={{fontWeight: 'lighter'}}>DOB: {printStandardDate(form.birthDate)}</h6>
                                    </div>
                                </DonorBox>

                                <DonorBox title="Donor Health">
                                    <div style={{fontWeight: 'lighter', textAlign: 'center'}}>
                                        <h6 style={{fontWeight: 'lighter'}}>Blood pressure: {form.bloodPressure}</h6>
                                        <h6 style={{fontWeight: 'lighter'}}>Pulse: {form.pulse}</h6>
                                        <h6 style={{fontWeight: 'lighter'}}>Weight: {form.weight}</h6>
                                        <h6 style={{fontWeight: 'lighter'}}>Allergies: {form.allergies}</h6>
                                        <h6 style={{fontWeight: 'lighter'}}>Chronic illness: {form.chronicIllness}</h6>
                                        <h6 style={{fontWeight: 'lighter'}}>Disqualifying diseases: {form.diseases}</h6>
                                        <h6 style={{fontWeight: 'lighter'}}>Cancer in the past 5 years: {printBool(form.cancerPast5Years)}</h6>
                                        <h6 style={{fontWeight: 'lighter'}}>Pregnant or menstruating: {printBool(form.pregnantOrMenstruating)}</h6>
                                        <h6 style={{fontWeight: 'lighter'}}>Recent tattoos: {printBool(form.recentTattoos)}</h6>
                                        <h6 style={{fontWeight: 'lighter'}}>Surgery in the past 6 months: {printBool(form.surgeryPast6Months)}</h6>
                                    </div>
                                </DonorBox>

                                <DonorBox>
                                    <div className="card">
                                        <div className="card-header donation-form-card" id="headingOne">
                                            <h5 className="mb-0">
                                                <button className="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                                                    Accept
                                                </button>
                                            </h5>
                                        </div>
                                        <div id="collapseOne" className="collapse" aria-labelledby="headingOne" data-parent="#accordion">
                                            <div className="card-body" style={{padding: '15px'}}>
                                                <Form onChange={this.handleChangedAppointmentDate}>
                                                    <Input name="appointmentDate" label="Appointment date" type="text" placeholder="dd-mm-yyyy"/>
                                                </Form>
                                                <br/>
                                                <Button onClick={this.saveAppointment.bind(this, form)} color="#ec0a0b" width="200px" fontFamily="Questrial, sans-serif">
                                                    SAVE APPOINTMENT
                                                </Button>
                                            </div>
                                        </div>
                                    </div>

                                    <div className="card">
                                        <div className="card-header donation-form-card" id="headingTwo">
                                            <h5 className="mb-0">
                                                <button className="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                                    Reject
                                                </button>
                                            </h5>
                                        </div>
                                        <div id="collapseTwo" className="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
                                            <div className="card-body" style={{padding: '15px'}}>
                                                <Form onChange={this.handleChangedRejectionReason}>
                                                    <Input name="rejectionReason" label="Rejection reason" type="text"/>
                                                </Form>
                                                <br/>
                                                <Button onClick={this.saveRejection.bind(this, form)} color="#ec0a0b" width="110px" fontFamily="Questrial, sans-serif">
                                                    REJECT
                                                </Button>
                                            </div>
                                        </div>
                                    </div>
                                </DonorBox>
                            </div>
                        </div>
                    </td>
                </tr>
            )}
            </tbody>
        );
    }
}

export default ReceivedDonationsTableBody;