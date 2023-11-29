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
  
//   // Ruta para crear un nuevo usuario
//   router.post('/users', async (req, res) => {
//     const { username, email } = req.body;
  
//     try {
//       const newUser = await User.create({ username, email });
//       res.json(newUser);
//     } catch (error) {
//       console.error(error);
//       res.status(500).send('Error del servidor');
//     }
//   });

module.exports = router;
