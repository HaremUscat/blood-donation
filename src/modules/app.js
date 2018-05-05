import React from "react";
import Home from "./home";
import Login from "./login";
import Register from "./register";
import {
    BrowserRouter,
    Route
} from "react-router-dom";

class App extends React.Component {
    render() {
        return (
            <BrowserRouter>
                <div>
                    <Route path="/home" component={Home}/>
                    <Route path="/login" component={Login}/>
                    <Route path="/register" component={Register}/>
                </div>
            </BrowserRouter>
        );
    }
}

export default App;