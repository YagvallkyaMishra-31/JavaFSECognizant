import React from 'react';

function CourseDetails(props) {
  const courses = [
    { id: 201, name: 'Full Stack Java Engineering', duration: '12 Weeks' },
    { id: 202, name: 'Frontend Web Development with React', duration: '8 Weeks' }
  ];

  return (
    <div style={{ border: '1px solid #FF9800', padding: '15px', borderRadius: '8px', margin: '10px 0' }}>
      <h3>Course Details Component</h3>
      {/* Way 3: Ternary Operator Conditional Rendering */}
      {courses.length > 0 ? (
        <ul>
          {courses.map((course) => (
            <li key={course.id}>
              <strong>{course.name}</strong> - Duration: {course.duration}
            </li>
          ))}
        </ul>
      ) : (
        <p>No active courses found.</p>
      )}
    </div>
  );
}

export default CourseDetails;
