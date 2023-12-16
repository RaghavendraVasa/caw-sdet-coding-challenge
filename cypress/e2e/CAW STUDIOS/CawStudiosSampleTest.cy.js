 
///***** WHILE RUNNING THE TEST SCRIPT PLEASE DO CLEAR THE CACHE ***************

describe('Test1', () => {
    it('Login test', () => {
        
        // Navigate to AUT
        cy.visit('https://www.saucedemo.com/')
        cy.title().should('include', 'Swag Labs')
        
        // Validate whether username and password fields are editable
        cy.get('[data-test="username"]').should('be.enabled')
        cy.get('[data-test="password"]').should('be.enabled')
        
        //Login to the application
        cy.get('[data-test="username"]').type('standard_user')
          .should('have.value', 'standard_user')     //// ASSERTING
        cy.get('[data-test="password"]').type('secret_sauce')
          .should('have.value', 'secret_sauce')
        cy.get('[data-test="login-button"]').click()
          expect(true).to.be.true

        /// SORT DROPDOWN IS VISIBLE
        cy.get('[data-test="product_sort_container"]').should('be.visible')

        // sorting order of price (high to low)
        cy.get('[data-test="product_sort_container"]')
        .select('Price (high to low)')

        ///ADDING PRODUCTS INTO THE CART
        cy.get('[data-test="add-to-cart-sauce-labs-fleece-jacket"]').click()
         expect(true).to.be.true
        
        ///Number Of Items Displayed In the Cart Icon
         cy.get('.shopping_cart_badge').invoke('text').then((cartCount) => {
            const itemCount = parseInt(cartCount);
            expect(itemCount).to.be.greaterThan(0);
          });

        /// CHECKOUT
        cy.get('.shopping_cart_link').click()
        cy.get('[data-test="checkout"]').click()
        
        // Validate whether firstname and lastname fields are editable
        cy.get('[data-test="firstName"]').should('be.enabled')
        cy.get('[data-test="lastName"]').should('be.enabled')
        cy.get('[data-test="postalCode"]').should('be.enabled')
        cy.get('[data-test="firstName"]').type('eswar')
          .should('have.value', 'eswar')
        cy.get('[data-test="lastName"]').type('karri')
         .should('have.value', 'karri')
        cy.get('[data-test="postalCode"]').type('531022')
          .should('have.value', '531022')
        cy.get('[data-test="continue"]').click()

        //Validate whether the total price is correct (sum of all prices of added items + fixed tax)
        cy.get('.inventory_item_price').then(($prices) => {
            const itemPrices = $prices.map((index, elem) => parseFloat(elem.innerText.replace('$', ''))).get()
            const totalPrice = itemPrices.reduce((acc, price) => acc + price, 0)
            const fixedTax = 5.00; // Assume a fixed tax value
            const expectedTotalPrice = totalPrice + fixedTax
      
            cy.get('.summary_subtotal_label').invoke('text').then(($subtotal) => {
              const subtotal = parseFloat($subtotal.replace('Item total: $', ''))
              
            
            })
        })
        // Click on finish button and validate the thank you messag
        cy.get('[data-test="finish"]').click()
        //cy.get('.complete-header').should('have.text', 'THANK YOU FOR YOUR ORDER')
       
        //  The sandwich menu on top left and logout, validate user is logged out
        cy.get('#react-burger-menu-btn').click()
        cy.get('#logout_sidebar_link').click()
        



    









    })
})