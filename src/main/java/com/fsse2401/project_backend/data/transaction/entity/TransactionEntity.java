package com.fsse2401.project_backend.data.transaction.entity;

import com.fsse2401.project_backend.constant.TransactionStatus;
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
    private UserEntity buyer;
    @Column(nullable = false)
    private LocalDateTime datetime;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private BigDecimal total;

    public TransactionEntity() {
    }
    public TransactionEntity(UserEntity user) {
        this.buyer = user;
        this.datetime = LocalDateTime.now();
        this.status = TransactionStatus.PREPARE.toString();
        total = BigDecimal.ZERO;
    }



    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public UserEntity getBuyer() {
        return buyer;
    }

    public void setBuyer(UserEntity buyer) {
        this.buyer = buyer;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
