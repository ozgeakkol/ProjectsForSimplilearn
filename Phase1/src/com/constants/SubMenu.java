package com.constants;

public enum SubMenu {
    ADD("A", "Create New File"),
    DELETE("B", "Delete File"),
    SEARCH("C", "Search File"),
    RETURN_TO_MENU("D", "Return to Main Menu");

    String menuId;
    String menuMessage;

    SubMenu(String menuId, String menuMessage) {
        this.menuId = menuId;
        this.menuMessage = menuMessage;
    }

    public static void printSubMenu() {
        for (SubMenu subMenu : SubMenu.values()) {
            System.out.println("\t" + subMenu.menuId + " : " + subMenu.menuMessage);
        }
    }

    public static SubMenu from(String choice){
        for(SubMenu subMenu : SubMenu.values()){
            if(subMenu.menuId.equals(choice)){
                return subMenu;
            }
        }
        System.out.println("Invalid Choice! You will redirected to main menu!");
        return RETURN_TO_MENU;
    }
}
