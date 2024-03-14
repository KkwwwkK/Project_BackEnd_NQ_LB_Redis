package com.fsse2401.project_backend.data.product.domainObject.response;

import com.fsse2401.project_backend.data.product.entity.ProductEntity;
import jakarta.persistence.Column;

import java.math.BigDecimal;

public class GetAllProductResponseData {
    private Integer pid;
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private boolean hasStock;

    public GetAllProductResponseData(ProductEntity entity) {
        this.pid = entity.getPid();
        this.name = entity.getName();
        this.imageUrl = entity.getImageUrl();
        this.price = entity.getPrice();
        setHasStock(entity);
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

    public boolean isHasStock() {
        return hasStock;
    }

    public void setHasStock(ProductEntity entity) {
        if(entity.getStock() > 0){
            this.hasStock = true;
        }
    }
}
