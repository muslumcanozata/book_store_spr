package com.store.book.domains.entity;

import com.store.book.domains.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Entity
@Table(name = "customer_addresses")
public class CustomerAddresses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customers customers;

    @Column(name = "address_name")
    private String addressName;

    @Column(name = "province")
    private String province;

    @Column(name = "district")
    private String district;

    @Column(name = "address")
    private String address;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private Status status;
}
