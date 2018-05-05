import React from 'react';

/*
  Button Component
*/
class Button extends React.Component {
    constructor(props) {
        super(props);
        this.onClick = props.onClick;
        this.color = props.color;
        this.width = props.width;
    }

    render() {
        return (
            <button className="btn btn-primary darken-on-hover"
                    onClick={this.onClick}
                    style={{backgroundColor: `${this.color}`, borderColor: `${this.color}`, width: `${this.width}`, cursor: 'pointer'}}>
                {this.props.children}
            </button>
        );
    }
}

export default Button;
