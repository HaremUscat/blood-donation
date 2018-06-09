const fooReceivedForms = require( "../foo-data/foo-received-forms" );
const axios = require('axios');

function getDonationFormInfo() {
    return axios.get('/donation-forms/'+localStorage.getItem("loggedInUser"));
}

function submitDonation(donation) {
    return axios.post('/donation-forms', donation)
        .then((response) => {
            if (response.data.isError) {
                alert(response.data.message);       //TODO: get rid of alerts!
            }
        })
        .catch(function(err) {
            alert(err);
        });
}

function updateDonation(donation){
    return axios.post('/donation-forms/'+donation["donationDto"]["donation_id"], donation)
        .then((response) => {
            if (response.data.isError) {
                alert(response.data.message);       //TODO: get rid of alerts!
            }
        })
        .catch(function(err) {
            alert(err);
        });
}

function getReceivedForms() {
    return axios.get('/received-forms');
    // return new Promise((resolve, reject) => {
    //     resolve({forms: fooReceivedForms});                           //TODO: remove these 3 lines, sample data for front-end testing purposes
    // });
}

function saveAppointment(donationFormID, _appointmentDate) {
    return axios.put('/donation-forms/approve', {donation_id: donationFormID, appointmentDate: _appointmentDate});
    // return new Promise((resolve, reject) => {
    //     resolve({hey: 'yeah'});                           //TODO: remove these 3 lines, sample data for front-end testing purposes
    // });
}

function saveRejection(donationFormID, _rejectionReason) {
    return axios.put('/donation-forms/reject', {donationId: donationFormID, rejectionReason: _rejectionReason});
    // return new Promise((resolve, reject) => {
    //     resolve({hey: 'yeah'});                           //TODO: remove these 3 lines, sample data for front-end testing purposes
    // });
}

module.exports = {submitDonation, getDonationFormInfo, updateDonation, getReceivedForms, saveAppointment, saveRejection};