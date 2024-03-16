package com.fsse2401.project_backend.data.cartItem.domainObject.response;

import com.fsse2401.project_backend.data.cartItem.entity.CartItemEntity;

import java.math.BigDecimal;

public class UpdateUserCartResponseData {
    private Integer pid;
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private Integer quantity;
    private Integer stock;

    public UpdateUserCartResponseData(CartItemEntity entity) {
        this.pid = entity.getProduct().getPid();
        this.name = entity.getProduct().getName();
        this.imageUrl = entity.getProduct().getImageUrl();
        this.price = entity.getProduct().getPrice();
        this.quantity = entity.getQuantity();
        this.stock = entity.getProduct().getStock();
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
