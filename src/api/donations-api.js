const axios = require('axios');

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

module.exports = {submitDonation};