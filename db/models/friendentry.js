'use strict';
const {
  Model
} = require('sequelize');
module.exports = (sequelize, DataTypes) => {
  class FriendEntry extends Model {
    /**
     * Helper method for defining associations.
     * This method is not a part of Sequelize lifecycle.
     * The `models/index` file will call this method automatically.
     */
    static associate(models) {
      // define association here
    }
  }
  FriendEntry.init({
    friend_id: DataTypes.INTEGER,
    entry_id: DataTypes.INTEGER
  }, {
    sequelize,
    modelName: 'FriendEntry',
  });
  return FriendEntry;
};