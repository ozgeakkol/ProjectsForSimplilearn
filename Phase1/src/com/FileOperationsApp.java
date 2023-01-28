package com;

import com.constants.MainMenu;
import com.constants.SubMenu;

import java.util.Locale;
import java.util.Scanner;

import static com.operations.FileOperations.*;
import static com.operations.MenuOperations.*;

public class FileOperationsApp {

    private static String PATH = "Phase1/fileDirectory";

    public static void main(String[] args) {
        printApplicationInfo();

        printMainMenu();

        Scanner sc = new Scanner(System.in);
        String choice = sc.next();
        MainMenu mainMenuChoice = MainMenu.from(choice);

        while (!mainMenuChoice.isExit()) {
            switch (mainMenuChoice) {
                case LIST: {
                    listAllFilesInDirectory(PATH);
                    printMainMenu();
                    mainMenuChoice = MainMenu.from(sc.next());
                    break;
                }
                case SUBMENU: {
                    printSubMenu();
                    String subChoice = sc.next();
                    SubMenu subMenuChoice = SubMenu.from(subChoice.toUpperCase(Locale.ROOT));

                    switch (subMenuChoice) {
                        case ADD: {
                            System.out.println("Enter new file name:");
                            String fileNameToBeCreated = sc.next();
                            if (fileNameToBeCreated.isEmpty()) {
                                System.out.println("Please enter correct file name: ");
                                fileNameToBeCreated = sc.next();
                            }

                            createFileInDirectory(PATH, fileNameToBeCreated);
                            break;
                        }
                        case DELETE: {
                            System.out.println("Enter the name of the file to be deleted:");
                            String fileName = sc.next();
                            deleteFileFromDirectory(PATH, fileName);
                            break;
                        }
                        case SEARCH: {
                            System.out.println("Enter the file name to be searched: ");
                            String fileName = sc.next();
                            searchFileInDirectory(PATH, fileName);
                            break;
                        }
                        case RETURN_TO_MENU: {
                            printMainMenu();
                            mainMenuChoice = MainMenu.from(sc.next());
                            break;
                        }
                    }
                    break;
                }
                default:
                    System.out.println("Please enter correct option!");
                    mainMenuChoice = MainMenu.from(sc.next());
                    break;
            }
        }

    }

}
