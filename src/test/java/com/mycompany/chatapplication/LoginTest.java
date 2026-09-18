/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapplication;

/**
 *
 * @author Student
 */


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    // Username Tests
    @Test
    public void testCheckUserName_Valid() {
        Login user = new Login("Calvin", "Cindi",
                "ab_cd", "Password1!", "+27831234567");

        assertTrue(user.checkUserName());
    }

    @Test
    public void testCheckUserName_Invalid() {
        Login user = new Login("Calvin", "Cindi",
                "abcdef", "Password1!", "+27831234567");

        assertFalse(user.checkUserName());
    }

    // Password Tests
    @Test
    public void testCheckPasswordComplexity_Valid() {
        Login user = new Login("Calvin", "Cindi",
                "ab_cd", "Password1!", "+27831234567");

        assertTrue(user.checkPasswordComplexity());
    }

    @Test
    public void testCheckPasswordComplexity_Invalid() {
        Login user = new Login("Calvin", "Cindi",
                "ab_cd", "password", "+27831234567");

        assertFalse(user.checkPasswordComplexity());
    }

    // Cell Phone Tests
    @Test
    public void testCheckCellPhoneNumber_Valid() {
        Login user = new Login("Calvin", "Cindi",
                "ab_cd", "Password1!", "+27831234567");

        assertTrue(user.checkCellPhoneNumber());
    }

    @Test
    public void testCheckCellPhoneNumber_Invalid() {
        Login user = new Login("Calvin", "Cindi",
                "ab_cd", "Password1!", "0831234567");

        assertFalse(user.checkCellPhoneNumber());
    }

    // Login Test
    @Test
    public void testLoginUser_Success() {
        Login user = new Login("Calvin", "Cindi",
                "ab_cd", "Password1!", "+27831234567");

        assertTrue(user.loginUser("ab_cd", "Password1!"));
    }

    @Test
    public void testLoginUser_Failure() {
        Login user = new Login("Calvin", "Cindi",
                "ab_cd", "Password1!", "+27831234567");

        assertFalse(user.loginUser("wrong", "1234"));
    }

    // Return Login Status
    @Test
    public void testReturnLoginStatus_Success() {
        Login user = new Login("Calvin", "Cindi",
                "ab_cd", "Password1!", "+27831234567");

        String expected = "Welcome Calvin Cindi, it is great to see you again.";

        assertEquals(expected,
                user.returnLoginStatus("ab_cd", "Password1!"));
    }

    @Test
    public void testReturnLoginStatus_Failure() {
        Login user = new Login("Calvin", "Cindi",
                "ab_cd", "Password1!", "+27831234567");

        String expected = "Username or password incorrect, please try again.";

        assertEquals(expected,
                user.returnLoginStatus("wrong", "1234"));
    }
}