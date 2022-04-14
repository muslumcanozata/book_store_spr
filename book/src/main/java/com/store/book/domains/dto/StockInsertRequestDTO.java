package com.store.book.domains.dto;

import com.store.book.domains.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class StockInsertRequestDTO {
    @NotNull
    private Long id;
    @NotNull
    private Long bookId;
    @NotNull
    private Integer amount;
    @NotNull
    private Status status;
}
