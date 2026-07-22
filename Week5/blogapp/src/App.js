import React, { Component } from 'react';
import Posts from './Posts';

// Step 10: Add Posts component to App component
class App extends Component {
  render() {
    return (
      <div>
        <Posts />
      </div>
    );
  }
}

export default App;
