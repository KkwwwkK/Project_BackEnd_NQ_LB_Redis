package com.fsse2401.project_backend.data.product.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2401.project_backend.data.product.domainObject.response.GetAllProductResponseData;

import java.math.BigDecimal;

public class GetAllProductResponseDto {
    @JsonProperty("pid")
    private Integer pid;
    @JsonProperty("name")
    private String name;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("price")
    private BigDecimal price;
    @JsonProperty("has_stock")
    private boolean hasStock;

    public GetAllProductResponseDto(GetAllProductResponseData data) {
        this.pid = data.getPid();
        this.name = data.getName();
        this.imageUrl = data.getImageUrl();
        this.price = data.getPrice();
        this.hasStock = data.isHasStock();
        // can consider replace isHasStock to "stock > 0"
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

    public void setHasStock(boolean hasStock) {
        this.hasStock = hasStock;
    }
}
