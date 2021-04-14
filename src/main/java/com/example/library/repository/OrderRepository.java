package com.example.library.repository;

import com.example.library.model.Order;

import java.util.List;

public interface OrderRepository {

    List<Order> getAllOrders();

    List<Order> getUserOrders(String username);

    abstract Order createOrder(Order order);

    Order updateOrder(Long orderId, Order order);

    void deleteOrder(Long orderId);
}
