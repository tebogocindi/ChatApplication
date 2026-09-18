/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapplication;

/**
 *
 * @author Student
 */
public class Login {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String cellPhoneNumber;

    public Login(String firstName, String lastName,
                          String userName, String password,
                          String cellPhoneNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public boolean checkUserName() {
        return userName.contains("_") && userName.length() <= 5;
    }

    public boolean checkPasswordComplexity() {

        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        if (password.length() < 8)
            return false;

        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (Character.isUpperCase(ch))
                hasCapital = true;
            else if (Character.isDigit(ch))
                hasNumber = true;
            else if (!Character.isLetterOrDigit(ch))
                hasSpecial = true;
        }

        return hasCapital && hasNumber && hasSpecial;
    }

    public boolean checkCellPhoneNumber() {
        return cellPhoneNumber.matches("\\+27\\d{9}");
    }

    public String registerUser() {

        if (checkUserName() &&
            checkPasswordComplexity() &&
            checkCellPhoneNumber()) {

            return "Registration successful.";
        }

        if (!checkUserName())
            return "Username is not correctly formatted.";

        if (!checkPasswordComplexity())
            return "Password is not correctly formatted.";

        return "Cell phone number is incorrectly formatted.";
    }

    public boolean loginUser(String enteredUserName,
                             String enteredPassword) {

        return userName.equals(enteredUserName)
                && password.equals(enteredPassword);
    }

    public String returnLoginStatus(boolean status) {

        if (status) {
            return "Welcome " + firstName + " " + lastName +
                   ", it is great to see you again.";
        }

        return "Username or password incorrect, please try again.";
    }
    public String returnLoginStatus(String enteredUsername, String enteredPassword) {

    if (loginUser(enteredUsername, enteredPassword)) {
        return "Welcome " + firstName + " " + lastName +
               ", it is great to see you again.";
    }

    return "Username or password incorrect, please try again.";
}
}