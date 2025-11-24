package com.paulfillafer.orders.repository;

import com.paulfillafer.orders.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}