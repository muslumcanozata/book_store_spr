package com.store.book.domains.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class StockUpdateRequestDTO {
    @NotNull
    private Long bookId;
    @NotNull
    private Integer amount;
}
