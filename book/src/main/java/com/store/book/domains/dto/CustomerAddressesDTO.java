package com.store.book.domains.dto;

import com.store.book.domains.entity.Customers;
import com.store.book.domains.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerAddressesDTO {
    private Long id;
    private Customers customers;
    private String addressName;
    private String province;
    private String district;
    private String address;
    private Status status;
}
