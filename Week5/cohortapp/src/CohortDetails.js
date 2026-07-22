import React, { Component } from 'react';
// Step 8: Import the CSS Module
import styles from './CohortDetails.module.css';

class CohortDetails extends Component {
  render() {
    const { name, technology, startDate, endDate, status, participants } = this.props;

    // Step 10: Define inline style for h3 based on cohort status
    // green color for "ongoing", blue for all other scenarios
    const headingStyle = {
      color: status === 'ongoing' ? 'green' : 'blue'
    };

    return (
      // Step 9: Apply box class from CSS Module to container div
      <div className={styles.box}>
        <h3 style={headingStyle}>{name}</h3>
        <dl>
          <dt>Technology</dt>
          <dd>{technology}</dd>
          <dt>Start Date</dt>
          <dd>{startDate}</dd>
          <dt>End Date</dt>
          <dd>{endDate}</dd>
          <dt>Status</dt>
          <dd>{status}</dd>
          <dt>Participants</dt>
          <dd>{participants}</dd>
        </dl>
      </div>
    );
  }
}

export default CohortDetails;
