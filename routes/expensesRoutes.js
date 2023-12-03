const express = require('express');
const Expenses = require('../models/expensesModel')


const router = express.Router();

router.get('/expenses', async (req, res) => {
    try {
        const expenses = await Expenses.getAllExpenses();
        res.json(expenses);
    } catch(error) {
        console.log(error)
        res.status(500).send("Error del servidor")
    }
})

router.get("/hola", (req,res) => {
	try {
		res.json({mensaje: "Holaaaaaaa!!!\n"});
	} catch(error) {
		res.status(500).send("Ocurrio un error en el servidor");
	}
})

router.get('/expenses/:id', async (req, res) => {
    const userId = req.params.id;
  
    try {
      const user = await Expenses.findByUserId(userId);
      if (!user) {
        return res.status(404).send('No hay datos');
      }
      res.json(user);
    } catch (error) {
      console.error(error);
      res.status(500).send('Error del servidor');
    }
  });

router.post('/expenses', async (req, res) => {
	try {
		const newExpenses = await Expenses.insert(req.body);
		if(!newExpenses){
			return res.status(404).send('Ocurrio un error');
		}
    setTimeout(() => {
      res.json(newExpenses);
    }, 150) //para que se alcanze a ejecutar el triger
	}catch(error) {
		console.error(error);
		res.status(500).send('Error en el servidor');
	}
});

module.exports = router;
