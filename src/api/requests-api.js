const axios = require('axios');

function submitRequest(request) {
    return axios.post('/requests', request)
        .then((response) => {
            if (response.data.isError) {
                alert(response.data.message);       //TODO: get rid of alerts!
            }
        })
        .catch(function(err) {
            alert(err);
        });
}

module.exports = {submitRequest};