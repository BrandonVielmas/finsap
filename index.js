const express = require('express')
const cors = require('cors')
const { connectDB } = require('./config/dbConfig')

const expensesRoutes = require('./routes/expensesRoutes');
const userRoutes = require('./routes/userRoutes');
const incomeRoutes = require('./routes/incomeRoutes');

const app = express();
app.use(cors())
app.use(express.json());

connectDB();

const port = process.env.PORT || 3000;

app.use('/api/v1', expensesRoutes)
app.use('/api/v1', userRoutes);
app.use('/api/v1', incomeRoutes);

app.listen(port, () => {
    console.log(`App en puerto ${port}`)
})
