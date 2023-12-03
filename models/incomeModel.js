const db = require('../config/dbConfig')

const Income = {}

Income.insert = async(newIncome, userId) => {
	try {
		const result = await db.query("insert into income (userId, incomeEntered, incomeDescription) values (?, ?, ?)", [userId, newIncome.incomeEntered, "Sueldo"]);
		newIncome.incomeDescription = "Sueldo";
		newIncome.id = result.insertId;
		return newIncome;
	}catch(error){
		throw error;
	}
}

module.exports = Income;
