import React from "react";
import Home from "./home";
import Login from "./login";
import Logout from "./logout";
import Register from "./register";
import MyInfo from "./my-info";
import UserDashboard from "./user-dashboard";
import NextDonation from "./next-donation";
import NewRequest from "./new-request";
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
                    <Route path="/logout" render={(props) => EnsureLoggedIn(Logout, "/home", props)}/>
                    <Route path="/register" component={Register}/>
                    <Route path="/my-info" render={(props) => EnsureLoggedIn(MyInfo, "/my-info", props)}/>
                    <Route path="/user-dashboard" render={(props) => EnsureLoggedIn(UserDashboard, "/user-dashboard", props)}/>
                    <Route path="/next-donation" render={(props) => EnsureLoggedIn(NextDonation, "/next-donation", props)}/>
                    <Route path="/new-request" render={(props) => EnsureLoggedIn(NewRequest, "/new-request", props)}/>
                </div>
            </BrowserRouter>
        );
    }
}

export default App;