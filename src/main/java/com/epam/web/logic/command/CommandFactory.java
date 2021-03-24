package com.epam.web.logic.command;

import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.logic.service.*;

public class CommandFactory {
    private static final String LOGIN="login";
    private static final String LANGUAGE="language";
    private static final String LOGOUT="logout";
    private static final String TO_ORDER_PAGE="goToOrderPage";
    private static final String TO_LOGIN="goToLogin";
    private static final String TO_PROFILE="goToProfilePage";
    private static final String TO_MY_ORDERS="goToMyOrdersPage";
    private static final String TO_BUCKET="goToBucket";
    private static final String TO_NEW_DISH_PAGE="goToNewDishPage";
    private static final String TO_REMOVE_FROM_MENU="goToRemoveFromMenuPage";
    private static final String CHECK_LOGIN="checkLogin";
    private static final String UPDATE_USER_INFO="updateUserInfo";
    private static final String ADD_TO_BUCKET="addToBucket";
    private static final String REMOVE_FROM_BUCKET="removeFromBucket";
    private static final String TO_ROLE_PAGE="goToRolePage";
    private static final String TO_ADMIN_PAGE="goToAdminPage";
    private static final String UPDATE_LOYALITY="updateLoyality";
    private static final String ADD_NEW_DISH="addNewDish";
    private static final String REMOVE_FROM_MENU="removeFromMenu";
    private static final String MAKE_AN_ORDER="makeAnOrder";
    private static final String TO_ALL_ORDERS_PAGE="goToAllOrdersPage";
    private static final String UPDATE_ORDER_STATUS="updateOrderStatus";
    private static final String TO_PICKED_ORDERS="goToPickedOrders";
    private static final String EVALUATE_ORDER="evaluateOrder";
    private static final String LOGIN_PAGE="WEB-INF/view/login.jsp";
    private static final String PROFILE_PAGE="WEB-INF/view/profile.jsp";
    private static final String NEW_DISH_PAGE="WEB-INF/view/newDish.jsp";
    private static final String ERROR="Illegal Command";
    public static Command createCommand(String command) {
        switch (command) {
            case LOGIN:
                return new LoginCommand(new LoginService(new DaoHelperFactory()));
            case LANGUAGE:
                return new LanguageCommand();
            case LOGOUT:
                return new LogoutCommand();
            case TO_ORDER_PAGE:
                return new GoToOrderPageCommand(new OrderPageService(new DaoHelperFactory()));
            case TO_LOGIN:
                return new GoToPageCommand(LOGIN_PAGE);
            case TO_PROFILE:
                return new GoToPageCommand(PROFILE_PAGE);
            case TO_MY_ORDERS:
                return new GoToMyOrdersPageCommand(new GoToMyOrdersPageService(new DaoHelperFactory()));
            case TO_BUCKET:
                return new GoToBucketPageCommand(new GoToBucketPageService());
            case TO_NEW_DISH_PAGE:
                return new GoToPageCommand(NEW_DISH_PAGE);
            case TO_REMOVE_FROM_MENU:
                return new GoToRemoveFromMenuPageCommand(new OrderPageService(new DaoHelperFactory()));
            case CHECK_LOGIN:
                return new LoginCheckCommand(new LoginCheckService());
            case UPDATE_USER_INFO:
                return new UpdateUserInfoCommand(new UpdateUserInfoService(new DaoHelperFactory()));
            case ADD_TO_BUCKET:
                return new AddToBucketCommand(new AddToBucketService(new DaoHelperFactory()));
            case REMOVE_FROM_BUCKET:
                return new RemoveFromBucketCommand(new RemoveFromBucketService());
            case TO_ROLE_PAGE:
                return new GoToRolePageCommand();
            case TO_ADMIN_PAGE:
                return new GoToAdminPageCommand(new GoToAdminPageService(new DaoHelperFactory()));
            case UPDATE_LOYALITY:
                return new UpdateLoyalityCommand(new UpdateLoyalityService(new DaoHelperFactory()));
            case ADD_NEW_DISH:
                return new AddNewDishCommand(new AddNewDishService(new DaoHelperFactory()));
            case REMOVE_FROM_MENU:
                return new RemoveFromMenuCommand(new RemoveFromMenuService(new DaoHelperFactory()));
            case MAKE_AN_ORDER:
                return new MakeAnOrderCommand(new MakeAnOrderService(new DaoHelperFactory()));
            case TO_ALL_ORDERS_PAGE:
                return new GoToAllOrdersPageCommand(new GoToAllOrdersPageService(new DaoHelperFactory()));
            case UPDATE_ORDER_STATUS:
                return new UpdateOrderStatusCommand(new UpdateOrderStatusService(new DaoHelperFactory()));
            case TO_PICKED_ORDERS:
                return new GoToPickedOrdersCommand(new GoToPickedOrdersService(new DaoHelperFactory()));
            case EVALUATE_ORDER:
                return new EvaluateOrderCommand(new EvaluateOrderService(new DaoHelperFactory()));
            default:
                throw new IllegalArgumentException(ERROR);
        }
    }
}
