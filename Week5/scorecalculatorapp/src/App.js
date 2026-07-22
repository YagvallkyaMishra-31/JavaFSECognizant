import React from 'react';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <div>
      <h1>Score Calculator App</h1>
      <CalculateScore
        name="Yash Mishra"
        school="Cognizant Academy"
        total={432}
        goal={6}
      />
      <CalculateScore
        name="Rahul Kumar"
        school="Delhi Public School"
        total={375}
        goal={5}
      />
    </div>
  );
}

export default App;
