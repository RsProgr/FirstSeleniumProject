package com.ait.homeWork.homeWork.Hw15;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AddItemToCartTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        TestBase.app.getUser().login();
    }

    @Test
    public void addItemToCartTest() {
        TestBase.app.getShoppingCart().clickProductPage();
        TestBase.app.getShoppingCart().clickAddItemToCart();
        TestBase.app.getShoppingCart().verifyItemAddedToCart();
    }

    @Test
    public void removeProductFromCart() {
        TestBase.app.getShoppingCart().clickShoppingCartLink();
        TestBase.app.getShoppingCart().clickCheckbox();
        TestBase.app.getShoppingCart().clickUpdateShoppingCartButton();
        TestBase.app.getShoppingCart().verifyCartIsEmpty();
    }

    @AfterMethod
    public void postcondition() {
        TestBase.app.getShoppingCart().clearCart();
    }
}