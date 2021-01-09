package com.epam.web.enums;

public enum AdminCommandEnum {
    GO_TO_ADMIN_PAGE("goToAdminPage"),UPDATE_LOYALITY("updateLoyality"),ADD_NEW_DISH("addNewDish"),REMOVE_FROM_MENU("removeFromMenu"),GO_TO_ALL_ORDERS_PAGE("goToAllOrdersPage");
    private String command;
    AdminCommandEnum(String command) {
        this.command=command;
    }

    public String getCommand() {
        return command;
    }
}
