package com.osm.finance_service.dto;

import com.osm.finance_service.ennum.Currency;
import com.osm.finance_service.ennum.TransactionDirection;
import com.osm.finance_service.ennum.TransactionType;
import com.osm.finance_service.model.FinancialTransaction;
import com.osm.finance_service.model.PaymentMethod;
import com.osm.finance_service.model.Supplier;
import com.xdev.xdevbase.dtos.BaseDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FinancialTransactionDto extends BaseDto<FinancialTransaction> {
    private TransactionType transactionType;
    private TransactionDirection direction;
    private BigDecimal amount;
    private Currency currency;
    private PaymentMethod paymentMethod;
    private BankAccountDto bankAccount;
    private String checkNumber;
    private String lotNumber;
    private Supplier supplierId;
    private CustomerDto customer;
    private ExpenseDto expense;
    private String description;
    private String invoiceReference;
    private String receiptReference;
    private LocalDateTime transactionDate;
    private Boolean approved;
    private LocalDateTime approvalDate;
    private String approvedBy;

    @Override
    public String toString() {
        return "FinancialTransactionDto{" +
                "transactionType=" + transactionType +
                ", direction=" + direction +
                ", amount=" + amount +
                ", currency=" + currency +
                ", paymentMethod=" + paymentMethod +
                ", bankAccount=" + bankAccount +
                ", checkNumber='" + checkNumber + '\'' +
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

    public BankAccountDto getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccountDto bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
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

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public ExpenseDto getExpense() {
        return expense;
    }

    public void setExpense(ExpenseDto expense) {
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
