package com.store.book.services.impl;

import com.store.book.daos.OrdersDao;
import com.store.book.domains.dto.OrderInsertRequestDTO;
import com.store.book.domains.dto.OrdersDTO;
import com.store.book.domains.entity.Customers;
import com.store.book.domains.entity.Orders;
import com.store.book.mongo.model.OperationTypes;
import com.store.book.mongo.service.LogService;
import com.store.book.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrdersDao ordersDao;

    @Autowired
    CustomerServiceImpl customerServiceImpl;

    @Autowired
    private LogService logService;

    private final String TABLE_NAME = "orders";

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,isolation= Isolation.READ_UNCOMMITTED,rollbackFor = Exception.class)
    public OrdersDTO insertOne(OrderInsertRequestDTO orderInsertRequestDTO, String username) {
        logService.insert(OperationTypes.CREATE.getName(), TABLE_NAME, username);
        Customers customers = customerServiceImpl.getOneInEntity(orderInsertRequestDTO.getCustomerId());
        Orders orders = Orders.fromInsertRequestDTO(orderInsertRequestDTO, customers);
        Orders providedOrders = ordersDao.save(orders);
        return OrdersDTO.fromEntity(providedOrders);
    }

    @Override
    public OrdersDTO getOne(Long id, String username) {
        logService.insert(OperationTypes.READ.getName(), TABLE_NAME, username);
        Optional<Orders> orders = ordersDao.findById(id);
        return OrdersDTO.fromEntity(orders.orElse(new Orders()));
    }

    @Override
    public List<OrdersDTO> getAllByCustomerId(Long customerId, String username) {
        logService.insert(OperationTypes.READ.getName(), TABLE_NAME, username);
        List<Orders> orders = ordersDao.getAllByCustomers_Id(customerId);
        return orders.parallelStream().map(OrdersDTO::fromEntity).collect(Collectors.toList());
    }

    @Override
    public List<OrdersDTO> getAll(String username) {
        logService.insert(OperationTypes.READ.getName(), TABLE_NAME, username);
        List<Orders> ordersList = ordersDao.findAll();
        return ordersList.parallelStream().map(OrdersDTO::fromEntity).collect(Collectors.toList());
    }
}
