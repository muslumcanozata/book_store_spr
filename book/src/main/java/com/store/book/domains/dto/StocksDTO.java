package com.store.book.domains.dto;

import com.store.book.domains.entity.Stocks;
import com.store.book.domains.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StocksDTO {
    private Long id;
    private BooksDTO booksDTO;
    private String author;
    private Status status;
}
