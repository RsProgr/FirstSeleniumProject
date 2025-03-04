    package com.ait.homeWork.homeWork.Hw15;

    import org.testng.annotations.AfterMethod;
    import org.testng.annotations.BeforeMethod;
    import org.testng.annotations.Test;


    public class AddItemToCartTests extends TestBase {

        @BeforeMethod
        public void precondition() {
            app.getUser().login();
        }

        @Test
        public void addItemToCartTest() {
            app.getShoppingCart().clickProductPage();
            app.getShoppingCart().clickAddItemToCart();
            app.getShoppingCart().verifyItemAddedToCart();
        }

        @Test
        public void removeProductFromCart() {
            app.getShoppingCart().clickShoppingCartLink();
            app.getShoppingCart().clickCheckbox();
            app.getShoppingCart().clickUpdateShoppingCartButton();
            app.getShoppingCart().verifyCartIsEmpty();
        }

        @AfterMethod
        public void postcondition() {
            app.getShoppingCart().clearCart();
        }
    }