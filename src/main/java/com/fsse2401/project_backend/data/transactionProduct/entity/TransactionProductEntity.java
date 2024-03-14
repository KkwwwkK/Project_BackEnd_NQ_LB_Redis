package com.fsse2401.project_backend.data.transactionProduct.entity;

import com.fsse2401.project_backend.data.transaction.entity.TransactionEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "transaction_product")
public class TransactionProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tpid;

    @ManyToOne
    @JoinColumn(name = "transaction_id", nullable = false)
    private TransactionEntity transaction;

    // To Check
    private Integer pid;

    @Column(nullable = false)
    private String name;
    private String description;
    private String imageUrl;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private Integer stock;
    @Column(nullable = false)
    private Integer quantity;


}
