const db = require('../config/dbConfig');

const User = {};

User.getUserAccountDetailsById = async (userId) => {
	try {
		const rows = await db.query('select u.id, ad.userId, u.name, u.lastName, ad.userName, u.email, ad.accountBalance, u.createDate, u.updateDate from users u inner join account_details ad on u.id = ad.userId where u.id = ?;', [userId]);
		if(rows.length === 0){
			return null;
		}
		return rows[0];
	}catch(error){
		console.error('Error al obtener los datos del usuario', error);
		throw error;
	}
}

User.getInfoGraficas = async (fechas) => {
	const inicio = fechas.fechaInicio;
	const fin = fechas.fechaFin;
	try {
		const rows = await db.query("SELECT t.description, sum(e.amountSpent) as Total FROM expenses e inner join type_expenses t on e.typeExpensesId = t.id where e.createDate >= cast(? as datetime) and e.createDate <= cast(? as datetime) group by t.id order by t.id;", [`${inicio.year}-${inicio.month}-${inicio.day}`, `${fin.year}-${fin.month}-${fin.day}`]);
		if(rows.length === 0){
			return null;
		}
		return rows;
	}catch(error){
		console.error('Error al obtener los datos del usuario', error);
		throw error;
	}
}

module.exports = User;