package com.paydunya.paydunyapsrlibrary.Network.Entities;

import com.squareup.moshi.Json;

import java.util.List;

public class Parameters {

    @Json(name = "invoice")
    InvoiceModel invoice;
    @Json(name = "store")
    StoreModel store;




    public InvoiceModel getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceModel invoice) {
        this.invoice = invoice;
    }

    public StoreModel getStore() {
        return store;
    }

    public void setStore(StoreModel store) {
        this.store = store;
    }
}
