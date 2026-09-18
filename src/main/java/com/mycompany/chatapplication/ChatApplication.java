/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapplication;

/**
 *
 * @author Student
 */

import java.util.Scanner;

public class ChatApplication {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("=================================================");
        System.out.println("             CHAT APPLICATION");
        System.out.println("=================================================");
        System.out.println(" Welcome to the User Registration System");
        System.out.println(" Please enter your details to create an account.");
        System.out.println("=================================================\n");

        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        System.out.print("Enter username: ");
        String userName = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        System.out.print("Enter cellphone number (+27...): ");
        String cell = input.nextLine();

        Login user = new Login(firstName, lastName, userName, password, cell);

        // Username validation
        if (user.checkUserName()) {
            System.out.println("Username successfully captured.");
        } else {
            System.out.println("Username is not correctly formatted.");
        }

        // Password validation
        if (user.checkPasswordComplexity()) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println("Password is not correctly formatted.");
        }

        // Cell number validation
        if (user.checkCellPhoneNumber()) {
            System.out.println("Cellphone number successfully captured.");
        } else {
            System.out.println("Cellphone number incorrectly formatted.");
        }

        // Only continue if all validations pass
        if (user.checkUserName()
                && user.checkPasswordComplexity()
                && user.checkCellPhoneNumber()) {

            System.out.println("\nUser has been registered successfully.");

            System.out.println("\n------ LOGIN ------");

            System.out.print("Username: ");
            String loginUser = input.nextLine();

            System.out.print("Password: ");
            String loginPass = input.nextLine();

            System.out.println(user.returnLoginStatus(loginUser, loginPass));

        } else {
            System.out.println("\nRegistration failed. Please correct your details.");
        }
        
            System.out.println("\n========================================");
            System.out.println(" Thank you for using Chat Application");
            System.out.println("           Goodbye!");
            System.out.println("========================================");

input.close();

        input.close();
    }
}