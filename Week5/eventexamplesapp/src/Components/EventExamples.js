import React, { Component } from 'react';

class EventExamples extends Component {
  constructor(props) {
    super(props);
    this.state = {
      counter: 0,
      message: ''
    };
    // Binding methods to this
    this.increment = this.increment.bind(this);
    this.sayHello = this.sayHello.bind(this);
    this.decrement = this.decrement.bind(this);
    this.sayWelcome = this.sayWelcome.bind(this);
    this.onPress = this.onPress.bind(this);
  }

  // Method to increment the counter value
  increment() {
    this.setState((prevState) => ({
      counter: prevState.counter + 1
    }));
  }

  // Method to say hello with a static message
  sayHello() {
    this.setState({
      message: 'Hello! The counter has been incremented successfully.'
    });
  }

  // Method to decrement the counter value
  decrement() {
    this.setState((prevState) => ({
      counter: prevState.counter - 1
    }));
  }

  // Function which takes "welcome" as an argument
  sayWelcome(msg) {
    alert(msg);
  }

  // Synthetic event handler
  onPress(event) {
    // event here is a synthetic event provided by React
    alert('I was clicked');
    console.log('Synthetic Event Type:', event.type);
  }

  render() {
    return (
      <div style={{ padding: '20px' }}>
        <h2>Event Handling Examples</h2>

        {/* 1. Increment button invokes multiple methods */}
        <h3>Counter: {this.state.counter}</h3>
        <button onClick={() => { this.increment(); this.sayHello(); }}
          style={{ padding: '8px 16px', marginRight: '10px', cursor: 'pointer' }}>
          Increment
        </button>
        <button onClick={this.decrement}
          style={{ padding: '8px 16px', cursor: 'pointer' }}>
          Decrement
        </button>
        <p>{this.state.message}</p>

        <hr />

        {/* 2. Button which takes "welcome" as argument */}
        <button onClick={() => this.sayWelcome('Welcome to React Event Handling!')}
          style={{ padding: '8px 16px', cursor: 'pointer' }}>
          Say Welcome
        </button>

        <hr />

        {/* 3. Button with synthetic event */}
        <button onClick={this.onPress}
          style={{ padding: '8px 16px', cursor: 'pointer' }}>
          Click Me (Synthetic Event)
        </button>
      </div>
    );
  }
}

export default EventExamples;
