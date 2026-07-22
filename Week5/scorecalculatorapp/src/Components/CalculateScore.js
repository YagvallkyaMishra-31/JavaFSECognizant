import React from 'react';
import '../Stylesheets/mystyle.css';

// CalculateScore is a function component that accepts student details as props
// and calculates the average score
function CalculateScore(props) {
  // calculating average score
  const average = props.total / props.goal;
  const percentage = (average * 100).toFixed(2);

  return (
    <div className="student-card">
      <h2>Student Score Calculator</h2>
      <table>
        <tbody>
          <tr>
            <td><strong>Name:</strong></td>
            <td>{props.name}</td>
          </tr>
          <tr>
            <td><strong>School:</strong></td>
            <td>{props.school}</td>
          </tr>
          <tr>
            <td><strong>Total Score:</strong></td>
            <td>{props.total}</td>
          </tr>
          <tr>
            <td><strong>Goal:</strong></td>
            <td>{props.goal}</td>
          </tr>
          <tr>
            <td><strong>Average Score:</strong></td>
            <td>{average.toFixed(2)}</td>
          </tr>
          <tr>
            <td><strong>Percentage:</strong></td>
            <td>{percentage}%</td>
          </tr>
        </tbody>
      </table>
      <p className={average >= 50 ? 'pass' : 'fail'}>
        {average >= 50 ? 'Result: PASS' : 'Result: FAIL'}
      </p>
    </div>
  );
}

export default CalculateScore;
