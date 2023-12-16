class loginPage {

    elements = {
        getUsernameInput: () => cy.get('[data-test="username"]'),
        getPasswordInput: () => cy.get('[data-test="password"]'),
        loginButton: () => cy.get('[data-test="login-button"]'),
        dropDown: () => cy.get('[data-test="product_sort_container"]'),
        selectHigh: () => cy.get('.select_container'),
        cart: () => cy.get('[data-test="add-to-cart-sauce-labs-backpack"]'),
        cartSymbol: () => cy.get('.shopping_cart_link'),
        checkout: () => cy.get('[data-test="checkout"]'),
        firstName: () => cy.get(' [data-test="firstName"]'),
        lastName: () => cy.get(' [data-test="lastName"]'),
        postalCode: () => cy.get(' [data-test="postalCode"]'),
        continue: () => cy.get(' [data-test="continue"]'),
        finish: () => cy.get('[data-test="finish"]')




    }

    login() {
        // this.getUsernameInput().should('not.be.disabled').should('not.have.attr', 'readonly');
        this.elements.getUsernameInput().type("standard_user")
        // this.getPasswordInput().should('not.be.disabled').should('not.have.attr', 'readonly');

        this.elements.getPasswordInput().type("secret_sauce")
        this.elements.loginButton().click();
    }
    cart() {
        this.elements.selectHigh().click();
        this.elements.cart().click();
        this.elements.cartSymbol().click();
        this.elements.checkout().click();
    }
    address() {
        this.elements.firstName().type("siva");
        this.elements.lastName().type("siva");
        this.elements.postalCode().type("53003");
        this.elements.continue().click();
        this.elements.finish().click();










    }
}



module.exports = new loginPage();
require('cypress-xpath')