package com.store.book.services.impl;

import com.store.book.daos.CustomersDao;
import com.store.book.domains.dto.CustomerInsertRequestDTO;
import com.store.book.domains.dto.CustomersDTO;
import com.store.book.domains.entity.Customers;
import com.store.book.mongo.model.OperationTypes;
import com.store.book.mongo.service.LogService;
import com.store.book.services.CustomerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomersDao customersDao;

    private LogService logService;

    private final String TABLE_NAME = "customers";

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED,rollbackFor = Exception.class)
    public CustomersDTO insertOne(CustomerInsertRequestDTO customerInsertRequestDTO, String username) {
        logService.insert(OperationTypes.CREATE.getName(), TABLE_NAME, username);
        Customers customers = Customers.fromInsertRequestDTO(customerInsertRequestDTO);
        Customers providedCustomer = customersDao.save(customers);
        return CustomersDTO.fromEntityToDTO(providedCustomer);
    }

    @Override
    public List<CustomersDTO> getAll(String username) {
        logService.insert(OperationTypes.READ.getName(), TABLE_NAME, username);
        List<Customers> customersList = customersDao.findAll();
        return customersList.stream().map(CustomersDTO::fromEntityToDTO).collect(Collectors.toList());
    }

    @Override
    public CustomersDTO getOne(Long id, String username) {
        logService.insert(OperationTypes.READ.getName(), TABLE_NAME, username);
        Optional<Customers> customers = customersDao.findById(id);
        return CustomersDTO.fromEntityToDTO(customers.orElse(new Customers()));
    }

    public Customers getOneInEntity(Long id) {
        Optional<Customers> customers = customersDao.findById(id);
        return customers.orElse(new Customers());
    }
}
