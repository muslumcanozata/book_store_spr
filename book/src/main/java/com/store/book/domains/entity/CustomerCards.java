package com.store.book.domains.entity;

import com.store.book.domains.enums.Status;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "customer_cards")
public class CustomerCards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customers customers;

    @Size(min = 16, max = 16)
    @Column(name = "card_number")
    private String card_number;

    @DateTimeFormat(pattern = "MM/yy")
    @Column(name = "expiry_date")
    private Date expiryDate;

    @Size(min = 3, max = 3)
    @Column(name = "cvc")
    private String cvc;

    @Column(name = "address")
    private String address;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private Status status;
}
