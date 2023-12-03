const express = require('express');
const Income = require('../models/incomeModel')

const router = express.Router();


router.post('/income/:userId', async (req, res) => {
	const userId = req.params.userId;
	try {
		const newIncome = await Income.insert(req.body, userId);
		if(!newIncome){
			return res.status(400).send("Ocurrio un error")
		}
		res.json(newIncome);
	}catch(error){
		res.status(500).send("Error en el servidor");
	}
});

module.exports = router;
