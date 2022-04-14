package com.store.book.services;

import com.store.book.domains.dto.OrderInsertRequestDTO;
import com.store.book.domains.dto.OrdersDTO;

import java.util.List;

public interface OrderService {
    OrdersDTO insertOne(OrderInsertRequestDTO orderInsertRequestDTO, String username);

    OrdersDTO getOne(Long id, String username);

    List<OrdersDTO> getAllByCustomerId(Long customerId, String username);

    List<OrdersDTO> getAll(String username);
}
