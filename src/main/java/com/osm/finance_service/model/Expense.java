package com.osm.finance_service.model;


import com.xdev.xdevbase.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "expenses")
public class Expense extends BaseEntity implements Serializable {


    @Column(name = "invoice_ref")
    private String invoiceRef;

    @Column(name = "purchase_nature", nullable = false)
    private String purchaseNature;

    @Column(name = "object_desc")
    private String object;

    @Column(name = "expense_date", nullable = false)
    private LocalDate date;

    @Column(name = "amount", nullable = false)
    private Double amount;

    public String getInvoiceRef() {
        return invoiceRef;
    }

    public void setInvoiceRef(String invoiceRef) {
        this.invoiceRef = invoiceRef;
    }

    public String getPurchaseNature() {
        return purchaseNature;
    }

    public void setPurchaseNature(String purchaseNature) {
        this.purchaseNature = purchaseNature;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
