package com.store.book.domains.dto;

import com.store.book.domains.entity.Stocks;
import com.store.book.domains.enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BooksDTO {
    private Long id;
    private Stocks stocks;
    private String bookName;
    private String author;
    private String publisher;
    private BigDecimal price;
    private Status status;
}
