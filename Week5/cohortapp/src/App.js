import React, { Component } from 'react';
import CohortDetails from './CohortDetails';

class App extends Component {
  render() {
    return (
      <div style={{ padding: '20px' }}>
        <h1>My Academy - Cohort Dashboard</h1>
        <CohortDetails
          name="Java FSE Cohort 1"
          technology="Java Full Stack"
          startDate="01-Jun-2026"
          endDate="30-Aug-2026"
          status="ongoing"
          participants={35}
        />
        <CohortDetails
          name="React Cohort 3"
          technology="React.js"
          startDate="15-Mar-2026"
          endDate="15-May-2026"
          status="completed"
          participants={28}
        />
        <CohortDetails
          name="Angular Cohort 2"
          technology="Angular"
          startDate="01-Jul-2026"
          endDate="30-Sep-2026"
          status="ongoing"
          participants={30}
        />
        <CohortDetails
          name="Python ML Cohort 1"
          technology="Python & ML"
          startDate="01-Jan-2026"
          endDate="28-Feb-2026"
          status="completed"
          participants={22}
        />
      </div>
    );
  }
}

export default App;
