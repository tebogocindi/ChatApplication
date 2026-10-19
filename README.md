# Chat Application (Part 1)

**Student:** Tebogo Calvin Cindi
**Module:** Programming 1A 5121
**Language:** Java
**IDE:** NetBeans (Maven Project)

This project is a Java console application that allows a user to register and log into a chat application. The main focus of Part 1 is validating user input before an account can be created. The program checks the username, password, and South African cellphone number against specific rules, then allows the user to log in using the registered details.

The project was developed using object-oriented programming principles by separating the user interface from the validation logic.

## Program Features

* Register a new user

* Validate username format

* Validate password complexity

* Validate South African cellphone number

* Authenticate user login

* Display appropriate success and error messages

* Unit testing with JUnit 5
  
## File Descriptions

### ChatApplication.java

This is the entry point of the program. It interacts with the user by collecting registration details, displaying validation results, and handling the login process. The class mainly controls the flow of the application.

### Login.java

This class contains all the business logic. Each validation has its own method, making the code easier to read and reuse.

The methods include:

* `checkUserName()` – validates the username.

* `checkPasswordComplexity()` – checks password strength.

* `checkCellPhoneNumber()` – verifies the cellphone format.

* `registerUser()` – confirms whether registration is successful.

* `loginUser()` – compares stored and entered login details.

* `returnLoginStatus()` – returns the final login message.

### LoginTest.java

This class contains JUnit 5 tests for every major function in the application. Both valid and invalid inputs are tested to ensure the methods behave as expected.

## How to Run

1. Open the project in NetBeans.

2. Build the Maven project.

3. Run `ChatApplication.java`.

4. Enter registration details.

5. Log in with the same username and password.

## Example

**Registration**

* First Name: Calvin

* Last Name: Cindi

* Username: ab_cd

* Password: Password1!

* Cell Number: +27831234567

**Output**

* Username successfully captured.

* Password successfully captured.

* Cellphone number successfully captured.

* User has been registered successfully.

After entering the correct login details, the program displays a personalised welcome message.

## Testing

JUnit 5 was used to test the application's functionality. The tests verify:

* Valid and invalid usernames

* Valid and invalid passwords

* Valid and invalid cellphone numbers

* Successful and unsuccessful login attempts

* Correct login status messages

## Conclusion

This project demonstrates the use of classes, objects, constructors, methods, conditional statements, regular expressions, and unit testing in Java. The application is structured so that the main class manages user interaction while the `Login` class handles validation and au
thentication logic.
now we just did part 2 of the poe and added new files for the project

