package com.fsse2401.project_backend.data.transactionProduct.domainObject.response;

import com.fsse2401.project_backend.data.product.domainObject.response.ProductResponseData;
import com.fsse2401.project_backend.data.product.entity.ProductEntity;
import com.fsse2401.project_backend.data.transactionProduct.entity.TransactionProductEntity;
import com.fsse2401.project_backend.service.ProductService;
import com.fsse2401.project_backend.util.TransactionProductDataUtil;

import java.math.BigDecimal;

public class TransactionProductResponseData {
    private Integer tpid;
    private ProductResponseData product;
    private Integer quantity;
    private BigDecimal subtotal;

    public TransactionProductResponseData(TransactionProductEntity entity) {
        this.tpid = entity.getTpid();
        this.quantity = entity.getQuantity();
        setProduct(entity);
        this.subtotal = entity.getPrice().
                multiply(BigDecimal.valueOf(entity.getQuantity()));
    }

    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
    }

    public ProductResponseData getProduct() {
        return product;
    }

    public void setProduct(TransactionProductEntity entity) {
        this.product = new ProductResponseData(
                new ProductEntity(
                        entity
                )
        );
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}
