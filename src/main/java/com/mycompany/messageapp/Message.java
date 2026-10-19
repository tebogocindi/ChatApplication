/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.messageapp;

/**
 *
 * @author Student
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Message {

    private String messageID;
    private int messageNumber;
    private String recipient;
    private String message;
    private String messageHash;

    private static int totalMessageSent = 0;
    private static String sentMessage = "";

    public Message(int messageNumber, String recipient, String message) {
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.message = message;
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
    }

    public String generateMessageID() {
        Random random = new Random();
        String id = "";

        for (int i = 0; i < 10; i++) {
            int digit = random.nextInt(10);
            id += digit;
        }

        return id;
    }

    public boolean checkMessageID() {
        return messageID != null
                && messageID.matches("\\d{10}");
    }

    public String checkRecipientCell() {
        if (isRecipientValid()) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does "
                    + "not contain an international code. Please correct "
                    + "the number and try again.";
        }
    }

    public boolean isRecipientValid() {
        return recipient != null
                && recipient.matches("^\\+27\\d{9}$");
    }

    public String checkMessageLength() {
        if (message == null || message.trim().isEmpty()) {
            return "Please enter a message.";
        }

        if (message.length() <= 250) {
            return "Message ready to send.";
        } else {
            int extraCharacters = message.length() - 250;

            return "Message exceeds 250 characters by "
                    + extraCharacters
                    + ", please reduce the size.";
        }
    }

    public boolean isMessageValid() {
        return message != null
                && !message.trim().isEmpty()
                && message.length() <= 250;
    }

    public String createMessageHash() {
        if (message == null || message.trim().isEmpty()
                || messageID == null || messageID.length() < 2) {
            return "";
        }

        String[] words = message.trim().split("\\s+");

        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        firstWord = firstWord.replaceAll("[^a-zA-Z0-9]", "");
        lastWord = lastWord.replaceAll("[^a-zA-Z0-9]", "");

        String hash = messageID.substring(0, 2)
                + ":"
                + messageNumber
                + ":"
                + firstWord
                + lastWord;

        return hash.toUpperCase(java.util.Locale.ROOT);
    }

    public String sentMessage(int option) {
        if (option == 0) {
            return "Press 0 to delete the message.";
        }

        if (option != 1 && option != 2) {
            return "Invalid option.";
        }

        if (!checkMessageID()
                || !isRecipientValid()
                || !isMessageValid()) {
            return "Please correct the message details.";
        }

        if (option == 1) {
            totalMessageSent++;

            sentMessage += printMessageDetails()
                    + System.lineSeparator()
                    + "======================="
                    + System.lineSeparator();

            return "Message successfully sent.";
        } else {
            return storeMessage();
        }
    }

    public String printMessage() {
        if (sentMessage.isEmpty()) {
            return "No messages sent.";
        }

        return sentMessage;
    }

    public int returnTotalMessages() {
        return totalMessageSent;
    }

    public String printMessageDetails() {
        return "Message ID: " + messageID
                + System.lineSeparator()
                + "Message hash: " + messageHash
                + System.lineSeparator()
                + "Recipient: " + recipient
                + System.lineSeparator()
                + "Message: " + message;
    }

    public String storeMessage() {
        if (!checkMessageID()
                || !isRecipientValid()
                || !isMessageValid()) {
            return "Please correct the message details.";
        }

        String fileName = "message_" + messageID + ".json";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("{\n");
            writer.write("  \"messageID\": "
                    + toJsonString(messageID) + ",\n");
            writer.write("  \"messageNumber\": "
                    + messageNumber + ",\n");
            writer.write("  \"recipient\": "
                    + toJsonString(recipient) + ",\n");
            writer.write("  \"message\": "
                    + toJsonString(message) + ",\n");
            writer.write("  \"messageHash\": "
                    + toJsonString(messageHash) + "\n");
            writer.write("}");

            return "Message successfully stored.";

        } catch (IOException exception) {
            return "Error storing message: " + exception.getMessage();
        }
    }

    private String toJsonString(String value) {
        StringBuilder result = new StringBuilder("\"");

        for (char character : value.toCharArray()) {
            switch (character) {
                case '"':
                    result.append("\\\"");
                    break;

                case '\\':
                    result.append("\\\\");
                    break;

                case '\n':
                    result.append("\\n");
                    break;

                case '\r':
                    result.append("\\r");
                    break;

                case '\t':
                    result.append("\\t");
                    break;

                default:
                    if (character < 32) {
                        result.append(String.format(
                                "\\u%04x", (int) character));
                    } else {
                        result.append(character);
                    }
            }
        }

        result.append("\"");
        return result.toString();
    }
}
