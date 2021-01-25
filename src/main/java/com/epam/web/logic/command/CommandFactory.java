package com.epam.web.logic.command;

import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.logic.service.*;

public class CommandFactory {
    public static Command createCommand(String command) {
        switch (command) {
            case "login":
                return new LoginCommand(new LoginService(new DaoHelperFactory()));
            case "language":
                return new LanguageCommand();
            case "logout":
                return new LogoutCommand();
            case "goToOrderPage":
                return new GoToOrderPageCommand(new OrderPageService(new DaoHelperFactory()));
            case "goToLogin":
                return new GoToPageCommand("WEB-INF/view/login.jsp");
            case "goToProfilePage":
                return new GoToPageCommand("WEB-INF/view/profile.jsp");
            case "goToMyOrdersPage":
                return new GoToMyOrdersPageCommand(new GoToMyOrdersPageService(new DaoHelperFactory()));
            case "goToBucket":
                return new GoToBucketPageCommand(new GoToBucketPageService());
            case "goToNewDishPage":
                return new GoToPageCommand("WEB-INF/view/newDish.jsp");
            case "goToRemoveFromMenuPage":
                return new GoToRemoveFromMenuPageCommand(new OrderPageService(new DaoHelperFactory()));
            case "checkLogin":
                return new LoginCheckCommand(new LoginCheckService());
            case "updateUserInfo":
                return new UpdateUserInfoCommand(new UpdateUserInfoService(new DaoHelperFactory()));
            case "addToBucket":
                return new AddToBucketCommand(new AddToBucketService(new DaoHelperFactory()));
            case "removeFromBucket":
                return new RemoveFromBucketCommand(new RemoveFromBucketService());
            case "goToRolePage":
                return new GoToRolePageCommand();
            case "goToAdminPage":
                return new GoToAdminPageCommand(new GoToAdminPageService(new DaoHelperFactory()));
            case "updateLoyality":
                return new UpdateLoyalityCommand(new UpdateLoyalityService(new DaoHelperFactory()));
            case "addNewDish":
                return new AddNewDishCommand(new AddNewDishService(new DaoHelperFactory()));
            case "removeFromMenu":
                return new RemoveFromMenuCommand(new RemoveFromMenuService(new DaoHelperFactory()));
            case "makeAnOrder":
                return new MakeAnOrderCommand(new MakeAnOrderService(new DaoHelperFactory()));
            case "goToAllOrdersPage":
                return new GoToAllOrdersPageCommand(new GoToAllOrdersPageService(new DaoHelperFactory()));
            case "updateOrderStatus":
                return new UpdateOrderStatusCommand(new UpdateOrderStatusService(new DaoHelperFactory()));
            case "goToPickedOrders":
                return new GoToPickedOrdersCommand(new GoToPickedOrdersService(new DaoHelperFactory()));
            case "evaluateOrder":
                return new EvaluateOrderCommand(new EvaluateOrderService(new DaoHelperFactory()));
            default:
                throw new IllegalArgumentException("Illegal string");
        }
    }
}
