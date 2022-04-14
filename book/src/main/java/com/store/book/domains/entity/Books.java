package com.store.book.domains.entity;

import com.store.book.domains.enums.Status;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private Long id;

    @OneToOne(mappedBy = "books")
    private Stocks stocks;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "author")
    private String author;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "price")
    private BigDecimal price;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private Status status;
}
