import React, { Component } from 'react';
import ListofPlayers from './Components/ListofPlayers';
import IndianPlayers from './Components/IndianPlayers';

class App extends Component {
  render() {
    // Using a simple flag variable with if-else to toggle between components
    // Set flag = true to show ListofPlayers, flag = false to show IndianPlayers
    const flag = true;

    if (flag) {
      return (
        <div>
          <h1>Cricket App - Player Details</h1>
          <ListofPlayers />
        </div>
      );
    } else {
      return (
        <div>
          <h1>Cricket App - Indian Players</h1>
          <IndianPlayers />
        </div>
      );
    }
  }
}

export default App;
