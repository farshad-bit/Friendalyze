// db\config\config.js

require('dotenv').config({ path: '../.env' });

module.exports = {
  development: {
    username: process.env.POSTGRES_USER,
    password: process.env.POSTGRES_PASSWORD,
    database: process.env.POSTGRES_DB,
    host: process.env.DB_HOST,  // i changed this to the container name
    dialect: "postgres",
    port: process.env.DB_PORT
  }
};
