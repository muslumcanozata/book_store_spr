package com.store.book.domains.dto;

import com.store.book.domains.entity.Customers;
import com.store.book.domains.enums.Status;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class CustomerCardsDTO {
    private Long id;
    private Customers customers;
    @Size(min = 16, max = 16)
    private String card_number;
    @DateTimeFormat(pattern = "MM/yy")
    private Date expiryDate;
    @Size(min = 3, max = 3)
    private String cvc;
    private String address;
    private Status status;
}
