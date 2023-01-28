package com.constants;

public enum MainMenu {

    LIST("1", "Display all files in directory"),
    SUBMENU("2", "List the options"),
    EXIT("3", "Exit");

    String menuId;
    String menuMessage;

    MainMenu(String menuId, String menuMessage) {
        this.menuId = menuId;
        this.menuMessage = menuMessage;
    }

    public static void printMainMenu() {
        for (MainMenu mainMenu : MainMenu.values()) {
            System.out.println(mainMenu.menuId + " : " + mainMenu.menuMessage);
        }
    }

    public boolean isExit(){
        return menuId.equals(EXIT.menuId);
    }

    public static MainMenu from(String choice){
        for(MainMenu mainMenu : MainMenu.values()){
            if(mainMenu.menuId.equals(choice)){
                return mainMenu;
            }
        }
        System.out.println("Invalid Choice! Please, rerun the application! GOODBYE !");
        return EXIT;
    }
}
