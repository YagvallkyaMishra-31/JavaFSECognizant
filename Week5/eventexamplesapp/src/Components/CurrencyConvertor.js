import React, { Component } from 'react';

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);
    this.state = {
      rupees: '',
      euro: ''
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  // Handle input change for rupees field
  handleChange(event) {
    this.setState({ rupees: event.target.value });
  }

  // Handle the conversion when Convert button is clicked
  handleSubmit(event) {
    event.preventDefault();
    const rupeeValue = parseFloat(this.state.rupees);
    if (isNaN(rupeeValue)) {
      alert('Please enter a valid number');
      return;
    }
    // Conversion rate: 1 Euro = approx 89 INR
    const euroValue = (rupeeValue / 89).toFixed(2);
    this.setState({ euro: euroValue });
  }

  render() {
    return (
      <div style={{ padding: '20px', border: '1px solid #ccc', borderRadius: '8px', maxWidth: '400px' }}>
        <h2>Currency Convertor</h2>
        <h3>Indian Rupees to Euro</h3>
        <form onSubmit={this.handleSubmit}>
          <div style={{ marginBottom: '10px' }}>
            <label>Enter Amount in Rupees (₹): </label>
            <br />
            <input
              type="text"
              value={this.state.rupees}
              onChange={this.handleChange}
              placeholder="Enter amount in INR"
              style={{ padding: '8px', width: '200px', marginTop: '5px' }}
            />
          </div>
          <button type="submit" style={{ padding: '8px 20px', cursor: 'pointer' }}>
            Convert
          </button>
        </form>
        {this.state.euro && (
          <div style={{ marginTop: '15px' }}>
            <h3>Converted Value: €{this.state.euro}</h3>
            <p>₹{this.state.rupees} = €{this.state.euro}</p>
          </div>
        )}
      </div>
    );
  }
}

export default CurrencyConvertor;
