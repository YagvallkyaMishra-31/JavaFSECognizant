import React, { Component } from 'react';

class IndianPlayers extends Component {
  render() {
    // Using Destructuring feature of ES6 to separate odd and even team players
    const allPlayers = [
      'Virat Kohli', 'Rohit Sharma', 'KL Rahul', 'Shubman Gill',
      'Hardik Pandya', 'Ravindra Jadeja', 'Rishabh Pant', 'Jasprit Bumrah',
      'Mohammed Shami', 'Yuzvendra Chahal', 'Suryakumar Yadav'
    ];

    // Destructuring - separating odd and even indexed players
    const oddTeam = allPlayers.filter((player, index) => index % 2 !== 0);
    const evenTeam = allPlayers.filter((player, index) => index % 2 === 0);

    // Declaring two arrays and merging using Spread operator (ES6 Merge feature)
    const T20players = ['Suryakumar Yadav', 'Rishabh Pant', 'Hardik Pandya', 'Jasprit Bumrah'];
    const RanjiTrophyPlayers = ['Cheteshwar Pujara', 'Ajinkya Rahane', 'Hanuma Vihari', 'Jaydev Unadkat'];

    // Merging two arrays using spread operator
    const mergedPlayers = [...T20players, ...RanjiTrophyPlayers];

    return (
      <div>
        <h2>Odd Team Players</h2>
        <ul>
          {oddTeam.map((player, index) => (
            <li key={index}>{player}</li>
          ))}
        </ul>

        <h2>Even Team Players</h2>
        <ul>
          {evenTeam.map((player, index) => (
            <li key={index}>{player}</li>
          ))}
        </ul>

        <h2>T20 Players</h2>
        <ul>
          {T20players.map((player, index) => (
            <li key={index}>{player}</li>
          ))}
        </ul>

        <h2>Ranji Trophy Players</h2>
        <ul>
          {RanjiTrophyPlayers.map((player, index) => (
            <li key={index}>{player}</li>
          ))}
        </ul>

        <h2>Merged Players (T20 + Ranji Trophy)</h2>
        <ul>
          {mergedPlayers.map((player, index) => (
            <li key={index}>{player}</li>
          ))}
        </ul>
      </div>
    );
  }
}

export default IndianPlayers;
