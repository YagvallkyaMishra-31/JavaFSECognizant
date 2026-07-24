import React, { Component } from 'react';
import EventExamples from './Components/EventExamples';
import CurrencyConvertor from './Components/CurrencyConvertor';

class App extends Component {
  render() {
    return (
      <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
        <h1>Event Examples App</h1>
        <EventExamples />
        <hr />
        <CurrencyConvertor />
      </div>
    );
  }
}

export default App;
