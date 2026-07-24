
# Week 5 - Additional React Hands-on Exercises (Part 2)

## Q1: cricketapp - ES6 Features in React

- **ListofPlayers**: Demonstrates `map()` method of ES6 for transforming an array of 11 player objects into JSX list items. Uses arrow functions within `filter()` to extract players scoring under 70.
- **IndianPlayers**: Demonstrates ES6 destructuring by separating odd/even team players based on array indices. Merges two separate arrays (`T20players` and `RanjiTrophyPlayers`) using the ES6 Spread Operator (`...`).
- **Conditional Rendering**: Toggles between components via an `if-else` statement evaluated against a `flag` variable.

---

## Q2: officespacerentalapp - JSX Syntax & Inline Styling

- Demonstrates JSX syntax: rendering raw elements, setting image `src` attributes dynamically, and pulling fields from a single JavaScript object (`office`).
- Uses `map()` to iterate over a list of office space objects.
- **Dynamic Inline Styling**: Sets table cell text color to red if rent is under ₹60,000 and green if rent is ₹60,000 or above using template logic.

---

## Q3: eventexamplesapp - React Events & State

- **EventExamples**:
  - Increments and decrements counter state via button click handlers.
  - Demonstrates invoking multiple functions (`increment()` and `sayHello()`) from a single event callback.
  - Demonstrates passing custom parameter strings to event handler functions (`sayWelcome('Welcome...')`).
  - Utilizes React's `SyntheticEvent` object (`onPress(event)`).
- **CurrencyConvertor**: Form submission handler (`handleSubmit`) that calculates Euro values from an Indian Rupee input field (`rupees / 89`).

---

## Q4: ticketbookingapp - Conditional Rendering

- Demonstrates conditional UI state based on user authentication status (`isLoggedIn`).
- **GuestPage**: Rendered when user is logged out (`isLoggedIn = false`). Displays flight listings with a notice to log in for booking.
- **UserPage**: Rendered when user is logged in (`isLoggedIn = true`). Displays flight booking controls.
- Login and Logout buttons update parent component state, automatically re-rendering the appropriate view.

---

## Q5: bloggerapp - Conditional Rendering Patterns & Component Keys

Implemented 3 separate components (`BookDetails`, `BlogDetails`, `CourseDetails`) demonstrating various React conditional rendering patterns:
1. **Logical `&&` Operator**: Used inside `BookDetails` to check array length before mapping.
2. **Element Variables**: Used inside `BlogDetails` to assign JSX content to a variable based on `if-else` logic before rendering.
3. **Ternary Operator (`? :`)**: Used inside `CourseDetails` for inline conditional layout evaluation.
4. **Switch Statement**: Used inside `App.js` helper method (`renderSelectedComponent()`) to filter active component views dynamically via tab buttons.
