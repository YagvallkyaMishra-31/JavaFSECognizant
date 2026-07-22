# Week 5 - React Hands-on Exercises

## Q1: myfirstreact - Setting up React Environment

- Created a new React app using `npx create-react-app myfirstreact`
- Replaced the default App.js content with a simple class component
- Displays "Welcome to the first session of React" as an h1 heading
- Ran using `npm start` and tested at http://localhost:3000

### Key Concepts Covered:
- SPA (Single Page Application) vs MPA (Multi Page Application)
- React Virtual DOM - React keeps a lightweight copy of the real DOM in memory. When state changes, 
  it compares the virtual DOM with real DOM (diffing) and only updates what changed
- Features of React: Component based, JSX, Virtual DOM, One way data binding, Performance

---

## Q2: StudentApp - Class Components

- Created three class components: Home, About, Contact
- Each component is in separate file under src/Components/ folder
- All components are imported and rendered in App.js
- This shows how to break an application into reusable components

### Key Concepts:
- Class components extend React.Component
- Each component has a render() method that returns JSX
- Components are reusable and independent pieces of UI
- Components can be imported and composed together in parent components

---

## Q3: scorecalculatorapp - Function Components & Props

- Created a function component called CalculateScore
- The component accepts props: name, school, total, goal
- It calculates average score = total / goal
- Applied CSS styling using a separate stylesheet (mystyle.css)

### Key Concepts:
- Function components are simpler than class components
- Props are used to pass data from parent to child components
- CSS can be imported directly into React components
- Function components don't have lifecycle methods (use hooks instead)

---

## Q4: blogapp - Component Lifecycle

- Created a Post class to represent blog post data
- Created Posts class component with lifecycle hooks
- Used Fetch API to get posts from https://jsonplaceholder.typicode.com/posts
- Implemented componentDidMount() to fetch data after component mounts
- Implemented componentDidCatch() for error handling

### Key Lifecycle Methods:
1. **constructor()** - Initialize state with empty posts array
2. **componentDidMount()** - Called once after first render, good place for API calls
3. **render()** - Returns JSX to display, called whenever state/props change
4. **componentDidCatch()** - Error boundary, catches errors in child components

### Lifecycle Order:
constructor → render → componentDidMount → (state update) → render again

---

## Q5: cohortapp - CSS Modules & Styling

- Created a cohort dashboard to display ongoing and completed cohort details
- Used CSS Modules (CohortDetails.module.css) for scoped styling
- Defined a "box" class with specific dimensions, border, padding, margin
- Applied conditional inline styles: green for "ongoing" status, blue for "completed"

### Key Concepts:
- CSS Modules create locally scoped class names to avoid conflicts
- Import CSS modules as objects: `import styles from './file.module.css'`
- Apply using `className={styles.box}` instead of regular string
- Inline styles use JavaScript objects with camelCase properties
- Conditional styling can be done with ternary operator in JSX

### CSS Module Properties for .box:
- width: 300px, display: inline-block
- margin: 10px (overall)
- padding: 10px 20px (top-bottom, left-right)
- border: 1px solid black
- border-radius: 10px

---

## How to Run Any App

```bash
cd <app-folder>
npm install
npm start
```
Then open http://localhost:3000 in browser.
