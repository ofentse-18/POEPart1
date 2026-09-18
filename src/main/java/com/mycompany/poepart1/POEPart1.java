/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poepart1;

import java.util.Scanner;

public class POEPart1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login user = new Login();

        System.out.println("=== USER REGISTRATION ===");

        System.out.print("Enter first name: ");
        user.setFirstName(scanner.nextLine().trim());

        System.out.print("Enter last name: ");
        user.setLastName(scanner.nextLine().trim());

        // Username validation loop
        while (true) {
            System.out.print("Enter username (must contain an underscore and be <= 5 chars): ");
            String username = scanner.nextLine().trim();
            user.setUsername(username);
            if (user.checkUserName()) {
                System.out.println("Username successfully captured.");
                break;
            } else {
                System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            }
        }

        // Password complexity loop
        while (true) {
            System.out.print("Enter password (>= 8 chars, capital, number, special char): ");
            String password = scanner.nextLine().trim();
            user.setPassword(password);
            if (user.checkPasswordComplexity()) {
                System.out.println("Password successfully captured.");
                break;
            } else {
                System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
            }
        }

        // Cell phone loop
        while (true) {
            System.out.print("Enter cell phone number (+27 followed by 9 digits): ");
            String phone = scanner.nextLine().trim();
            user.setCellPhoneNumber(phone);
            if (user.checkCellPhoneNumber()) {
                System.out.println("Cell phone number successfully captured.");
                break;
            } else {
                System.out.println("Cell phone number is incorrectly formatted. Must start with +27 and contain 11 characters total.");
            }
        }

        System.out.println("\n" + user.registerUser());

        // Login section
        System.out.println("\n=== USER LOGIN ===");
        System.out.print("Enter username: ");
        String loginUser = scanner.nextLine().trim();

        System.out.print("Enter password: ");
        String loginPass = scanner.nextLine().trim();

        boolean loggedIn = user.loginUser(loginUser, loginPass);
        System.out.println(user.returnLoginStatus(loggedIn));

        scanner.close();
    }
}
