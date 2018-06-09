const axios = require('axios');

function getStockOfCenter() {
    return new Promise((resolve, reject) => {
        resolve({sth: 5});
    })
}

function diminishStock(info) {
    return axios.post('/diminish-stock/'+localStorage.getItem("loggedInCenterId"), info)
        .then((response) => {
            if (response.data.isError) {
                alert(response.data.message);       //TODO: get rid of alerts!
            }
        })
        .catch(function(err) {
            alert(err);
        });
}

function replenishStock(info) {
    return axios.post('/replenish-stock/'+localStorage.getItem("loggedInCenterId"), info)
        .then((response) => {
            if (response.data.isError) {
                alert(response.data.message);       //TODO: get rid of alerts!
            }
        })
        .catch(function(err) {
            alert(err);
        });
}

module.exports = {getStockOfCenter, diminishStock, replenishStock};