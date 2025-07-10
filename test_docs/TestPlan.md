# Test Plan

## 1. Introduction

This document describes the automated testing approach for the DemoQA website using Selenium WebDriver with Java. The
goal is to ensure that key UI components behave as expected.

## 2. Scope of testing

### In Scope:

- functional testing
- positive and negative test cases

### Out of Scope:

- backend testing
- nonfunctional testing

## 3. Testing Approach

### 3.1 Type of Testing

- Automated functional UI testing
- Positive and negative test cases

### 3.2 Tools and Frameworks

- Java 17+
- Selenium WebDriver 4.x
- TestNG
- Maven
- Git

### 3.3 Entry and Exit Criteria

#### 3.3.1 Entry Criteria

- The test environment is set up and accessible (https://www.saucedemo.com)
- The required test data is available
- All test dependencies are properly installed

#### 3.3.2 Exit Criteria

- All planned test cases have been executed
- All test cases have passed
- Test results have been reviewed

## 4. Test Scenarios

### ID: TS01

**Scenario Description:** Verify login functionality

### ID: TS02

**Scenario Description:** Verify log out functionality

### ID: TS03

**Scenario Description:** Verify purchase flow functionality

## 5. Test Cases

### Test Case: TC01 - Successfully log in with sample data

- **Related Scenario:** TS01
- **Objective:** Verify that the user can log in to the website with valid input
- **Test Steps:**
    1. Navigate to https://www.saucedemo.com
    2. Enter valid credentials:
        - Username: standard_user
        - Password: secret_sauce
    3. Click "Login" button
- **Expected Result:** The user is redirected to the inventory page (`https://www.saucedemo.com/inventory.html`) and the
  product list is visible.

### Test Case: TC02 - Display error message for invalid login

- **Related Scenario:** TS01
- **Objective:** Verify that an error message is displayed when user try to log in with incorrect data
- **Test Steps:**
    1. Navigate to https://www.saucedemo.com
    2. Enter invalid credentials:
        - Username: test
        - Password: test
    3. Click "Login" button
- **Expected Result:** The website displays error message "Epic sadface: Username and password do not match any user in
  this service".

### Test Case: TC03 - Successfully logout from the website

- **Related Scenario:** TS02
- **Objective:** Verify that the user can log out from the website after successful log in
- **Test Steps:**
    1. Navigate to https://www.saucedemo.com
    2. Enter invalid credentials:
        - Username: test
        - Password: test
    3. Click "Login" button
    4. Click menu button
    5. Select "Logout" button
- **Expected Result:** The user is redirected to the login page (`https://www.saucedemo.com/`).

### Test Case: TC04 - Adding product to the cart

- **Related Scenario:** TS03
- **Objective:** Verify that the user can add product to the cart
- **Test Steps:**
    1. Navigate to https://www.saucedemo.com
    2. Log in to the application using valid credentials
    3. Add product to the cart
    4. Select cart button

- **Expected Result:** The product is displayed in the cart.

### Test Case: TC05 - Removing product from the cart

- **Related Scenario:** TS03
- **Objective:** Verify that the user can remove product from the cart
- **Test Steps:**
    1. Navigate to https://www.saucedemo.com
    2. Log in to the application using valid credentials
    3. Add product to the cart
    4. Select cart button
    5. Select "Remove" button
- **Expected Result:** The product is removed from the cart

### Test Case: TC06 - Successfully fill in all mandatory fields during checkout

- **Related Scenario:** TS03
- **Objective:** Verify that the user need to fill in all mandatory fields during checkout to see checkout overview.
- **Test Steps:**
    1. Navigate to https://www.saucedemo.com
    2. Log in to the application using valid credentials
    3. Add product to the cart
    4. Select cart button
    5. Select Checkout button
    6. Enter valid credentials:
       - First name: test
       - Last name: test
       - Postal code: test
    7. Select Continue button
- **Expected Result:** The user is redirected to the checkout: overview page (`https://www.saucedemo.com/checkout-step-two.html`) and can see order information.

### Test Case: TC07 - Verify error handling for missing checkout data

- **Related Scenario:** TS03
- **Objective:** Verify that the error message is displayed when user did not enter data during checkout.
- **Test Steps:**
    1. Navigate to https://www.saucedemo.com
    2. Log in to the application using valid credentials
    3. Add product to the cart
    4. Select cart button
    5. Select Checkout button
    6. Select Continue button and verify error message about first name
    7. Enter valid first name
    8. Select Continue button and verify error message about last name
    9. Enter valid last name
    10.  Select Continue button and verify error message about postal code
- **Expected Result:** The user receives a specific error message depending on which fields are missing.

### Test Case: TC08 - Successfully complete purchase flow

- **Related Scenario:** TS03
- **Objective:** Verify complete purchase flow from login to order confirmation
- **Test Steps:**
    1. Navigate to https://www.saucedemo.com
    2. Log in to the application using valid credentials
    3. Add product to the cart
    4. Select cart button
    5. Select Checkout button
    6. Enter valid credentials:
       - First name: test
       - Last name: test
       - Postal code: test
    7. Select Continue button
    8. Select Finish button 
- **Expected Result:** The user is redirected to the complete order page (`https://www.saucedemo.com/checkout-complete.html`) and receives information "Thank you for your order!" .

