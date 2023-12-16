

////Verify Workspace settings are only visible to the admin user and not visible to the non-admin user.//

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

/// Login to the Application With Admin User 

        cy.get(':nth-child(3) > .login-button > .ant-row').click()
        cy.get('[data-cy="login-email-text-field"]').type('deepa.nayak@gamma.klaar.team')
           .should('have.value', 'deepa.nayak@gamma.klaar.team')
        cy.get('[data-cy="login-password-text-field"]').type('Klaar2021')
          .should('have.value', 'Klaar2021')  
        cy.get('[data-cy="login-submit-button"]').click()
           expect(true).to.be.true

//Navigate to settings in the application

           cy.wait(5000)
           cy.get('[data-cy="settings-nav-menu-button"] > .tw-h-14').click({force:true})

///Logout from the admin iuser
     
          cy.get('[data-cy="profile-settings-button"]').click()
          cy.get('[data-cy="logout-button"]').click()

///LogIn with Non-Admin user to verify the workspace settings

cy.get(':nth-child(3) > .login-button > .ant-row').click()
cy.get('[data-cy="login-email-text-field"]').type('arya.mahato@gamma.klaar.team')
   .should('have.value', 'arya.mahato@gamma.klaar.team')
cy.get('[data-cy="login-password-text-field"]').type('Klaar2021')
  .should('have.value', 'Klaar2021')  
cy.get('[data-cy="login-submit-button"]').click()
   expect(true).to.be.true

cy.wait(5000)
cy.get('[data-cy="settings-nav-menu-button"] > .tw-h-14').click({force:true})  
           
       
      

    })

})