package com.store.book.daos;

import com.store.book.domains.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersDao extends JpaRepository<Customers, Long> {
}
