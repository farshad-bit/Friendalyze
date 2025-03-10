'use strict';
const {
  Model
} = require('sequelize');
module.exports = (sequelize, DataTypes) => {
  class Entry extends Model {
    /**
     * Helper method for defining associations.
     * This method is not a part of Sequelize lifecycle.
     * The `models/index` file will call this method automatically.
     */
    static associate(models) {
      // define association here
    }
  }
  Entry.init({
    entry_text: DataTypes.TEXT,
    sentiment_score: DataTypes.INTEGER,
    ai_score: DataTypes.DECIMAL,
    attachment_url: DataTypes.STRING
  }, {
    sequelize,
    modelName: 'Entry',
  });
  return Entry;
};