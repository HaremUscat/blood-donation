import React from 'react';

/*
  BlockButton Component
*/
class BlockButton extends React.Component {
  constructor(props) {
    super(props);
    this.onClick = props.onClick;
    this.color = props.color;
  }

  render() {
    return (
      <button className="btn btn-primary btn-block darken-on-hover"
              onClick={this.onClick}
              style={{backgroundColor: `${this.color}`, borderColor: `${this.color}`, marginBottom: '20px', cursor: 'pointer'}}>
              {this.props.children}
      </button>
    );
  }
}

export default BlockButton;
