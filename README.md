# Automated Test Structure and Page Object Model (PO) Overview

This project follows the **Page Object Model (PO)** design pattern, which is a widely recognized structure in test automation. The core idea behind the PO pattern is to separate the test logic from the details of the web pages, making the tests more maintainable, reusable, and scalable.


### Core Components of the PO Design

1. **Base Page Class:**
   The `BaseWebPage` class is the foundation of the Page Object Model, and all other page classes inherit from it. This class contains the common methods used across different pages, such as:
   - Locating elements using CSS selectors or XPath.
   - Waiting for elements to be visible or clickable.
   - Performing actions like clicking, sending text, or getting the text from elements.
   - Handling scrolling and window management.

   The base class centralizes the logic for interacting with the page and avoids code repetition across multiple page classes. 

2. **Specific Page Classes:**
   Each page of the web application has its own class (e.g., `HomePage`, `PricingPage`, `ComponentsPage`), which includes methods for interacting with the elements specific to that page.

   #### Key Page Classes:
   - **HomePage**: This class defines elements and interactions found on the homepage, such as navigation buttons (e.g., "Pricing", "Components"), and ensures that the user is on the correct page.
   - **PricingPage**: Contains logic for validating the elements on the Pricing page, such as checking if all products are displayed with the "$" currency symbol. It also verifies the FAQ section, ensuring it contains the expected number of questions.
   - **ComponentsPage**: Contains logic for the "Many types of components" section, where we verify that each component card displays the "Visit" button. Additionally, it validates the visibility of the "Sign Up" button and its color.

3. **Test Cases:**
   Each test case is designed to verify specific functionality of the application by interacting with the methods defined in the page classes. The tests encapsulate the page interactions and validate if the application works as expected.

   #### Example Test Case Logic:
   - **Currency Symbol Test** (PricingPage):
     - The test checks that every product's price on the Pricing page includes the "$" currency symbol. This is done by verifying all price elements for the presence of "$".
   
   - **FAQ Section Test** (PricingPage):
     - This test ensures that the FAQ section on the Pricing page contains exactly four questions. It extracts the question elements and verifies their count.

   - **Button Visibility Test** (ComponentsPage):
     - The test checks that each component card in the "Many types of components" section has a "Visit" button. It finds all cards and verifies the presence of the button on each one.

### Key Logic and Flow

- **Page Classes**: Each page class is responsible for defining elements (e.g., buttons, links, sections) and actions (e.g., clicking, checking visibility). These page objects represent the user interface of the application.
  
- **Test Actions**: The test actions leverage the page classes to perform operations such as clicking a button or verifying the presence of an element on the page. The main goal is to isolate the test logic from direct interactions with the UI.

- **Reusability**: The PO design pattern allows you to reuse page methods across different tests. For example, a method like `clickPricingButton()` can be used across multiple tests that need to navigate to the Pricing page. This reduces duplication and enhances code maintainability.

## Example of Test Flow

Let's take an example of a simple test:

1. **Test Case for Checking Currency Symbol on the Pricing Page:**
   - **Given** the Framer website is loaded.
   - **When** the user clicks on the 'Pricing' button.
   - **Then** the user should see all prices on the Pricing page displaying the "$" currency symbol.

   In the test, the method `doAllProductsContainDollarSymbol()` from the `PricingPage` class is invoked, which checks if all elements containing price information have the "$" symbol.

2. **Test Case for Button Visibility in the Components Section:**
   - **Given** the Framer website is loaded and scrolled to the 'Many types of components to customize' section.
   - **When** the user checks each card in this section.
   - **Then** each card should contain a "Visit" button.

   This is validated by the `doAllCardsHaveVisitButton()` method in the `ComponentsPage` class, ensuring each component card has the "Visit" button.

## Test Requirements

### 1. Displays products' currency symbol as '$' in the 'Pricing' page
- **Given** the Framer site is loaded  
- **When** I click on the 'Pricing' button  
- **Then** I see the products' currency symbol displayed as '$' on the 'Pricing' page

   **Implementation**:  
   This requirement is covered by the `doAllProductsContainDollarSymbol()` method in the `PricingPage`. It validates that all the price elements contain the `$` symbol by checking all the price items in the Pricing section.

### 2. Contains 4 questions in the FAQ section on the 'Pricing' page
- **Given** the Framer site is loaded  
- **When** I click on the 'Pricing' button  
- **Then** I see the FAQ section contains exactly 4 questions

   **Implementation**:  
   This is checked by the `getNumberOfQuestionsWithQuestionMark()` method in the `PricingPage`. It retrieves all questions from the FAQ section and verifies that there are exactly 4 questions, each ending with a `?`.

### 3. Displays 'visit' button on each card in the 'Many types of components to customize' section
- **Given** the Framer site is loaded  
- **When** I scroll to the 'Many types of components to customize' section on the components page  
- **Then** I see the 'Visit' button displayed on each card

   **Implementation**:  
   The `doAllCardsHaveVisitButton()` method in the `ComponentsPage` checks if every card in the 'Many types of components' section has a "Visit" button by verifying each card for the presence of this button.

### 4. Displays 'Sign Up' button's color as 'rgb(255, 82, 79)'
- **Given** the Framer site is loaded  
- **When** I scroll to the bottom of the components page and see the 'Sign Up' button in the subscribe section  
- **Then** I see the 'Sign Up' button's color as `rgb(255, 82, 79)`

   **Implementation**:  
   The `getSignUpButtonColor()` method in the `ComponentsPage` checks the color of the "Sign Up" button and ensures it matches the expected RGB value (`rgb(255, 82, 79)`).

### 5. Blurs the background after clicking the 'Get the app' button
- **Given** the Framer site is loaded  
- **When** I click the 'Get the app' button  
- **Then** I see the background is blurred

   **Implementation**:  
   The `clickGetAppButton()` method in the `HomePage` class simulates the click on the 'Get the app' button, which triggers the background blur effect.

### 6. Displays the 'Updates' page after clicking the 'Update' button
- **Given** the Framer site is loaded  
- **When** I click on the 'Updates' button  
- **Then** I see the Updates page is displayed

   **Implementation**:  
   The `clickUpdatesButton()` method in the `HomePage` class simulates clicking on the 'Updates' button and verifies that the Updates page is displayed.

### 7. Displays 'get the app' and 'watch video' buttons one above the other on mobile
- **Given** the Framer site is loaded on mobile  
- **Then** I see the 'Get the app' and 'Watch video' buttons displayed one above the other

   **Implementation**:  
   The `areButtonsStackedVertically()` method in the `HomePage` class checks the positioning of the buttons on mobile, ensuring they are displayed vertically stacked.

### 8. Displays 3D animation after clicking the 'Click to view in 3D' button
- **Given** the Framer site is loaded  
- **When** I hover over the 3D and 2D design with Framer's image  
- **And** I click on 'Click to view in 3D'  
- **Then** I see the 3D animation displayed

   **Implementation**:  
   Unfortunately, this specific test was not yet implemented in the code.
