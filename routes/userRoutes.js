const express = require('express');
const User = require('../models/userModel');

const router = express.Router();

router.get('/user-account/:id', async (req, res) => {
	const userId = req.params.id;
	try{
		const userAccountDetails = await User.getUserAccountDetailsById(userId);
		if(!userAccountDetails){
			return res.status(404).send('No se encontraron registros');
		}
		res.json(userAccountDetails);
	} catch(error){
		console.error(error);
		res.status(500).send('Error del servidor');
	}
});

module.exports = router;
