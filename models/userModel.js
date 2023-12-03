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

module.exports = User;
