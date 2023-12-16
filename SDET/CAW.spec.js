import { test, expect } from '@playwright/test';

test('test', async ({ page }) => {
  await page.goto('https://www.saucedemo.com/');

  // Validate whether username and password fields are editable

  expect(page.locator('input[placeholder="Username"]')).toContainText('Username');
  expect(page.locator('input[placeholder="Password"]')).toContainText('Password');
  await page.locator('input[id="user-name"]').isEditable();
  await page.locator('input[id="password"]').isEditable();

 // Validate the page title (Swag Labs)
  expect(page.locator('div[class="login_logo"]').getByText('Swag Labs')).toBeVisible('Swag Labs')

//Get the username and password details from the page and login
  await page.locator('input[id="user-name"]').fill('standard_user')
  await page.locator('input[id="password"]').fill('secret_sauce')

//Validate whether sort dropdown is displayed
await page.locator('select[class="product_sort_container"]').toBeVisible()

//Change the sorting order of price (high to low)
await page.locator('[data-test="login-button"]').click();
await page.locator('[data-test="product_sort_container"]').selectOption('hilo');

//Read all the product names and prices and store it in a json file as an object with key and value pairs

await page.locator('div[class="inventory_item_name "]').textContent();
await page.locator('div[class="inventory_item_price"]').textContent();

//Add all the products to the cart

const productSelectors = await page.getByText('Add to cart'); 

  for (const productSelector of productSelectors) {
    await productSelector.click();
    await page.waitForTimeout(1000);
  }


//Validate the number of items displayed on cart icon
expect(page.locator('span[class="shopping_cart_badge"]').getByText('6')).toBeVisible();

//Click on cart icon to navigate to checkout page
await page.locator('a[class="shopping_cart_link"]').click()

//Click on checkout button
await page.locator('button[id="checkout"]').click()

//Validate firstname, last name and Zip code fields are editable

expect(page.locator('input[id="first-name"]')).toBeVisible()
expect(page.locator('input[id="last-name"]')).toBeVisible()
expect(page.locator('input[id="postal-code"]')).toBeVisible()

expect(page.locator('input[id="first-name"]')).isEditable();
expect(page.locator('input[id="last-name"]')).isEditable();
expect(page.locator('input[id="postal-code"]')).isEditable();

// Validate firstname, last name and Zip code fields are editable

await page.locator('input[id="first-name"]').fill('Avinash');
await page.locator('input[id="last-name"]').fill('Borole');
await page.locator('input[id="postal-code"]').fill('500016');

// Provide the details and click on continue button
await page.locator('input[id="continue"]').click()

// Validate whether the total price is correct (sum of all prices of added items + fixed tax)
expect(page.locator('div[class="summary_info_label summary_total_label"]')).toContainText('Total: $140.34');

// Click on finish button and validate the thank you message
await page.locator('button[id="finish"]').click()
expect(page.locator('img[alt="Pony Express"]')).toBeVisible()
expect(await page.locator('h2[class="complete-header"]')).toContainText('Thank you for your order!');

// Click on the sandwich menu on top left and logout, validate user is logged out.
await page.locator('div[class="bm-burger-button"]').click();
await page.locator('a[id="logout_sidebar_link"]').getByText('Logout').click()

// Click on the sandwich menu on top left and logout, validate user is logged out.
expect(page.locator('div[class="login_logo"]').getByText('Swag Labs')).toBeVisible()
});