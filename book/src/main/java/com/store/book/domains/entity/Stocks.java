package com.store.book.domains.entity;

import com.store.book.domains.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "stocks")
public class Stocks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Books books;

    @Column(name = "amount")
    private String author;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private Status status;
}
