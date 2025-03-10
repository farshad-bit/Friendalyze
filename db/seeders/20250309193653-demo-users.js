'use strict';

/** @type {import('sequelize-cli').Migration} */
module.exports = {
  async up(queryInterface, Sequelize) {
    await queryInterface.bulkInsert('Users', [
      {
        username: "john_doe",
        email: "john.doe@example.com",
        password_hash: "hashed_password_1",
        createdAt: new Date(),
        updatedAt: new Date(),
      },
      {
        username: "emma_smith",
        email: "emma.smith@example.com",
        password_hash: "hashed_password_2",
        createdAt: new Date(),
        updatedAt: new Date(),
      }
    ], {});
  },

  async down(queryInterface, Sequelize) {
    await queryInterface.bulkDelete('Users', null, {});
  },
};