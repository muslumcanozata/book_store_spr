package com.store.book.domains.dto;

import com.store.book.domains.entity.Books;
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

    public static BooksDTO fromEntity(Books books) {
        BooksDTO booksDTO = new BooksDTO();
        booksDTO.setId(books.getId());
        booksDTO.setStocks(books.getStocks());
        booksDTO.setBookName(books.getBookName());
        booksDTO.setAuthor(books.getAuthor());
        booksDTO.setPublisher(books.getPublisher());
        booksDTO.setPrice(books.getPrice());
        booksDTO.setStatus(books.getStatus());
        return booksDTO;
    }
}
