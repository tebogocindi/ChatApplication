/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.messageapp;

/**
 *
 * @author Student
 */

import java.util.Scanner;

public class ChatApplication {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("           QUICKCHAT APPLICATION");
        System.out.println("========================================");

        Login user;

        // STEP 1: REGISTRATION
        while (true) {
            System.out.println("\n---------- REGISTRATION ----------");

            System.out.print("Enter first name: ");
            String firstName = input.nextLine();

            System.out.print("Enter last name: ");
            String lastName = input.nextLine();

            System.out.print(
                    "Enter username (underscore, maximum 5 characters): ");
            String userName = input.nextLine();

            System.out.print(
                    "Enter password (8+ characters, capital, number, special): ");
            String password = input.nextLine();

            System.out.print(
                    "Enter cellphone number (+27 followed by 9 digits): ");
            String cellPhoneNumber = input.nextLine();

            user = new Login(
                    firstName,
                    lastName,
                    userName,
                    password,
                    cellPhoneNumber
            );

            boolean validUsername = user.checkUserName();
            boolean validPassword = user.checkPasswordComplexity();
            boolean validCellphone = user.checkCellPhoneNumber();

            if (validUsername) {
                System.out.println("Username successfully captured.");
            } else {
                System.out.println(
                        "Username must contain an underscore "
                        + "and be no more than 5 characters.");
            }

            if (validPassword) {
                System.out.println("Password successfully captured.");
            } else {
                System.out.println(
                        "Password must have at least 8 characters, "
                        + "a capital letter, a number and a special character.");
            }

            if (validCellphone) {
                System.out.println("Cellphone number successfully captured.");
            } else {
                System.out.println(
                        "Cellphone number must use +27 followed by 9 digits.");
            }

            if (validUsername && validPassword && validCellphone) {
                System.out.println(user.registerUser());
                break;
            }

            System.out.println(
                    "\nRegistration failed. Please enter your details again.");
        }

        // STEP 2: LOGIN
        System.out.println("\n========================================");
        System.out.println("                 LOGIN");
        System.out.println("========================================");

        while (true) {
            System.out.print("Enter username: ");
            String enteredUsername = input.nextLine();

            System.out.print("Enter password: ");
            String enteredPassword = input.nextLine();

            boolean loggedIn = user.loginUser(
                    enteredUsername, enteredPassword);

            System.out.println(user.returnLoginStatus(
                    enteredUsername, enteredPassword));

            if (loggedIn) {
                break;
            }
        }

        // STEP 3: MESSAGING
        System.out.println("\nWelcome to QuickChat.");

        MessageApp.runMessages(input);

        System.out.println("\n========================================");
        System.out.println(" Thank you for using QuickChat.");
        System.out.println(" Goodbye!");
        System.out.println("========================================");

        input.close();
    }
}