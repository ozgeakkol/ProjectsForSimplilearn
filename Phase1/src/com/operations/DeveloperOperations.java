package com.operations;

import com.domain.Developer;

public class DeveloperOperations {

    public static void printDeveloperDetails() {
        Developer developer = new Developer("Ozge", "Akkol", "email@domain.com");
        System.out.println("-------------Developer Information-------------");
        System.out.println(developer.toString());
        System.out.println("-----------------------------------------------");
    }
}
