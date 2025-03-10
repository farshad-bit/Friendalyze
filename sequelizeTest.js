const { Sequelize } = require("sequelize");
const db = require("./db/models"); // Load models

async function testSequelize() {
  try {
    // 1️⃣ Read all users
    const users = await db.User.findAll();
    console.log("✅ Users:", users.map(user => user.toJSON()));

    // 2️⃣ Create a new user
    const newUser = await db.User.create({
      username: "mike_williams",
      email: "mike.williams@example.com",
      password_hash: "secure_hash",
    });
    console.log("✅ New User Created:", newUser.toJSON());

    // 3️⃣ Update user email
    await db.User.update(
      { email: "mike.updated@example.com" },
      { where: { id: newUser.id } }
    );
    console.log("✅ User Updated");

    // 4️⃣ Delete user
    await db.User.destroy({ where: { id: newUser.id } });
    console.log("✅ User Deleted");

  } catch (error) {
    console.error("❌ Error:", error);
  }
}

// Run the test function
testSequelize();
