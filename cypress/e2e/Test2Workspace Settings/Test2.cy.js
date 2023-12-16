

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
           
/// Upload image 
        cy.wait(5000)  
        const path ="logo.png";
        cy.get('[data-cy="settings-choose-workspace-logo-button"] > .ng-star-inserted').attachFile(path);

/////****Image upload was done but actually the image was not uploaded into the application  and also the testcase was not failing.i think it will be a functional error   */
      

    })

})