package com.example.shop.order;

import com.example.shop.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "orders")

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "point_used")
    private int pointUsed;

    @Column(name = "cash_amount")
    private int cashAmount;

    @Column(name = "status")
    private String status;

//
//    public Order(Long id, Member member, LocalDate orderDate, int totalPrice, int pointUsed, int cashAmount, String status) {
//        this.id = id;
//        this.member = member;
//        this.orderDate = orderDate;
//        this.totalPrice = totalPrice;
//        this.pointUsed = pointUsed;
//        this.cashAmount = cashAmount;
//        this.status = status;
//    }
}
