package com.paulfillafer.orders.service;

import com.paulfillafer.orders.entity.Order;
import com.paulfillafer.orders.entity.OrderItem;
import com.paulfillafer.orders.repository.OrderRepository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService {
    private final OrderRepository repo;

    public OrderService(OrderRepository repo) {
        this.repo = repo;
    }

    public List<Order> getAll() { return repo.findAll(); }
    public Optional<Order> get(Long id) { return repo.findById(id); }

    public Order create(Order order) {
        order.setStatus("pending");
        order.setCreatedAt(Instant.now());
        order.setUpdatedAt(Instant.now());
        // ensure bidirectional
        if (order.getItems() != null) {
            for (OrderItem i : order.getItems()) i.setOrder(order);
        }
        return repo.save(order);
    }

    public Optional<Order> update(Long id, Order payload) {
        return repo.findById(id).map(existing -> {
            if (payload.getCustomer() != null) existing.setCustomer(payload.getCustomer());
            if (payload.getItems() != null) existing.setItems(payload.getItems());
            if (payload.getNote() != null) existing.setNote(payload.getNote());
            if (payload.getStatus() != null) existing.setStatus(payload.getStatus());
            existing.setUpdatedAt(Instant.now());
            return repo.save(existing);
        });
    }

    public boolean delete(Long id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }
}