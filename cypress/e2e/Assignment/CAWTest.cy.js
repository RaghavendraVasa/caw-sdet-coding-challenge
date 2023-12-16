/// <reference types="cypress" />
import { homePage } from "../../support/pageObjects/homePageSwagLabs";
import { logInPage } from "../../support/pageObjects/loginPageSwagLabs"

describe("Suite for Swag Labs", ()=>{
    var userName;
    var passWord;  

    beforeEach('Visiting the url', ()=>{
        cy.visit('/');    //to visit the baseURL
    })
it.only("Test to validate username and password are accepting inputs", ()=>{
  
    cy.title().should('eq', 'Swag Labs');   //to assert the page title

    // method to get the username
    cy.get('#login_credentials').invoke('text').then((text) => {
    const string = text.split(/\s+/);
    userName = string[4];

    // method to get the password
    cy.get('.login_password').invoke('text').then((text) => {
    const words = text.split(/\s+/);
    passWord = words[5];

    // Perform the login after obtaining the username and password
    logInPage.username().type(userName);
    logInPage.username().should('have.value', userName);
    logInPage.password().type(passWord);
    logInPage.password().should('have.value', passWord);
    });
    });

})

it.skip('Login using valid credentials', ()=>{
    cy.logInUsingValidCred(userName, passWord);
})

it.skip('Test to handle the password expiry alert', ()=>{
    cy.logInUsingValidCred(userName, passWord);
    cy.on('window:confirm', () => true)
})


it.skip('Validation for sorting droddown', ()=>{
    cy.logInUsingValidCred(userName, passWord);
    homePage.getSortDropdown().should('be.visible');   //to check dropdown displayed
    homePage.getSortDropdown().should('have.value', 'az'); // to check dropdown has value a to z

    //to sort the products according to price high to low

    homePage.getSortDropdown().select('hilo');    //to change the dropdown value
    homePage.getSortDropdown().should('have.value', 'hilo');  //to check the current dropdown value
})


it.only('Getting the products and prices dynamically', ()=>{
    cy.logInUsingValidCred(userName, passWord);

    const products = [];

    homePage.allProducts().each(($ele) => {
        // Use .then to get the resolved text values
        cy.wrap($ele).find('.inventory_item_name').invoke('text').then((prodName) => {
          cy.wrap($ele).find('.inventory_item_price').invoke('text').then((prodPrice) => {
            cy.wrap($ele).find('.inventory_item_desc').invoke('text').then((description) => {
              products.push({
              name: prodName,
              value: prodPrice,
              desc : description
            });
          });
        });
        });
      });
    cy.writeFile('cypress/fixtures/products.json', { products });
})

it.only('Add ALL products to the cart and validate the product number displayed on the card' , ()=>{

    cy.logInUsingValidCred(userName, passWord);
    homePage.addToCartButtonsForAllProducts().each(($btn)=>{
        cy.wrap($btn).click();
    })

    homePage.getCart().invoke('text').should('eq','6');

    //click on the card and validate cart items
    homePage.getCart().click();
})

})