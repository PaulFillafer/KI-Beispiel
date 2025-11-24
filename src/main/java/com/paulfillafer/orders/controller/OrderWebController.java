package com.paulfillafer.orders.controller;

import com.paulfillafer.orders.entity.Order;
import com.paulfillafer.orders.entity.OrderItem;
import com.paulfillafer.orders.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
@RequestMapping("/orders")
public class OrderWebController {
    private final OrderService service;
    public OrderWebController(OrderService service) { this.service = service; }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("orders", service.getAll());
        return "index";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        Order o = new Order();
        OrderItem i = new OrderItem(); i.setQuantity(1); o.setItems(Collections.singletonList(i));
        model.addAttribute("order", o);
        return "order_form";
    }

    @PostMapping
    public String create(@ModelAttribute Order order) {
        service.create(order);
        return "redirect:/orders";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        service.get(id).ifPresent(o -> model.addAttribute("order", o));
        return "order_detail";
    }
}