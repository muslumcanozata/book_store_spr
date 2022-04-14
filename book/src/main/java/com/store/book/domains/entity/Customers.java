package com.store.book.domains.entity;

import com.store.book.domains.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
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

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Email(message = "E-Mail should be valid")
    @Column(name = "email")
    private String email;

    @Pattern(regexp="(^$|[0-9]{10})")
    @Column(name = "phone_number")
    private String phone_number;

    @OneToMany(mappedBy = "customers", fetch = FetchType.LAZY)
    private List<CustomerCards> customerCards;

    @OneToMany(mappedBy = "customers", fetch = FetchType.LAZY)
    private List<CustomerAddresses> customerAddresses;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private Status status;
}
