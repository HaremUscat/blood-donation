const axios = require('axios');

function redirectToPrevious(p) {
    if (p) {
        localStorage.removeItem("prevComponentPath");
        this.props.history.push(p);
    } else {
        this.props.history.push('/user-dashboard');
    }
}

function login() {
    axios.post('/login', { username: this.state.username, password: this.state.password })
        .then((response) => {
            if (!response.data.isError) {
                axios.get('/users/'+this.state.username)
                    .then((result) => {
                        // setting up the local storage with useful information about the user:
                        localStorage.setItem("loggedInUser", this.state.username);
                        //localStorage.setItem("loggedInUserEmail", result.data.rows[0].email);

                        // redirect to the previous component (which redirected me to the login page), if it exists:
                        let p = localStorage.prevComponentPath;
                        redirectToPrevious.bind(this)(p);
                    })
                    .catch(err => { alert(err); });
            } else {
                alert(response.data.message);
            }
        })
        .catch(function(err) { alert(err); });
}

function logout() {
    return axios.post('/logout', { username: localStorage.loggedInUser })
        .then(() => {
            localStorage.removeItem("loggedInUser");
            //localStorage.removeItem("loggedInUserEmail");
            this.setState({ success: true });
        })
        .catch(function(err) {
            alert(err);
        });
}

module.exports = {
    login,
    logout
};