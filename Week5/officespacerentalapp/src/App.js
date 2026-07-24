import React, { Component } from 'react';

class App extends Component {
  render() {
    // Creating an element to display the heading
    const heading = <h1>Office Space Rental</h1>;

    // Attribute to display image of the office space
    const imageUrl = 'https://images.unsplash.com/photo-1497366216548-37526070297c?w=600';

    // Creating an object of office to display details
    const office = {
      name: 'Cognizant Tech Hub',
      rent: 75000,
      address: 'SIPCOT IT Park, Siruseri, Chennai - 603103'
    };

    // Creating a list of office space objects
    const officeSpaces = [
      { id: 1, name: 'Cognizant Tech Hub', rent: 75000, address: 'SIPCOT IT Park, Chennai' },
      { id: 2, name: 'WeWork Prestige', rent: 55000, address: 'Prestige Tech Park, Bangalore' },
      { id: 3, name: 'Regus Business Center', rent: 45000, address: 'Bandra Kurla Complex, Mumbai' },
      { id: 4, name: 'IndiQube Edge', rent: 62000, address: 'Whitefield, Bangalore' },
      { id: 5, name: 'Smartworks Coworking', rent: 38000, address: 'Sector 44, Gurgaon' },
      { id: 6, name: 'Awfis Space Solutions', rent: 80000, address: 'Connaught Place, New Delhi' }
    ];

    return (
      <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
        {/* Displaying the heading element */}
        {heading}

        {/* Displaying the office image using attribute */}
        <img
          src={imageUrl}
          alt="Office Space"
          style={{ width: '600px', height: '300px', borderRadius: '10px', objectFit: 'cover' }}
        />

        {/* Displaying single office object details */}
        <h2>Featured Office Space</h2>
        <div style={{ border: '1px solid #ccc', padding: '15px', borderRadius: '8px', marginBottom: '20px' }}>
          <h3>{office.name}</h3>
          <p><strong>Rent:</strong>{' '}
            <span style={{ color: office.rent < 60000 ? 'red' : 'green', fontWeight: 'bold' }}>
              ₹{office.rent}/month
            </span>
          </p>
          <p><strong>Address:</strong> {office.address}</p>
        </div>

        {/* Looping through the list of office space items */}
        <h2>Available Office Spaces</h2>
        <table style={{ width: '100%', borderCollapse: 'collapse' }}>
          <thead>
            <tr style={{ backgroundColor: '#333', color: 'white' }}>
              <th style={{ padding: '10px', border: '1px solid #ddd' }}>ID</th>
              <th style={{ padding: '10px', border: '1px solid #ddd' }}>Name</th>
              <th style={{ padding: '10px', border: '1px solid #ddd' }}>Rent</th>
              <th style={{ padding: '10px', border: '1px solid #ddd' }}>Address</th>
            </tr>
          </thead>
          <tbody>
            {officeSpaces.map((item) => (
              <tr key={item.id}>
                <td style={{ padding: '10px', border: '1px solid #ddd' }}>{item.id}</td>
                <td style={{ padding: '10px', border: '1px solid #ddd' }}>{item.name}</td>
                {/* CSS: Red if rent below 60000, Green if above 60000 */}
                <td style={{
                  padding: '10px',
                  border: '1px solid #ddd',
                  color: item.rent < 60000 ? 'red' : 'green',
                  fontWeight: 'bold'
                }}>
                  ₹{item.rent}
                </td>
                <td style={{ padding: '10px', border: '1px solid #ddd' }}>{item.address}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default App;
