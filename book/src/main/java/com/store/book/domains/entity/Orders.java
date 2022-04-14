package com.store.book.domains.entity;

import com.store.book.domains.enums.DeliveryStatus;
import com.store.book.domains.enums.Status;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private Integer id;

    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "uuid", updatable = false, nullable = false)
    private UUID uuid;

    @Column(name = "order_list")
    private String orderList;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "delivery_forecast", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date deliveryForecast;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customers customers;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "delivery_status")
    private DeliveryStatus deliveryStatus;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private Status status;
}
