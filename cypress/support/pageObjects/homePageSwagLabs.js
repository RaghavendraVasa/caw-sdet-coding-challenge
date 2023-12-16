
export class HomePage{

    getSortDropdown(){
        return cy.get('.product_sort_container');
    }

    allProducts(){
        return cy.get('.inventory_item');
    }

    addToCartButtonsForAllProducts(){
        return this.allProducts().find('.btn_primary')
    }

    getCart(){
        return cy.get('.shopping_cart_badge')
    }
}

export const homePage = new HomePage();