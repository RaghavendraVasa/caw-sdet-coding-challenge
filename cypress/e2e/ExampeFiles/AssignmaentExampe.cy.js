describe ("Exampe TestSuite", ()=> {


    it("Eampe Page",()=> {
        cy.visit('https://eximpe.com/')
        cy.url().should('include','eximpe')
        cy.wait(5000)
        cy.get('.elementor-sticky--active > :nth-child(1) > .elementor-col-100 > :nth-child(1) > .elementor-section > .elementor-container > .elementor-element-79c37ee > .elementor-widget-wrap > .elementor-element-366d1e90').click()
       
        
        cy.get('<a href="#" class="elementor-item elementor-item-anchor has-submenu" id="sm-17009033482352417-5" aria-haspopup="true" aria-controls="sm-17009033482352417-6" aria-expanded="false">About<span class="sub-arrow"><svg class="e-font-icon-svg e-fas-angle-down" viewBox="0 0 320 512" xmlns="http://www.w3.org/2000/svg"><path d="M143 352.3L7 216.3c-9.4-9.4-9.4-24.6 0-33.9l22.6-22.6c9.4-9.4 24.6-9.4 33.9 0l96.4 96.4 96.4-96.4c9.4-9.4 24.6-9.4 33.9 0l22.6 22.6c9.4 9.4 9.4 24.6 0 33.9l-136 136c-9.2 9.4-24.4 9.4-33.8 0z"></path></svg></span></a>')
        .each(($el, index, $list) => {
            if ($el.text() === 'About EximPe') {
            $el.click() 
            
            }
            })



    })
})