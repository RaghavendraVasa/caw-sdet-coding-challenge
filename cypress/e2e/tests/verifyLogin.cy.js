import loginPage from "../../pages/loginPage"

it('Should login to saucedemo page', () => {
    cy.visit('https://www.saucedemo.com/')
    cy.get('[data-test="username"]').should('not.be.disabled').should('not.have.attr', 'readonly');
    cy.get('[data-test="password"]').should('not.be.disabled').should('not.have.attr', 'readonly');
    loginPage.login();


})

it('Should  to cart page', () => {
    cy.reload();
    loginPage.login();

    loginPage.cart();


})
it('Should address to a page', () => {
    cy.reload();
    loginPage.login();

    loginPage.cart();
    loginPage.address();


})