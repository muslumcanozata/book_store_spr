package com.store.book.daos;

import com.store.book.domains.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersDao extends JpaRepository<Orders, Long> {
    List<Orders> getAllByCustomers_Id(Long customerId);
}
