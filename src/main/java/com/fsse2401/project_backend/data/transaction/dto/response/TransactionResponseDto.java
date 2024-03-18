package com.fsse2401.project_backend.data.transaction.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2401.project_backend.data.transaction.domainObject.response.TransactionResponseData;
import com.fsse2401.project_backend.data.transactionProduct.domainObject.response.TransactionProductResponseData;
import com.fsse2401.project_backend.data.transactionProduct.dto.response.TransactionProductResponseDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionResponseDto {
    @JsonProperty("tid")
    private Integer tid;
    @JsonProperty("buyer_id")
    private Integer uid;
    @JsonProperty("datetime")
    private LocalDateTime datetime;
    @JsonProperty("status")
    private String status;
    @JsonProperty("total")
    private BigDecimal total;
    @JsonProperty("Items")
    private List<TransactionProductResponseDto> items = new ArrayList<>();

    public TransactionResponseDto(TransactionResponseData data) {
        this.tid = data.getTid();
        this.uid = data.getUid();
        this.datetime = data.getDatetime();
        this.status = data.getStatus();
        this.total = data.getTotal();
        setItems(data);
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

    public List<TransactionProductResponseDto> getItems() {
        return items;
    }

    public void setItems(TransactionResponseData data) {
        for(TransactionProductResponseData transactionProductResponseData: data.getItems()){
            this.items.add(new TransactionProductResponseDto(transactionProductResponseData));
        }
    }
}
