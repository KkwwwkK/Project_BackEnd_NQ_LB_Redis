package com.fsse2401.project_backend.data.transactionProduct.entity;

import com.fsse2401.project_backend.data.cartItem.entity.CartItemEntity;
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
    private TransactionEntity tansaction;
    @Column(nullable = false)
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

    public TransactionProductEntity() {
    }

    public TransactionProductEntity(TransactionEntity transactionEntity, CartItemEntity cartItemEntityentity) {
        this.tansaction = transactionEntity;
        this.pid = cartItemEntityentity.getProduct().getPid();
        this.name = cartItemEntityentity.getProduct().getName();
        this.description = cartItemEntityentity.getProduct().getDescription();
        this.imageUrl = cartItemEntityentity.getProduct().getImageUrl();
        this.price = cartItemEntityentity.getProduct().getPrice();
        this.stock = cartItemEntityentity.getProduct().getStock();
        this.quantity = cartItemEntityentity.getQuantity();
    }

    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
    }

    public TransactionEntity getTansaction() {
        return tansaction;
    }

    public void setTansaction(TransactionEntity tansaction) {
        this.tansaction = tansaction;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
