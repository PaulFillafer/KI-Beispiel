const express = require('express');
const router = express.Router();
const OrderStore = require('../models/orderStore');

const store = new OrderStore();

// GET /orders
router.get('/', (req, res) => {
  res.json(store.getAll());
});

// GET /orders/:id
router.get('/:id', (req, res) => {
  const order = store.get(req.params.id);
  if (!order) return res.status(404).json({ error: 'Order not found' });
  res.json(order);
});

// POST /orders
// body: { customer: string, items: [{ name, quantity }], note?: string }
router.post('/', (req, res) => {
  const { customer, items, note } = req.body;
  if (!customer || !Array.isArray(items) || items.length === 0) {
    return res.status(400).json({ error: 'Invalid order payload' });
  }
  const created = store.create({ customer, items, note });
  res.status(201).json(created);
});

// PUT /orders/:id
router.put('/:id', (req, res) => {
  const updated = store.update(req.params.id, req.body);
  if (!updated) return res.status(404).json({ error: 'Order not found' });
  res.json(updated);
});

// DELETE /orders/:id
router.delete('/:id', (req, res) => {
  const removed = store.remove(req.params.id);
  if (!removed) return res.status(404).json({ error: 'Order not found' });
  res.status(204).send();
});

module.exports = router;