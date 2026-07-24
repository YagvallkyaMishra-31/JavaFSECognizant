import React, { Component } from 'react';

class ListofPlayers extends Component {
  render() {
    // Declaring an array with 11 players using map feature of ES6
    const players = [
      { name: 'Virat Kohli', score: 82 },
      { name: 'Rohit Sharma', score: 95 },
      { name: 'KL Rahul', score: 45 },
      { name: 'Shubman Gill', score: 78 },
      { name: 'Hardik Pandya', score: 55 },
      { name: 'Ravindra Jadeja', score: 42 },
      { name: 'Rishabh Pant', score: 88 },
      { name: 'Jasprit Bumrah', score: 15 },
      { name: 'Mohammed Shami', score: 30 },
      { name: 'Yuzvendra Chahal', score: 22 },
      { name: 'Suryakumar Yadav', score: 91 }
    ];

    // Using map() to display player details
    const playerList = players.map((player, index) => (
      <li key={index}>
        {player.name} - Score: {player.score}
      </li>
    ));

    // Filter players with scores below 70 using arrow functions of ES6
    const belowSeventy = players.filter((player) => player.score < 70);

    const filteredList = belowSeventy.map((player, index) => (
      <li key={index}>
        {player.name} - Score: {player.score}
      </li>
    ));

    return (
      <div>
        <h2>List of All Players</h2>
        <ul>{playerList}</ul>

        <h2>Players with Score Below 70</h2>
        <ul>{filteredList}</ul>
      </div>
    );
  }
}

export default ListofPlayers;
