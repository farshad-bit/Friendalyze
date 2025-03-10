'use strict';

/** @type {import('sequelize-cli').Migration} */
'use strict';

module.exports = {
  async up(queryInterface, Sequelize) {
    await queryInterface.bulkInsert('Entries', [
      {
        entry_text: "Had a great time at the movies with Michael!",
        sentiment_score: 8,
        ai_score: 85.5,
        attachment_url: null,
        createdAt: new Date(),
        updatedAt: new Date(),
      },
      {
        entry_text: "Sophia helped me a lot at work today, really appreciated it.",
        sentiment_score: 9,
        ai_score: 90.0,
        attachment_url: null,
        createdAt: new Date(),
        updatedAt: new Date(),
      }
    ], {});
  },

  async down(queryInterface, Sequelize) {
    await queryInterface.bulkDelete('Entries', null, {});
  },
};
