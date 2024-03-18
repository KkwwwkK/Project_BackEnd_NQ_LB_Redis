package com.fsse2401.project_backend.data.product.entity;

import com.fsse2401.project_backend.data.transactionProduct.entity.TransactionProductEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer pid;

    @Column(nullable = false)
    private String name;

    private String description;

    private String imageUrl;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private Integer stock;

    public ProductEntity() {
    }

    public ProductEntity(TransactionProductEntity entity) {
        setPid(entity.getPid());
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.imageUrl = entity.getImageUrl();
        this.price = entity.getPrice();
        this.stock = entity.getStock();
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
}
