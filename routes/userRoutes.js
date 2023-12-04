const express = require('express');
const User = require('../models/userModel');

const router = express.Router();

router.post('/user-account/:id', async (req, res) => {
	const userId = req.params.id;
	try{
		const userAccountDetails = await User.getUserAccountDetailsById(userId);
		const datosGraficas = await User.getInfoGraficas(req.body)
		if(!userAccountDetails || !datosGraficas){
			return res.status(404).send('No se encontraron registros');
		}
	
		const respuesta = {
			infoUser: userAccountDetails,
			infoGraficas: {
				datosGraficas: datosGraficas,
				totalGasto: datosGraficas.totalGastado = datosGraficas.reduce((total, item) => total + parseFloat(item.Total), 0)
			}
		}
		res.json(respuesta)
	} catch(error){
		console.error(error);
		res.status(500).send('Error del servidor');
	}
});

module.exports = router;
