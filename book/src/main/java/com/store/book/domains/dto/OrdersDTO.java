package com.store.book.domains.dto;

import com.alibaba.fastjson.JSON;
import com.store.book.domains.entity.Customers;
import com.store.book.domains.entity.Orders;
import com.store.book.domains.enums.DeliveryStatus;
import com.store.book.domains.enums.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
public class OrdersDTO {
    private Integer id;
    private UUID uuid;
    private OrderListDTO orderListDTO;
    private BigDecimal totalPrice;
    private Date deliveryForecast;
    private Customers customers;
    private DeliveryStatus deliveryStatus;
    private Status status;

    public static OrdersDTO fromEntity(Orders orders) {
        return OrdersDTO.builder()
                .id(orders.getId())
                .uuid(orders.getUuid())
                .orderListDTO(JSON.parseObject(orders.getOrderList(), OrderListDTO.class))
                .totalPrice(orders.getTotalPrice())
                .customers(orders.getCustomers())
                .deliveryForecast(orders.getDeliveryForecast())
                .status(orders.getStatus())
                .build();
    }
}
