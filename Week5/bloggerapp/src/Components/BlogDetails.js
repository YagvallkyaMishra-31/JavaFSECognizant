import React from 'react';

function BlogDetails(props) {
  const blogs = [
    { id: 1, name: 'React 18 Features', author: 'Dan Abramov', likes: 1200 },
    { id: 2, name: 'Understanding ES6 Syntaxes', author: 'Kyle Simpson', likes: 980 }
  ];

  // Way 2: Element Variables for conditional rendering
  let content;
  if (blogs && blogs.length > 0) {
    content = (
      <ul>
        {blogs.map((blog) => (
          <li key={blog.id}>
            <strong>{blog.name}</strong> (Author: {blog.author}) - {blog.likes} Likes
          </li>
        ))}
      </ul>
    );
  } else {
    content = <p>No blogs available right now.</p>;
  }

  return (
    <div style={{ border: '1px solid #2196F3', padding: '15px', borderRadius: '8px', margin: '10px 0' }}>
      <h3>Blog Details Component</h3>
      {content}
    </div>
  );
}

export default BlogDetails;
