package com.epam.web.logic.command;

import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.logic.service.*;
import org.junit.Assert;
import org.junit.Test;

public class CommandFactoryTest {
    @Test
    public void testCreateCommandShouldReturnLoginCommandWhenCommandIsLogin(){
        Command actual=CommandFactory.createCommand("login");
        Assert.assertEquals(actual.getClass(),LoginCommand.class);
    }
    @Test
    public void testCreateCommandShouldReturnLanguageCommandWhenCommandIsLanguage(){
        Command actual=CommandFactory.createCommand("language");
        Assert.assertEquals(actual.getClass(),LanguageCommand.class);
    }
    @Test
    public void testCreateCommandShouldReturnLogoutCommandWhenCommandIsLogout(){
        Command actual=CommandFactory.createCommand("logout");
        Assert.assertEquals(actual.getClass(),LogoutCommand.class);
    }

    @Test
    public void testCreateCommandShouldReturnGoToOrderPageWhenCommandIsGoToOrderPage(){
        Command actual=CommandFactory.createCommand("goToOrderPage");
        Assert.assertEquals(actual.getClass(),GoToOrderPageCommand.class);
    }
    @Test
    public void testCreateCommandShouldReturnGoToPageWhenCommandIsGoToLogin(){
        Command actual=CommandFactory.createCommand("goToLogin");
        Assert.assertEquals(actual.getClass(),GoToPageCommand.class);
    }
    @Test
    public void testCreateCommandShouldReturnGoToPageWhenCommandIsGoToProfilePage(){
        Command actual=CommandFactory.createCommand("goToProfilePage");
        Assert.assertEquals(actual.getClass(),GoToPageCommand.class);
    }
    @Test
    public void testCreateCommandShouldReturnGoToMyOrdersPageCommandIsGoToMyOrdersPage(){
        Command actual=CommandFactory.createCommand("goToMyOrdersPage");
        Assert.assertEquals(actual.getClass(),GoToMyOrdersPageCommand.class);
    }
    @Test
    public void testCreateCommandShouldReturnGoToBucketWhenCommandIsGoToBucket(){
        Command actual=CommandFactory.createCommand("goToBucket");
        Assert.assertEquals(actual.getClass(),GoToBucketPageCommand.class);
    }
    @Test
    public void testCreateCommandShouldReturnGoToPageWhenCommandIsGoToNewDishPage(){
        Command actual=CommandFactory.createCommand("goToNewDishPage");
        Assert.assertEquals(actual.getClass(),GoToPageCommand.class);
    }
    @Test
    public void testCreateCommandShouldReturnGoToRemoveFromMenuPageWhenCommandIsGoToRemoveFromMenuPage(){
        Command actual=CommandFactory.createCommand("goToRemoveFromMenuPage");
        Assert.assertEquals(actual.getClass(),GoToRemoveFromMenuPageCommand.class);
    }
    @Test
    public void testCreateCommandShouldReturnCheckLoginWhenCommandIsCheckLogin(){
        Command actual=CommandFactory.createCommand("checkLogin");
        Assert.assertEquals(actual.getClass(),LoginCheckCommand.class);
    }
    @Test
    public void testCreateCommandShouldReturnUpdateUserInfoWhenCommandIsUpdateUserInfo(){
        Command actual=CommandFactory.createCommand("updateUserInfo");
        Assert.assertEquals(actual.getClass(),UpdateUserInfoCommand.class);
    }
    @Test
    public void testCreateCommandShouldReturnAddToBucketWhenCommandIAddToBucket(){
        Command actual=CommandFactory.createCommand("addToBucket");
        Assert.assertEquals(actual.getClass(),AddToBucketCommand.class);
    }
    @Test
    public void testCreateCommandShouldReturnRemoveFromBucketWhenCommandIsRemoveFromBucket(){
        Command actual=CommandFactory.createCommand("removeFromBucket");
        Assert.assertEquals(actual.getClass(),RemoveFromBucketCommand.class);
    }
    @Test
    public void testCreateCommandShouldReturnGoToRolePageWhenCommandIsGoToRolePage(){
        Command actual=CommandFactory.createCommand("goToRolePage");
        Assert.assertEquals(actual.getClass(),GoToRolePageCommand.class);
    }
    @Test
    public void testCreateCommandShouldReturnGoToAdminPageWhenCommandIsGoToAdminPage(){
        Command actual=CommandFactory.createCommand("goToAdminPage");
        Assert.assertEquals(actual.getClass(),GoToAdminPageCommand.class);
    }
    @Test
    public void testCreateCommandShouldReturnUpdateLoyalityWhenCommandIsUpdateLoyality(){
        Command actual=CommandFactory.createCommand("updateLoyality");
        Assert.assertEquals(actual.getClass(),UpdateLoyalityCommand.class);
    }
    @Test
    public void testCreateCommandShouldReturnAddNewDishWhenCommandIsAddNewDish(){
        Command actual=CommandFactory.createCommand("addNewDish");
        Assert.assertEquals(actual.getClass(),AddNewDishCommand.class);
    }
    @Test
    public void testCreateCommandShouldReturnRemoveFromMenuWhenCommandIsRemoveFromMenu(){
        Command actual=CommandFactory.createCommand("removeFromMenu");
        Assert.assertEquals(actual.getClass(),RemoveFromMenuCommand.class);
    }
    @Test
    public void testCreateCommandShouldReturnMakeAnOrderWhenCommandIsMakeAnOrder(){
        Command actual=CommandFactory.createCommand("makeAnOrder");
        Assert.assertEquals(actual.getClass(),MakeAnOrderCommand.class);
    }
    @Test
    public void testCreateCommandShouldReturnGoToAllOrdersPageWhenCommandGoToAllOrdersPage(){
        Command actual=CommandFactory.createCommand("goToAllOrdersPage");
        Assert.assertEquals(actual.getClass(),GoToAllOrdersPageCommand.class);
    }
    @Test
    public void testCreateCommandShouldReturnUpdateOrderStatusWhenCommandIsUpdateOrderStatus(){
        Command actual=CommandFactory.createCommand("updateOrderStatus");
        Assert.assertEquals(actual.getClass(),UpdateOrderStatusCommand.class);
    }
    @Test
    public void testCreateCommandShouldReturnGoToPickedOrdersWhenCommandIsGoToPickedOrders(){
        Command actual=CommandFactory.createCommand("goToPickedOrders");
        Assert.assertEquals(actual.getClass(),GoToPickedOrdersCommand.class);
    }
    @Test
    public void testCreateCommandShouldReturnEvaluateOrderWhenCommandIsEvaluateOrder(){
        Command actual=CommandFactory.createCommand("evaluateOrder");
        Assert.assertEquals(actual.getClass(),EvaluateOrderCommand.class);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCreateCommandShouldThrowExceptionWhenCommandIsNotCorrect(){
        Command actual=CommandFactory.createCommand("test");
    }
}
