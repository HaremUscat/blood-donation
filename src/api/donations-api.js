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

module.exports = {submitDonation, getDonationFormInfo};