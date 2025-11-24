const express = require('express');
const ordersRouter = require('./routes/orders');

const app = express();
app.use(express.json());

app.use('/orders', ordersRouter);

app.use((err, req, res, next) => {
  console.error(err);
  res.status(500).json({ error: 'Internal Server Error' });
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`REST-API für Essensbestellung läuft auf http://localhost:${PORT}`);
});