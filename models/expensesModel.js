const db = require('../config/dbConfig')

const Expenses = {}

Expenses.getAllExpenses = async () => {
    try {
        const res = await db.query('select * from expenses where typeExpensesId = ?', [2]);
        return res;
    } catch(error) {
        console.error('Error al obtener gastos:', error);
        throw error;
    }
}

Expenses.findByUserId = async (userId) => {
    try {
      const rows = await db.query('SELECT * FROM expenses WHERE userId = ?', [userId]);
      if (rows.length === 0) {
        return null;
      }
      return rows;
    } catch (error) {
      console.error('Error al obtener usuario por ID:', error);
      throw error;
    }
  };
  
//   // Ejemplo de función para crear un nuevo usuario
//   User.createUser = async (username, email) => {
//     try {
//       const [result] = await db.query('INSERT INTO users (username, email) VALUES (?, ?)', [username, email]);
//       const insertedUserId = result.insertId;
//       return insertedUserId;
//     } catch (error) {
//       console.error('Error al crear usuario:', error);
//       throw error;
//     }
//   };

module.exports = Expenses;