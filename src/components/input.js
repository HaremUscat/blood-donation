import React from 'react';

/*
  Input Component
*/
class Input extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name: props.name || '',
      label: props.label,
      type: props.type,
      placeholder: props.placeholder,
      onChange: props.onChange
    }
  }

  render() {
    return (
      <div style={{textAlign: 'left', fontWeight: 'lighter'}}>
        <label style={{paddingLeft: '14px', paddingTop: '5px'}}>{this.state.label}</label>
        <input name={this.state.name} className="form-control" type={this.state.type} placeholder={this.state.placeholder} onChange={this.state.onChange}/>
      </div>
    )
  }
}

export default Input;
