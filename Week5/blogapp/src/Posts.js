import React, { Component } from 'react';
import Post from './Post';

class Posts extends Component {

  // Step 5: Initialize component with a list of Post in state using constructor
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      isLoading: true
    };
  }

  // Step 6: loadPosts() method - uses Fetch API to get posts from jsonplaceholder
  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => response.json())
      .then(data => {
        // mapping the json data to Post objects
        const postList = data.map(
          item => new Post(item.userId, item.id, item.title, item.body)
        );
        this.setState({
          posts: postList,
          isLoading: false
        });
      })
      .catch(error => {
        console.error('Error fetching posts:', error);
        this.setState({ isLoading: false });
      });
  }

  // Step 7: componentDidMount() hook - calls loadPosts() after component mounts
  componentDidMount() {
    console.log('Posts component mounted - fetching posts...');
    this.loadPosts();
  }

  // Step 9: componentDidCatch() - displays any error as alert message
  componentDidCatch(error, info) {
    alert('An error occurred: ' + error.message);
    console.error('Component Error:', error);
    console.error('Error Info:', info);
  }

  // Step 8: render() - displays title and body of posts
  render() {
    if (this.state.isLoading) {
      return <h2>Loading posts...</h2>;
    }

    return (
      <div>
        <h1>Blog Posts</h1>
        {this.state.posts.map(post => (
          <div key={post.id} style={{ 
            border: '1px solid #ddd', 
            margin: '10px', 
            padding: '15px',
            borderRadius: '5px' 
          }}>
            <h3>{post.title}</h3>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
