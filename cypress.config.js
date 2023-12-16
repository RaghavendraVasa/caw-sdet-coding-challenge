const { defineConfig } = require("cypress");

module.exports = {
  // Set the value you need, in milliseconds
  pageLoadTimeout: 100000,

  e2e: {
    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
  },
};
