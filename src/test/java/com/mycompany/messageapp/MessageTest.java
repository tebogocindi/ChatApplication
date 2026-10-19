/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

/**
 *
 * @author Student
 */
package com.mycompany.messageapp;

import org.junit.Test;
import static org.junit.Assert.*;

public class MessageTest {

    // USERNAME TESTS

    @Test
    public void testCheckUserName_Valid() {
        Login user = new Login(
                "Calvin", "Cindi",
                "ab_cd", "Password1!", "+27831234567");

        assertTrue(user.checkUserName());
    }

    @Test
    public void testCheckUserName_NoUnderscore() {
        Login user = new Login(
                "Calvin", "Cindi",
                "abcd", "Password1!", "+27831234567");

        assertFalse(user.checkUserName());
    }

    @Test
    public void testCheckUserName_TooLong() {
        Login user = new Login(
                "Calvin", "Cindi",
                "abc_def", "Password1!", "+27831234567");

        assertFalse(user.checkUserName());
    }

    // PASSWORD TESTS

    @Test
    public void testCheckPasswordComplexity_Valid() {
        Login user = new Login(
                "Calvin", "Cindi",
                "ab_cd", "Password1!", "+27831234567");

        assertTrue(user.checkPasswordComplexity());
    }

    @Test
    public void testPassword_TooShort() {
        Login user = new Login(
                "Calvin", "Cindi",
                "ab_cd", "Pass1!", "+27831234567");

        assertFalse(user.checkPasswordComplexity());
    }

    @Test
    public void testPassword_NoUppercase() {
        Login user = new Login(
                "Calvin", "Cindi",
                "ab_cd", "password1!", "+27831234567");

        assertFalse(user.checkPasswordComplexity());
    }

    @Test
    public void testPassword_NoNumber() {
        Login user = new Login(
                "Calvin", "Cindi",
                "ab_cd", "Password!", "+27831234567");

        assertFalse(user.checkPasswordComplexity());
    }

    @Test
    public void testPassword_NoSpecialCharacter() {
        Login user = new Login(
                "Calvin", "Cindi",
                "ab_cd", "Password1", "+27831234567");

        assertFalse(user.checkPasswordComplexity());
    }

    // CELLPHONE TESTS

    @Test
    public void testCheckCellPhoneNumber_Valid() {
        Login user = new Login(
                "Calvin", "Cindi",
                "ab_cd", "Password1!", "+27831234567");

        assertTrue(user.checkCellPhoneNumber());
    }

    @Test
    public void testCellPhoneNumber_NoInternationalCode() {
        Login user = new Login(
                "Calvin", "Cindi",
                "ab_cd", "Password1!", "0831234567");

        assertFalse(user.checkCellPhoneNumber());
    }

    @Test
    public void testCellPhoneNumber_TooShort() {
        Login user = new Login(
                "Calvin", "Cindi",
                "ab_cd", "Password1!", "+2783123456");

        assertFalse(user.checkCellPhoneNumber());
    }

    @Test
    public void testCellPhoneNumber_TooLong() {
        Login user = new Login(
                "Calvin", "Cindi",
                "ab_cd", "Password1!", "+278312345678");

        assertFalse(user.checkCellPhoneNumber());
    }

    @Test
    public void testCellPhoneNumber_ContainsLetters() {
        Login user = new Login(
                "Calvin", "Cindi",
                "ab_cd", "Password1!", "+2783123456A");

        assertFalse(user.checkCellPhoneNumber());
    }

    // LOGIN TESTS

    @Test
    public void testLoginUser_Success() {
        Login user = new Login(
                "Calvin", "Cindi",
                "ab_cd", "Password1!", "+27831234567");

        assertTrue(user.loginUser("ab_cd", "Password1!"));
    }

    @Test
    public void testLoginUser_WrongUsername() {
        Login user = new Login(
                "Calvin", "Cindi",
                "ab_cd", "Password1!", "+27831234567");

        assertFalse(user.loginUser("wrong", "Password1!"));
    }

    @Test
    public void testLoginUser_WrongPassword() {
        Login user = new Login(
                "Calvin", "Cindi",
                "ab_cd", "Password1!", "+27831234567");

        assertFalse(user.loginUser("ab_cd", "WrongPassword1!"));
    }

    // LOGIN STATUS TESTS

    @Test
    public void testReturnLoginStatus_Success() {
        Login user = new Login(
                "Calvin", "Cindi",
                "ab_cd", "Password1!", "+27831234567");

        String expected =
                "Welcome Calvin Cindi, it is great to see you again.";

        assertEquals(
                expected,
                user.returnLoginStatus("ab_cd", "Password1!"));
    }

    @Test
    public void testReturnLoginStatus_Failure() {
        Login user = new Login(
                "Calvin", "Cindi",
                "ab_cd", "Password1!", "+27831234567");

        String expected =
                "Username or password incorrect, please try again.";

        assertEquals(
                expected,
                user.returnLoginStatus("wrong", "1234"));
    }
}