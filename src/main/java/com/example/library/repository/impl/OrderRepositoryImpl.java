package com.example.library.repository.impl;

import com.example.library.model.Order;
import com.example.library.model.User;
import com.example.library.repository.OrderRepository;
import com.example.library.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderRepositoryImpl implements OrderRepository {
    private final List<Order> list = new ArrayList<>();
    private final UserRepository userRepository;


    public OrderRepositoryImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return list;
    }

    @Override
    public List<Order> getUserOrders(String username) {
        User user = userRepository.getUser(username);
        return list.stream()
                .filter(order -> order.getUserId() == user.getId())
                .collect(Collectors.toList());
    }

    @Override
    public Order createOrder(Order order) {
        list.add(order);
        return order;
    }

    @Override
    public Order updateOrder(Long orderId, Order order) {
        boolean isDeleted = list.removeIf(o -> order.getId() == orderId);
        if (isDeleted) {
            list.add(order);
        } else {
            throw new RuntimeException("Order does not exists");
        }
        return order;
    }

    @Override
    public void deleteOrder(Long orderId) {
        list.removeIf(order -> order.getId() == orderId);
    }
}
