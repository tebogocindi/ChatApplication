/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.messageapp;

/**
 *
 * @author Student
 */
import java.util.Scanner;

public class MessageApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        runMessages(input);

        input.close();
    }

    // ChatApplication calls this method after successful login.
    public static void runMessages(Scanner input) {

        System.out.println("============================");
        System.out.println("=       MESSAGE  APP       =");
        System.out.println("============================");

        int numberOfMessages;

        while (true) {
            System.out.print(
                    "How many messages would you like to enter? ");

            if (input.hasNextInt()) {
                numberOfMessages = input.nextInt();
                input.nextLine();

                if (numberOfMessages > 0) {
                    break;
                }
            } else {
                input.nextLine();
            }

            System.out.println(
                    "Please enter a whole number greater than zero.");
        }

        Message summary = null;

        for (int i = 0; i < numberOfMessages; i++) {

            System.out.println();
            System.out.println("Message " + (i + 1));
            System.out.println(
                    "============================================");

            String recipient;
            Message messageObject;

            
            do {
                System.out.print(
                        "Enter recipient cell number using +27: ");

                recipient = input.nextLine();

                messageObject = new Message(
                        i, recipient, "Temporary message");

                System.out.println(
                        messageObject.checkRecipientCell());

            } while (!messageObject.isRecipientValid());

            String messageText;

          
            do {
                System.out.print(
                        "Enter your message (maximum 250 characters): ");

                messageText = input.nextLine();

                messageObject = new Message(
                        i, recipient, messageText);

                System.out.println(
                        messageObject.checkMessageLength());

            } while (!messageObject.isMessageValid());

            Message finalMessage = messageObject;
            summary = finalMessage;

            System.out.println("=============================");
            System.out.println("    Generated information    ");
            System.out.println("=============================");

            System.out.println(
                    finalMessage.printMessageDetails());

            System.out.println();
            System.out.println("What would you like to do now?");
            System.out.println("1 - Send message");
            System.out.println("0 - Disregard message");
            System.out.println("2 - Store message");

            int option;

            while (true) {
                System.out.print("Select an option: ");

                if (input.hasNextInt()) {
                    option = input.nextInt();
                    input.nextLine();

                    if (option >= 0 && option <= 2) {
                        break;
                    }
                } else {
                    input.nextLine();
                }

                System.out.println(
                        "Invalid option. Please enter 0, 1 or 2.");
            }

            switch (option) {
                case 1:
                    System.out.println(
                            finalMessage.sentMessage(1));

                    System.out.println();
                    System.out.println("MESSAGE DETAILS");

                    System.out.println(
                            finalMessage.printMessageDetails());
                    break;

                case 0:
                    System.out.println(
                            finalMessage.sentMessage(0));
                    break;

                case 2:
                    // This method also saves the message to JSON.
                    System.out.println(
                            finalMessage.sentMessage(2));
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        System.out.println();
        System.out.println("============================");
        System.out.println("=          SUMMARY         =");
        System.out.println("============================");

        if (summary != null) {
            System.out.println(
                    "Total messages sent: "
                    + summary.returnTotalMessages());

            System.out.println();
            System.out.println("MESSAGES SENT");

            System.out.println(summary.printMessage());
        }
    }
}