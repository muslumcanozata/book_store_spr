package com.store.book.domains.entity;

import com.store.book.domains.dto.CustomerInsertRequestDTO;
import com.store.book.domains.dto.CustomersDTO;
import com.store.book.domains.enums.Status;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Email(message = "E-Mail should be valid")
    @Column(name = "email")
    private String email;

    @Pattern(regexp="(^$|[0-9]{10})")
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "customers", fetch = FetchType.LAZY)
    private List<CustomerCards> customerCards;

    @OneToMany(mappedBy = "customers", fetch = FetchType.LAZY)
    private List<CustomerAddresses> customerAddresses;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private Status status;

    public static Customers fromDTO(CustomersDTO customersDTO) {
        Customers customers = new Customers();
        customers.setName(customersDTO.getName());
        customers.setSurname(customersDTO.getSurname());
        customers.setEmail(customersDTO.getEmail());
        customers.setPhoneNumber(customersDTO.getPhoneNumber());
        customers.setStatus(customersDTO.getStatus());
        return customers;
    }

    public static Customers fromInsertRequestDTO(CustomerInsertRequestDTO customerInsertRequestDTO) {
        Customers customers = new Customers();
        customers.setName(customerInsertRequestDTO.getName());
        customers.setSurname(customerInsertRequestDTO.getSurname());
        customers.setEmail(customerInsertRequestDTO.getEmail());
        customers.setPhoneNumber(customerInsertRequestDTO.getPhoneNumber());
        customers.setStatus(customerInsertRequestDTO.getStatus());
        return customers;
    }
}
