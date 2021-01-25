package com.epam.web.logic.command;

import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.logic.service.*;
import org.junit.Assert;
import org.junit.Test;

public class CommandFactoryTest {
    @Test
    public void testCreateCommandShouldReturnLoginCommandWhenCommandIsLogin(){
        Command actual=CommandFactory.createCommand("login");
        Command expected=new LoginCommand(new LoginService(new DaoHelperFactory()));
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateCommandShouldReturnLanguageCommandWhenCommandIsLanguage(){
        Command actual=CommandFactory.createCommand("language");
        Command expected=new LanguageCommand();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateCommandShouldReturnLogoutCommandWhenCommandIsLogout(){
        Command actual=CommandFactory.createCommand("logout");
        Command expected=new LogoutCommand();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testCreateCommandShouldReturnGoToOrderPageWhenCommandIsGoToOrderPage(){
        Command actual=CommandFactory.createCommand("goToOrderPage");
        Command expected=new GoToOrderPageCommand(new OrderPageService(new DaoHelperFactory()));
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateCommandShouldReturnGoToPageWhenCommandIsGoToLogin(){
        Command actual=CommandFactory.createCommand("goToLogin");
        Command expected=new GoToPageCommand("WEB-INF/view/login.jsp");
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateCommandShouldReturnGoToPageWhenCommandIsGoToProfilePage(){
        Command actual=CommandFactory.createCommand("goToProfilePage");
        Command expected=new GoToPageCommand("WEB-INF/view/profile.jsp");
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateCommandShouldReturnGoToMyOrdersPageCommandIsGoToMyOrdersPage(){
        Command actual=CommandFactory.createCommand("goToMyOrdersPage");
        Command expected=new GoToMyOrdersPageCommand(new GoToMyOrdersPageService(new DaoHelperFactory()));
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateCommandShouldReturnGoToBucketWhenCommandIsGoToBucket(){
        Command actual=CommandFactory.createCommand("goToBucket");
        Command expected=new GoToBucketPageCommand(new GoToBucketPageService());
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateCommandShouldReturnGoToPageWhenCommandIsGoToNewDishPage(){
        Command actual=CommandFactory.createCommand("goToNewDishPage");
        Command expected=new GoToPageCommand("WEB-INF/view/newDish.jsp");
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateCommandShouldReturnGoToRemoveFromMenuPageWhenCommandIsGoToRemoveFromMenuPage(){
        Command actual=CommandFactory.createCommand("goToRemoveFromMenuPage");
        Command expected=new GoToRemoveFromMenuPageCommand(new OrderPageService(new DaoHelperFactory()));
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateCommandShouldReturnCheckLoginWhenCommandIsCheckLogin(){
        Command actual=CommandFactory.createCommand("checkLogin");
        Command expected=new LoginCheckCommand(new LoginCheckService());
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateCommandShouldReturnUpdateUserInfoWhenCommandIsUpdateUserInfo(){
        Command actual=CommandFactory.createCommand("updateUserInfo");
        Command expected=new UpdateUserInfoCommand(new UpdateUserInfoService(new DaoHelperFactory()));
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateCommandShouldReturnAddToBucketWhenCommandIAddToBucket(){
        Command actual=CommandFactory.createCommand("addToBucket");
        Command expected=new AddToBucketCommand(new AddToBucketService(new DaoHelperFactory()));
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateCommandShouldReturnRemoveFromBucketWhenCommandIsRemoveFromBucket(){
        Command actual=CommandFactory.createCommand("removeFromBucket");
        Command expected=new RemoveFromBucketCommand(new RemoveFromBucketService());
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateCommandShouldReturnGoToRolePageWhenCommandIsGoToRolePage(){
        Command actual=CommandFactory.createCommand("goToRolePage");
        Command expected=new GoToRolePageCommand();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateCommandShouldReturnGoToAdminPageWhenCommandIsGoToAdminPage(){
        Command actual=CommandFactory.createCommand("goToAdminPage");
        Command expected=new GoToAdminPageCommand(new GoToAdminPageService(new DaoHelperFactory()));
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateCommandShouldReturnUpdateLoyalityWhenCommandIsUpdateLoyality(){
        Command actual=CommandFactory.createCommand("updateLoyality");
        Command expected=new UpdateLoyalityCommand(new UpdateLoyalityService(new DaoHelperFactory()));
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateCommandShouldReturnAddNewDishWhenCommandIsAddNewDish(){
        Command actual=CommandFactory.createCommand("addNewDish");
        Command expected=new AddNewDishCommand(new AddNewDishService(new DaoHelperFactory()));
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateCommandShouldReturnRemoveFromMenuWhenCommandIsRemoveFromMenu(){
        Command actual=CommandFactory.createCommand("removeFromMenu");
        Command expected=new RemoveFromMenuCommand(new RemoveFromMenuService(new DaoHelperFactory()));
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateCommandShouldReturnMakeAnOrderWhenCommandIsMakeAnOrder(){
        Command actual=CommandFactory.createCommand("makeAnOrder");
        Command expected=new MakeAnOrderCommand(new MakeAnOrderService(new DaoHelperFactory()));
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateCommandShouldReturnGoToAllOrdersPageWhenCommandGoToAllOrdersPage(){
        Command actual=CommandFactory.createCommand("goToAllOrdersPage");
        Command expected=new GoToAllOrdersPageCommand(new GoToAllOrdersPageService(new DaoHelperFactory()));
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateCommandShouldReturnUpdateOrderStatusWhenCommandIsUpdateOrderStatus(){
        Command actual=CommandFactory.createCommand("updateOrderStatus");
        Command expected=new UpdateOrderStatusCommand(new UpdateOrderStatusService(new DaoHelperFactory()));
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateCommandShouldReturnGoToPickedOrdersWhenCommandIsGoToPickedOrders(){
        Command actual=CommandFactory.createCommand("goToPickedOrders");
        Command expected=new GoToPickedOrdersCommand(new GoToPickedOrdersService(new DaoHelperFactory()));
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateCommandShouldReturnEvaluateOrderWhenCommandIsEvaluateOrder(){
        Command actual=CommandFactory.createCommand("evaluateOrder");
        Command expected=new EvaluateOrderCommand(new EvaluateOrderService(new DaoHelperFactory()));
        Assert.assertEquals(expected,actual);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCreateCommandShouldThrowExceptionWhenCommandIsNotCorrect(){
        Command actual=CommandFactory.createCommand("test");
    }
}
