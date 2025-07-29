package com.osm.finance_service.model;

import com.osm.finance_service.ennum.Currency;
import com.osm.finance_service.ennum.TransactionDirection;
import com.osm.finance_service.ennum.TransactionType;
import com.xdev.xdevbase.entities.BaseEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Universal Financial Transaction Model
 * Handles all types of financial operations in the OSM system
 */
@Entity
@Table(name = "financial_transactions")
public class FinancialTransaction extends BaseEntity implements Serializable {

    // ==================== CORE TRANSACTION FIELDS ====================


    /**
     * Transaction type (PAYMENT, EXPENSE, CREDIT, DEBIT, TRANSFER, etc.)
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType transactionType;


    /**
     * Transaction direction (INBOUND, OUTBOUND, INTERNAL)
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionDirection direction;

    // ==================== AMOUNT & CURRENCY FIELDS ====================

    /**
     * Primary amount in base currency
     */
    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal amount;

    /**
     * Currency code (MAD, USD, EUR, etc.)
     */
    @Enumerated(EnumType.STRING)
    private Currency currency;


    // ==================== PAYMENT METHOD FIELDS ====================

    /**
     * Payment method used
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethod paymentMethod;

    /**
     * Bank account used (if applicable)
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private BankAccount bankAccount;

    /**
     * Check number (if payment method is CHECK)
     */
    private String checkNumber;

    /**
     * Transaction ID from external system (bank transfer, etc.)
     */
    private String externalTransactionId;


    /**
     * Related delivery ID (for delivery-based transactions)
     */
    private String lotNumber;

    /**
     * Related supplier ID
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Supplier supplierId;

    /**
     * Related customer
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @OneToOne(fetch = FetchType.LAZY)
    private Expense expense;

    // ==================== METADATA FIELDS ====================

    /**
     * Transaction description
     */
    @Column(length = 100)
    private String description;

    /**
     * Invoice reference (if applicable)
     */
    private String invoiceReference;

    /**
     * Receipt reference (if applicable)
     */
    private String receiptReference;

    /**
     * Transaction date
     */
    @Column(nullable = false)
    private LocalDateTime transactionDate;

    /**
     * Approval status
     */
    private Boolean approved = false;

    /**
     * Approval date
     */
    private LocalDateTime approvalDate;

    /**
     * Approved by user ID
     */
    private String approvedBy;

    @Override
    public String toString() {
        return "FinancialTransaction{" +
                "transactionType=" + transactionType +
                ", direction=" + direction +
                ", amount=" + amount +
                ", currency=" + currency +
                ", paymentMethod=" + paymentMethod +
                ", bankAccount=" + bankAccount +
                ", checkNumber='" + checkNumber + '\'' +
                ", externalTransactionId='" + externalTransactionId + '\'' +
                ", lotNumber='" + lotNumber + '\'' +
                ", supplierId=" + supplierId +
                ", customer=" + customer +
                ", expense=" + expense +
                ", description='" + description + '\'' +
                ", invoiceReference='" + invoiceReference + '\'' +
                ", receiptReference='" + receiptReference + '\'' +
                ", transactionDate=" + transactionDate +
                ", approved=" + approved +
                ", approvalDate=" + approvalDate +
                ", approvedBy='" + approvedBy + '\'' +
                '}';
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public TransactionDirection getDirection() {
        return direction;
    }

    public void setDirection(TransactionDirection direction) {
        this.direction = direction;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public String getExternalTransactionId() {
        return externalTransactionId;
    }

    public void setExternalTransactionId(String externalTransactionId) {
        this.externalTransactionId = externalTransactionId;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public Supplier getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Supplier supplierId) {
        this.supplierId = supplierId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInvoiceReference() {
        return invoiceReference;
    }

    public void setInvoiceReference(String invoiceReference) {
        this.invoiceReference = invoiceReference;
    }

    public String getReceiptReference() {
        return receiptReference;
    }

    public void setReceiptReference(String receiptReference) {
        this.receiptReference = receiptReference;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public LocalDateTime getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(LocalDateTime approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }
}