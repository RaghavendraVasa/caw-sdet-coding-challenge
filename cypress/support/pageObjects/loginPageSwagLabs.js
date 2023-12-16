export class LogInPage{

    username(){
       return cy.get('[data-test="username"]');
    }

    password(){
        return cy.get('[data-test="password"]');
    }

    loginButton(){
        return cy.get('#login-button');
    }


}


export const logInPage = new LogInPage()