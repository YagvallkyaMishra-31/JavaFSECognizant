import React, { Component } from 'react';
import BookDetails from './Components/BookDetails';
import BlogDetails from './Components/BlogDetails';
import CourseDetails from './Components/CourseDetails';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      selectedTab: 'all'
    };
  }

  // Way 4: Switch case conditional rendering function
  renderSelectedComponent() {
    switch (this.state.selectedTab) {
      case 'books':
        return <BookDetails />;
      case 'blogs':
        return <BlogDetails />;
      case 'courses':
        return <CourseDetails />;
      case 'all':
      default:
        return (
          <div>
            <BookDetails />
            <BlogDetails />
            <CourseDetails />
          </div>
        );
    }
  }

  render() {
    return (
      <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
        <h1>Blogger App - Conditional Rendering Ways</h1>

        <div style={{ marginBottom: '20px' }}>
          <button onClick={() => this.setState({ selectedTab: 'all' })} style={{ marginRight: '10px', padding: '8px 15px' }}>
            Show All
          </button>
          <button onClick={() => this.setState({ selectedTab: 'books' })} style={{ marginRight: '10px', padding: '8px 15px' }}>
            Book Details Only
          </button>
          <button onClick={() => this.setState({ selectedTab: 'blogs' })} style={{ marginRight: '10px', padding: '8px 15px' }}>
            Blog Details Only
          </button>
          <button onClick={() => this.setState({ selectedTab: 'courses' })} style={{ padding: '8px 15px' }}>
            Course Details Only
          </button>
        </div>

        <hr />

        {/* Rendering component dynamically based on state */}
        {this.renderSelectedComponent()}
      </div>
    );
  }
}

export default App;
