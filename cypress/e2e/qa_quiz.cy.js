describe('meldCX qa quiz', () => {
    beforeEach('Visits localhost',() =>{
        cy.visit('http://localhost:8080/')
    });

    let usernameField = '[placeholder="Enter Username"]';
    let passwordField = '[placeholder="password"]';
    let loginBtn =  '.sc-bZQynM';
    
    it('Verify login page is visible',() =>{
        //Assert titte of login page
        cy.get('.sc-bdVaJa').should('have.text','qa.code-quiz.dev');
        //Assert login page
        cy.get('.sc-ifAKCX > div').should('have.text','If you do not have an account, contact an admin').and('be.visible');
    })

  it('Login button visible',() =>{
    //Assert login button
    cy.get('.sc-bZQynM').should('be.visible').and('have.text','LOGIN');
  })

  it('Try to login with invalid username',() =>{
    cy.get(usernameField).type('SomeUser_namewee');
    cy.get(passwordField).type('TopSecret1234!');
    cy.get(loginBtn).click();
})

 it('Try to login with invalid password',() =>{
    cy.get(usernameField).type('SomeUser_namewee');
    cy.get(passwordField).type('TopSecret1234!');
    cy.get(loginBtn).click();
})

let name ='.sc-htpNat.ilgFCs';
let logout = '.sc-bxivhb.fqCnAP';

it('Login with valid credentials',() =>{
    //Login
    cy.get(usernameField).type('SomeUser_name');
    cy.get(passwordField).type('TopSecret1234!');
    cy.get(loginBtn).click();

    //Assert Title
    cy.get('.sc-bdVaJa > div').should('have.text','Hello SomeName').and('be.visible');

     // Assert name value
    cy.get(name).contains('div','Name').siblings('div').should('have.text','SomeName');

     // Assert favourite fruit
    cy.contains('Favourite Fruit').next().should('have.text', 'some fruit');

    //Assert favourite movie
    cy.contains('Favourite Movie').next().should('have.text','The Room');

    //Assert favourite number
    cy.contains('Favourite Number').next().should('have.text','BN<1234>');

    //Assert logout button and click
    cy.get(logout).should('have.text','LOGOUT').click();
})

it('Login with dummytree user',() =>{
    //Login with second user
    cy.get(usernameField).type('dummytree');
    cy.get(passwordField).type('test1');
    cy.get(loginBtn).click();

    //Assert title
    cy.get('.sc-bdVaJa').should('have.text','Hello undefined').and('be.visible');
    
    // Assert name value
    cy.get(name).contains('div','Name').siblings('div').should('have.text','');
    
     // Assert favourite fruit
    cy.contains('Favourite Fruit').next().should('have.text', 'Mango');

    //Assert favourite movie
    cy.contains('Favourite Movie').next().should('have.text','V for Vendetta');

    //Assert favourite number
    cy.contains('Favourite Number').next().should('have.text','The last prime number');

    //Assert logout button and click
    cy.get(logout).should('have.text','LOGOUT').click();

})
    
it('After logging in, reload the page to check whether the user remains logged in',() =>{
      //Login
    cy.get(usernameField).type('SomeUser_name');
    cy.get(passwordField).type('TopSecret1234!');
    cy.get(loginBtn).click();
    cy.reload();
     //Assert Title
    cy.get('.sc-bdVaJa > div').should('have.text','Hello SomeName').and('be.visible');
})
});

