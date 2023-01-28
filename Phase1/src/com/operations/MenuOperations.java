package com.operations;

import com.constants.MainMenu;
import com.constants.SubMenu;

import static com.operations.DeveloperOperations.printDeveloperDetails;

public class MenuOperations {

    public static void printApplicationInfo() {
        printWelcomeMessage();
        printDeveloperDetails();
    }

    private static void printWelcomeMessage() {
        System.out.println("\nWelcome to File Directory Project!\n");
    }

    public static void printMainMenu() {

        System.out.println("Make a choice: ");
        printLineSeparator();
        MainMenu.printMainMenu();

    }

    public static void printSubMenu() {
        printLineSeparator();
        SubMenu.printSubMenu();
        printLineSeparator();

    }

    public static void printLineSeparator() {
        System.out.println("-----------------------------------------------");
    }
}
