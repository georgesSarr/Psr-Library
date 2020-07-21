package com.paydunya.paydunyapsrlibrary.Network.Entities;

import com.squareup.moshi.Json;

import java.util.List;

public class InvoiceModel {

    @Json(name = "total_amount")
    Integer totalAmount;
    @Json(name = "description")
    String description;

    @Json(name = "channels")
    List<String> channels;

    public List<String> getChannels() {
        return channels;
    }

    public void setChannels(List<String> channels) {
        this.channels = channels;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
