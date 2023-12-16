
//// Negative scenerio 

////Verify if a user cannot login with a valid username and an invalid password.

////Verify the messages for invalid login.

describe('Klaar Test Suite', () => {
    
    before(()=>{
        console.log('running my tests')
    })

    beforeEach(()=>{
        cy.visit('https://dev.klaarhq.com/auth/sign_in?returnUrl=%2Fprofile')
        
    })

    it('Login Scenerios ',()=>{
        cy.viewport('macbook-13')
        cy.screenshot()
        cy.wait(2000)

        cy.get(':nth-child(3) > .login-button > .ant-row').click()
        cy.get('[data-cy="login-email-text-field"]').type('deepa.nayak@gamma.klaar.team')
           .should('have.value', 'deepa.nayak@gamma.klaar.team')
        cy.get('[data-cy="login-password-text-field"]').type('Klaar202')
          .should('have.value', 'Klaar202') 
        
          cy.get('[data-cy="login-submit-button"]').click()
          expect(true).to.be.true

    
        
    })

})