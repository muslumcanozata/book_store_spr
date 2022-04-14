package com.store.book.services;

import com.store.book.domains.dto.CustomerInsertRequestDTO;
import com.store.book.domains.dto.CustomersDTO;

import java.util.List;

public interface CustomerService {
    CustomersDTO insertOne(CustomerInsertRequestDTO customerInsertRequestDTO, String username);

    List<CustomersDTO> getAll(String username);

    CustomersDTO getOne(Long id, String username);
}
