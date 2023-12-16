///Positive scenerio
////Verify the ‘Forgot Password’ functionality.

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
        
        cy.get(':nth-child(3) > .login-button').click()
        cy.get('[data-cy="login-forgot-password-link"]').click()

              
    })

})
