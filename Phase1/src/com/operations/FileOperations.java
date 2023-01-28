package com.operations;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileOperations {

    public static void listAllFilesInDirectory(String pathName) {
        File directory = new File(pathName);
        File[] files = directory.listFiles();
        if (files.length == 0) {
            System.out.println("Empty directory!");
        } else {
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
    }

    public static void createFileInDirectory(String pathName, String fileNameToBeCreated) {
        File newFile = new File(pathName, fileNameToBeCreated);
        if (newFile.exists()) {
            System.out.println("File is already exists!");
        } else {
            try {
                newFile.createNewFile();
                System.out.println("File created!");
            } catch (IOException e) {
                System.out.println("Exception occurred while creating file with name %s" + fileNameToBeCreated);
            }
        }
    }

    public static void deleteFileFromDirectory(String pathName, String fileName) {
        if (isFileAlreadyExist(pathName, fileName)) {
            File fileToBeDeleted = new File(pathName, fileName);
            fileToBeDeleted.delete();
            System.out.println("File deleted successfully!");
        } else {
            System.out.println("File not found!");
        }
    }

    public static void searchFileInDirectory(String pathName, String fileName) {
        if (!fileName.isEmpty()) {
            if (isFileAlreadyExist(pathName, fileName)) {
                System.out.println("File found in the directory! ");
            } else {
                System.out.println("There is no file named " + fileName);
            }
        } else {
            System.out.println("Invalid file name! Please enter correct file name for search!");
        }
    }

    private static boolean isFileAlreadyExist(String pathName, String fileName) {
        File directory = new File(pathName);
        File[] files = directory.listFiles();
        return Arrays.stream(files).anyMatch(file -> file.getName().equals(fileName));
    }
}
