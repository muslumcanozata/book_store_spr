package com.store.book.domains.dto;

import com.store.book.domains.entity.Stocks;
import com.store.book.domains.enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class StocksDTO {
    private Long id;
    private BooksDTO booksDTO;
    private Integer amount;
    private Status status;

    public static StocksDTO fromEntity(Stocks stocks) {
        StocksDTO stocksDTO = new StocksDTO();
        stocksDTO.setId(stocksDTO.getId());
        stocksDTO.setBooksDTO(BooksDTO.fromEntity(stocks.getBooks()));
        stocksDTO.setAmount(stocks.getAmount());
        stocksDTO.setStatus(stocks.getStatus());
        return stocksDTO;
    }
}
