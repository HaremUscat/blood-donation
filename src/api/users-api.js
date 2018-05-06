const axios = require('axios');

function register() {
    axios.post('/users', { username: this.state.username, email: this.state.email, password: this.state.password })
        .then((response) => {
            if (!response.data.isError) {
                axios.post('/login', { username: this.state.username, password: this.state.password })
                    .then((response) => {
                        if (!response.data.isError) {
                            axios.get('/users/'+this.state.username)
                                .then((result) => {
                                    // setting up the local storage with useful information about the user:
                                    localStorage.setItem("loggedInUser", this.state.username);
                                    //localStorage.setItem("loggedInUserEmail", result.data.rows[0].email);

                                    this.props.history.push('/user-dashboard');    //TODO: add path of page which appears after login
                                })
                                .catch(err => { alert(err); });
                        } else {
                            alert(response.data.message);
                        }
                    })
                    .catch(function(err) { alert(err); });
            } else {
                alert(response.data.message);
            }
        })
        .catch(function(err) {
            alert(err);
        });
}

module.exports = {register};