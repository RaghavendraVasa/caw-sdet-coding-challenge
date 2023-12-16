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

// Login to application 

        cy.get(':nth-child(3) > .login-button > .ant-row').click()
        cy.get('[data-cy="login-email-text-field"]').type('deepa.nayak@gamma.klaar.team')
           .should('have.value', 'deepa.nayak@gamma.klaar.team')
        cy.get('[data-cy="login-password-text-field"]').type('Klaar2021')
          .should('have.value', 'Klaar2021')  
        cy.get('[data-cy="login-submit-button"]').click()
           expect(true).to.be.true
        cy.wait(5000)
           cy.get('[data-cy="settings-nav-menu-button"] > .tw-h-14').click({force:true})
           
// Test toggle on/off for profile module - My Strength and My Skills

           cy.get(':nth-child(4) > [data-cy="submenu-button"]').click()
           cy.get('[data-cy="settings-customize-my-strength-module-switch-button"] > .ant-switch > .ant-switch-handle').click()
           cy.get('[data-cy="settings-customize-my-skills-module-switch-button"] > .ant-switch').click()
    })

})