'use strict';

/** @type {import('sequelize-cli').Migration} */
'use strict';

module.exports = {
  async up(queryInterface, Sequelize) {
    await queryInterface.bulkInsert('Friends', [
      {
        user_id: 1,
        friend_name: "Michael Johnson",
        friend_notes: "Met at university",
        analysis_id: null,
        createdAt: new Date(),
        updatedAt: new Date(),
      },
      {
        user_id: 1,
        friend_name: "Sophia Brown",
        friend_notes: "Work colleague",
        analysis_id: null,
        createdAt: new Date(),
        updatedAt: new Date(),
      }
    ], {});
  },

  async down(queryInterface, Sequelize) {
    await queryInterface.bulkDelete('Friends', null, {});
  },
};
