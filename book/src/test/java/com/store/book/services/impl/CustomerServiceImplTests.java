package com.store.book.services.impl;

import com.store.book.daos.CustomersDao;
import com.store.book.domains.dto.CustomerInsertRequestDTO;
import com.store.book.domains.dto.CustomersDTO;
import com.store.book.domains.entity.Customers;

import com.store.book.mongo.dao.LogDao;
import com.store.book.mongo.model.LogEntity;
import com.store.book.mongo.model.OperationTypes;
import com.store.book.mongo.service.LogService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.*;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.ArgumentMatchers.*;

@RunWith(PowerMockRunner.class)
public class CustomerServiceImplTests {
    @InjectMocks
    private CustomerServiceImpl customerService;
    @Mock
    private CustomersDao customersDao;
    @Mock
    private LogService logService;
    @Mock
    private LogDao logDao;

    private final String TABLE_NAME = "customers";


    @Test
    public void it_should_insert() {
        //given
        String username = "username";
        CustomerInsertRequestDTO customerInsertRequestDTO = new CustomerInsertRequestDTO();
        customerInsertRequestDTO.setName("name");
        Customers customers = Customers.fromInsertRequestDTO(customerInsertRequestDTO);
        Customers expected = customers;
        expected.setId(1L);
        expected.setName("name");
        //when
        Mockito.when(customersDao.save(any(Customers.class))).thenReturn(expected);
        Mockito.doNothing().doThrow(new RuntimeException()).when(logService).insert(anyString(), anyString(), anyString());

        CustomersDTO actual = customerService.insertOne(customerInsertRequestDTO, username);
        //then
        then(actual.getId()).isNotNull();
        then(actual.getName()).isEqualTo(expected.getName());
    }

    @Test
    public void it_should_get_all_rows() {
        //given
        String username = "username";
        Customers customers = new Customers();
        customers.setId(1L);
        customers.setName("name");
        CustomersDTO customersDTO = new CustomersDTO();
        customersDTO.setId(1L);
        customersDTO.setName("name");
        List<Customers> customersList = new ArrayList<>();
        customersList.add(customers);
        customersList.add(customers);
        List<CustomersDTO> customersDTOList = new ArrayList<>();
        customersDTOList.add(customersDTO);
        customersDTOList.add(customersDTO);

        //when
        Mockito.when(customersDao.findAll()).thenReturn(customersList);
        Mockito.doNothing().doThrow(new RuntimeException()).when(logService).insert(anyString(), anyString(), anyString());

        List<CustomersDTO> actual = customerService.getAll(username);

        //then
        then(actual.get(0).getName()).isEqualTo(customersDTOList.get(0).getName());
    }

    @Test
    public void it_should_get_one_by_id() {
        //given
        String username = "username";
        Long id = 1L;
        Customers customers = new Customers();
        customers.setId(id);
        customers.setName("name");
        CustomersDTO customersDTO = new CustomersDTO();
        customersDTO.setId(id);
        customersDTO.setName("name");

        //when
        Mockito.when(customersDao.findById(id)).thenReturn(Optional.of(customers));
        Mockito.doNothing().doThrow(new RuntimeException()).when(logService).insert(anyString(), anyString(), anyString());

        CustomersDTO actual = customerService.getOne(id, username);

        //then
        then(actual.getName()).isEqualTo(customersDTO.getName());
    }
}
