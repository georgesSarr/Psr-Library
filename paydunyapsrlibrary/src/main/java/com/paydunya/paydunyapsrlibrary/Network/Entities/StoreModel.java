package com.paydunya.paydunyapsrlibrary.Network.Entities;

import com.squareup.moshi.Json;

public class StoreModel {

    @Json(name = "name")
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
