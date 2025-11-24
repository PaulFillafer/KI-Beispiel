const { v4: uuidv4 } = require('uuid');

class OrderStore {
  constructor() {
    this.orders = [];
  }

  getAll() {
    return this.orders;
  }

  get(id) {
    return this.orders.find(o => o.id === id) || null;
  }

  create({ customer, items, note }) {
    const order = {
      id: uuidv4(),
      customer,
      items,
      note: note || null,
      status: 'pending',
      createdAt: new Date().toISOString(),
      updatedAt: new Date().toISOString()
    };
    this.orders.push(order);
    return order;
  }

  update(id, { customer, items, note, status }) {
    const order = this.get(id);
    if (!order) return null;
    if (customer !== undefined) order.customer = customer;
    if (items !== undefined) order.items = items;
    if (note !== undefined) order.note = note;
    if (status !== undefined) order.status = status;
    order.updatedAt = new Date().toISOString();
    return order;
  }

  remove(id) {
    const idx = this.orders.findIndex(o => o.id === id);
    if (idx === -1) return false;
    this.orders.splice(idx, 1);
    return true;
  }
}

module.exports = OrderStore;