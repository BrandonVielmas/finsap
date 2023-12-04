const db = require('../config/dbConfig');

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
      const rows = await db.query('SELECT id, userId, amountSpent, expenseDescription, createDate, updateDate FROM expenses WHERE userId = ? order by id desc;', [userId]);
      if (rows.length === 0) {
        return null;
      }
      return rows;
    } catch (error) {
      console.error('Error al obtener usuario por ID:', error);
      throw error;
    }
  };

Expenses.insert = async (newExpenses) => {
	try {
		//const { userId, amountSpent, expenseDescription } = newExpenses;
		const result = await db.query("insert into expenses (userId, amountSpent, expenseDescription) values (? , ?, ?)", [newExpenses.userId, newExpenses.amountSpent, newExpenses.expenseDescription]);
		newExpenses.id = result.insertId;
		return newExpenses;
	}catch (error){
	console.error('Error al insertar gasto', error);
	throw error;
	}
};
  
module.exports = Expenses;
