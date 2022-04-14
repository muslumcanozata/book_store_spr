package com.store.book.domains.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderListDTO {
    private Long bookId;
    private BigDecimal bookPrice;
    private Integer amount;
    private BigDecimal totalPrice;
}
