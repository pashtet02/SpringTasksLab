package com.example.library.mapper;

import com.example.library.dto.OrderDto;
import com.example.library.model.Order;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.factory.Mappers;

public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toOrder(OrderDto orderDto);

    @InheritInverseConfiguration
    OrderDto toOrderDto(Order order);
}
