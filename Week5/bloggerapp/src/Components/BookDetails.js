import React from 'react';

function BookDetails(props) {
  const books = [
    { id: 101, title: 'Mastering React', author: 'John Doe', price: 550 },
    { id: 102, title: 'Java FSE Handbook', author: 'Jane Smith', price: 650 },
    { id: 103, title: 'Spring Boot Microservices', author: 'Robert Brown', price: 720 }
  ];

  return (
    <div style={{ border: '1px solid #4CAF50', padding: '15px', borderRadius: '8px', margin: '10px 0' }}>
      <h3>Book Details Component</h3>
      {/* Way 1: Logical && operator for list rendering */}
      {books.length > 0 && (
        <ul>
          {books.map((book) => (
            <li key={book.id}>
              <strong>{book.title}</strong> by {book.author} - ₹{book.price}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}

export default BookDetails;
