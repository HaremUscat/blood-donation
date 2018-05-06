import React from "react";
import {Redirect} from "react-router-dom";

/*
  EnsureLoggedIn Middleware (basically, a function)
  Description:
    returns a component if the user is logged in and has access;
    otherwise, redirects the user to the login page

  Input:
    @props {object} Component = the React component to be rendered if logged in
    @props {string} currentPath = the path from which the user is redirected to the login page
    @props props = properties to pass on to the component
*/
const EnsureLoggedIn = (Component, currentPath, props) => {
    if (localStorage.loggedInUser) {
        return <Component {...props}/>;
    } else {
        localStorage.setItem("prevComponentPath", currentPath);
        return <Redirect to="/login"/>
    }
};

const EnsureNotLoggedIn = (Component, currentPath, props) => {
    if (!localStorage.loggedInUser) {
        return <Component {...props}/>;
    } else {
        localStorage.setItem("prevComponentPath", currentPath);
        return <Redirect to="/user-dashboard"/>
    }
};

export {EnsureLoggedIn, EnsureNotLoggedIn};
