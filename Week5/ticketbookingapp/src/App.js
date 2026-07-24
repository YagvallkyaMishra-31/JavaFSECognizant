import React, { Component } from 'react';

// GuestPage - displayed when user is not logged in
function GuestPage() {
  const flights = [
    { id: 1, flight: 'AI-101', from: 'Delhi', to: 'Mumbai', time: '06:00 AM', price: 4500 },
    { id: 2, flight: 'SG-202', from: 'Bangalore', to: 'Chennai', time: '08:30 AM', price: 3200 },
    { id: 3, flight: 'UK-303', from: 'Kolkata', to: 'Hyderabad', time: '11:00 AM', price: 5100 },
    { id: 4, flight: 'AI-404', from: 'Mumbai', to: 'Delhi', time: '02:00 PM', price: 4800 }
  ];

  return (
    <div>
      <h2>Welcome Guest!</h2>
      <p>Please login to book tickets. You can browse the available flights below:</p>
      <table style={{ width: '100%', borderCollapse: 'collapse', marginTop: '10px' }}>
        <thead>
          <tr style={{ backgroundColor: '#333', color: 'white' }}>
            <th style={{ padding: '10px', border: '1px solid #ddd' }}>Flight</th>
            <th style={{ padding: '10px', border: '1px solid #ddd' }}>From</th>
            <th style={{ padding: '10px', border: '1px solid #ddd' }}>To</th>
            <th style={{ padding: '10px', border: '1px solid #ddd' }}>Time</th>
            <th style={{ padding: '10px', border: '1px solid #ddd' }}>Price (₹)</th>
          </tr>
        </thead>
        <tbody>
          {flights.map((f) => (
            <tr key={f.id}>
              <td style={{ padding: '10px', border: '1px solid #ddd' }}>{f.flight}</td>
              <td style={{ padding: '10px', border: '1px solid #ddd' }}>{f.from}</td>
              <td style={{ padding: '10px', border: '1px solid #ddd' }}>{f.to}</td>
              <td style={{ padding: '10px', border: '1px solid #ddd' }}>{f.time}</td>
              <td style={{ padding: '10px', border: '1px solid #ddd' }}>₹{f.price}</td>
            </tr>
          ))}
        </tbody>
      </table>
      <p style={{ color: 'red', marginTop: '10px' }}>* Login to book tickets</p>
    </div>
  );
}

// UserPage - displayed when user is logged in, can book tickets
function UserPage() {
  return (
    <div>
      <h2>Welcome User! You are logged in.</h2>
      <p>You can now book your flight tickets.</p>
      <div style={{ border: '1px solid green', padding: '20px', borderRadius: '8px', marginTop: '10px' }}>
        <h3>Book Your Ticket</h3>
        <form>
          <div style={{ marginBottom: '10px' }}>
            <label>From: </label>
            <select style={{ padding: '5px', marginLeft: '10px' }}>
              <option>Delhi</option>
              <option>Mumbai</option>
              <option>Bangalore</option>
              <option>Chennai</option>
            </select>
          </div>
          <div style={{ marginBottom: '10px' }}>
            <label>To: </label>
            <select style={{ padding: '5px', marginLeft: '25px' }}>
              <option>Mumbai</option>
              <option>Delhi</option>
              <option>Hyderabad</option>
              <option>Kolkata</option>
            </select>
          </div>
          <div style={{ marginBottom: '10px' }}>
            <label>Date: </label>
            <input type="date" style={{ padding: '5px', marginLeft: '10px' }} />
          </div>
          <button type="button" style={{ padding: '8px 20px', backgroundColor: 'green', color: 'white', border: 'none', borderRadius: '4px', cursor: 'pointer' }}>
            Book Now
          </button>
        </form>
      </div>
    </div>
  );
}

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      isLoggedIn: false
    };
    this.handleLogin = this.handleLogin.bind(this);
    this.handleLogout = this.handleLogout.bind(this);
  }

  handleLogin() {
    this.setState({ isLoggedIn: true });
  }

  handleLogout() {
    this.setState({ isLoggedIn: false });
  }

  render() {
    const isLoggedIn = this.state.isLoggedIn;
    let button;

    // Conditional rendering - Login/Logout button
    if (isLoggedIn) {
      button = (
        <button onClick={this.handleLogout}
          style={{ padding: '10px 20px', backgroundColor: 'red', color: 'white', border: 'none', borderRadius: '4px', cursor: 'pointer', fontSize: '16px' }}>
          Logout
        </button>
      );
    } else {
      button = (
        <button onClick={this.handleLogin}
          style={{ padding: '10px 20px', backgroundColor: 'blue', color: 'white', border: 'none', borderRadius: '4px', cursor: 'pointer', fontSize: '16px' }}>
          Login
        </button>
      );
    }

    return (
      <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
        <h1>Flight Ticket Booking App</h1>
        {button}
        <hr />
        {/* Conditional rendering - show UserPage or GuestPage */}
        {isLoggedIn ? <UserPage /> : <GuestPage />}
      </div>
    );
  }
}

export default App;
