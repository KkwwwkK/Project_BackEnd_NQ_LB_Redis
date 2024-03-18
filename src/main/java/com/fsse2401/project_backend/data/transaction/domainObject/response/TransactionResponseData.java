package com.fsse2401.project_backend.data.transaction.domainObject.response;

import com.fsse2401.project_backend.data.transaction.entity.TransactionEntity;
import com.fsse2401.project_backend.data.transactionProduct.domainObject.response.TransactionProductResponseData;
import com.fsse2401.project_backend.data.transactionProduct.entity.TransactionProductEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionResponseData {
    private Integer tid;
    private Integer uid;
    private LocalDateTime datetime;
    private String status;
    private BigDecimal total;
    private List<TransactionProductResponseData> items = new ArrayList<>();

    public TransactionResponseData(TransactionEntity transactionEntity) {
        this.tid = transactionEntity.getTid();
        this.uid = transactionEntity.getBuyer().getUid();
        this.datetime = transactionEntity.getDatetime();
        this.status = transactionEntity.getStatus();
        this.total = transactionEntity.getTotal();
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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

    public List<TransactionProductResponseData> getItems() {
        return items;
    }

    public void setItems(List<TransactionProductResponseData> items) {
        this.items = items;
    }
}
