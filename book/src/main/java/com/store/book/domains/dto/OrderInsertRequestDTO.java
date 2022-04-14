package com.store.book.domains.dto;

import com.store.book.domains.enums.DeliveryStatus;
import com.store.book.domains.enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class OrderInsertRequestDTO {
    private Long customerId;
    private OrderListDTO orderListDTO;
    private BigDecimal totalPrice;
    private Date deliveryForecast;
    private DeliveryStatus deliveryStatus;
    private Status status;
}
