import React from "react";
import Home from "./home";
import Login from "./login";
import Register from "./register";
import {
    BrowserRouter,
    Route
} from "react-router-dom";
import {EnsureLoggedIn} from '../middleware/check-auth.js';
import {EnsureNotLoggedIn} from '../middleware/check-auth.js';

class App extends React.Component {
    render() {
        return (
            <BrowserRouter>
                <div>
                    <Route path="/home" render={(props) => EnsureNotLoggedIn(Home, "/home", props)}/>
                    <Route path="/login" component={Login}/>
                    <Route path="/logout" render={(props) => EnsureLoggedIn(Logout, "/user-dashboard", props)}/>
                    <Route path="/register" component={Register}/>
                    {/*<Route path="/user-dashboard" component={UserDashboard}/>*/}
                </div>
            </BrowserRouter>
        );
    }
}

export default App;