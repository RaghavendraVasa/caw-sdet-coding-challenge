
/// Positive scenerio 1

/////Verify if a user will be able to login with a valid username and valid password.

////Verify the login page for both, when the field is blank and Submit button is clicked.

describe('Klaar Test Suite', () => {
    
    before(()=>{
        console.log('running my tests')
    })

    beforeEach(()=>{
        cy.visit('https://dev.klaarhq.com/auth/sign_in?returnUrl=%2Fprofile')
        
    })

    it('Login Scenerios',()=>{
        cy.viewport('macbook-13')
        cy.screenshot()
        cy.wait(2000)

        cy.get(':nth-child(3) > .login-button > .ant-row').click()
        cy.get('[data-cy="login-email-text-field"]').type('deepa.nayak@gamma.klaar.team')
           .should('have.value', 'deepa.nayak@gamma.klaar.team')
        cy.get('[data-cy="login-password-text-field"]').type('Klaar2021')
          .should('have.value', 'Klaar2021')  
        cy.get('[data-cy="login-submit-button"]').click()
           expect(true).to.be.true
    })

})