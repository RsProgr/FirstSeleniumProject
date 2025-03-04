package com.ait.homeWork.homeWork.Hw15;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AddItemToCartTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        login();
    }

    @Test
    public void addItemToCartTest() {
        clickProductPage();
        clickAddItemToCart();
        verifyItemAddedToCart();
    }

    @Test
    public void removeProductFromCart() {
        clickShoppingCartLink();
        clickCheckbox();
        clickUpdateShoppingCartButton();
        verifyCartIsEmpty();
    }

    @AfterMethod
    public void postcondition() {
        clearCart();
    }
}