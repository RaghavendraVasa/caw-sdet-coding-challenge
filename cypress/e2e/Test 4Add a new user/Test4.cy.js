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
/// Login to the Application 

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

///Navigate to user list in the application
         
        cy.get('[data-cy="workspace-settings-nav-menu-button"] > .ant-menu-submenu > .ant-menu > ul.ng-star-inserted > :nth-child(2) > [data-cy="submenu-button"]').click()
        cy.get('.ant-btn-primary').click({force:true})
           expect(true).to.be.true
        
        cy.wait(5000)
        cy.get('body > div.banner').click({force: true})



        ////******There is a bug in user list i will explain clearly *********/////
        
      

    })

})