package com.mycompany.poepart1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.mycompany.poepart1.Login;
import com.mycompany.poepart1.Login;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class LoginTest {

    private Login login;

    @BeforeEach
    public void setUp() {
        login = new Login();
    }

    // --- USERNAME TESTS ---

    @Test
    public void testCheckUserNameCorrectlyFormatted() {
        // Must contain an underscore and be <= 5 characters
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testCheckUserNamePoorlyFormatted() {
        // Exceeds 5 characters or missing underscore
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }

    // --- PASSWORD TESTS ---

    @Test
    public void testCheckPasswordComplexitySuccess() {
        // >= 8 chars, uppercase, number, special character
        assertTrue(login.checkPasswordComplexity("Ch&&sec99!"));
    }

    @Test
    public void testCheckPasswordComplexityFailure() {
        // Does not meet complexity requirements
        assertFalse(login.checkPasswordComplexity("password"));
    }

    // --- CELL PHONE TESTS ---

    @Test
    public void testCheckCellPhoneNumberSuccess() {
        // Must start with +27 followed by 9 digits (11 characters total)
        assertTrue(login.checkCellPhoneNumber("+27831234567"));
    }

    @Test
    public void testCheckCellPhoneNumberFailure() {
        // Missing +27 prefix or incorrect length
        assertFalse(login.checkCellPhoneNumber("0831234567"));
    }

    // --- LOGIN VERIFICATION TESTS ---

    @Test
    public void testLoginUserSuccess() {
        login.setUsername("kyl_1");
        login.setPassword("Ch&&sec99!");

        boolean success = login.loginUser("kyl_1", "Ch&&sec99!");
        assertTrue(success);
    }

    @Test
    public void testLoginUserFailure() {
        login.setUsername("kyl_1");
        login.setPassword("Ch&&sec99!");

        boolean success = login.loginUser("wrong_user", "wrong_pass");
        assertFalse(success);
    }

    // --- STATUS MESSAGE TESTS ---

    @Test
    public void testReturnLoginStatusSuccess() {
        login.setFirstName("Kyle");
        login.setLastName("Smith");

        String expected = "Welcome Kyle Smith, it is great to see you again.";
        String actual = login.returnLoginStatus(true);
        assertEquals(expected, actual);
    }

    @Test
    public void testReturnLoginStatusFailure() {
        String expected = "Username or password incorrect, please try again";
        String actual = login.returnLoginStatus(false);
        assertEquals(expected, actual);
    }

    private void assertTrue(boolean checkUserName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertFalse(boolean checkUserName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertEquals(String expected, String actual) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


