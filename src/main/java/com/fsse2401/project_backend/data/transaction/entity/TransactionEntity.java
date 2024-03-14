package com.fsse2401.project_backend.data.transaction.entity;

import com.fsse2401.project_backend.data.user.entity.UserEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
    @Column(nullable = false)
    private LocalDateTime datetime;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private BigDecimal total;

}
