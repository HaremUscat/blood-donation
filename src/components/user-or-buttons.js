import React from 'react';

/*
    UserOrButtons Component (for the Navbar)
 */
class UserOrButtons extends React.Component {
    constructor(props) {
        super(props);
        this.notLoggedIn = props.notLoggedIn;
    }

    render() {
        if(this.notLoggedIn) {
            return (
                <ul className="navbar-user navbar-nav my-navbar-list">
                    <li className="nav-item navbar-visible-link">
                        <a className="nav-link" href="/login">Log In</a>
                    </li>
                    <li className="nav-item navbar-visible-link">
                        <a className="nav-link" href="/register">Sign Up</a>
                    </li>
                </ul>
            );
        } else {
            return (
                <ul className="navbar-user navbar-nav my-navbar-list">
                    <li className="nav-item dropdown navbar-visible-profile-link">
                        <a className="nav-link dropdown-toggle" href="" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            {localStorage.loggedInUserName}
                        </a>
                        <div className="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <a className="dropdown-item" href="/logout">Log Out</a>
                        </div>
                    </li>

                    <li className="nav-item">
                        <a className="nav-link" href="">
                            <img
                                src={"/images/user-icon.svg"}
                                alt="Avatar" id="profile-img"
                            />
                        </a>
                    </li>
                </ul>
            );
        }
    }
}

export default UserOrButtons;
