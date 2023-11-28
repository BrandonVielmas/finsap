const express = require('express')
const { connectDB } = require('./config/dbConfig')
const expensesRoutes = require('./routes/expensesRoutes');

const app = express();

connectDB();

const port = process.env.PORT || 3000;

app.use('/api', expensesRoutes)

app.listen(port, () => {
    console.log(`App en puerto ${port}`)
})