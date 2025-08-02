package com.osm.finance_service.dto;

import com.osm.finance_service.ennum.SaleStatus;
import com.osm.finance_service.model.OilSale;
import com.xdev.communicator.models.common.dtos.BaseTypeDto;
import com.xdev.communicator.models.production.enums.TypeCategory;
import com.xdev.xdevbase.dtos.BaseDto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * DTO for OilSale entity
 */
public class OilSaleDTO extends BaseDto<OilSale> {

    // ==================== CORE SALE FIELDS ====================

    private String invoiceNumber;
    private SaleStatus status;
    private LocalDateTime saleDate;

    // ==================== CUSTOMER INFORMATION ====================

    private CustomerDto customer;

    // ==================== SUPPLIER INFORMATION ====================

    private SupplierDto supplier;

    // ==================== STORAGE UNIT INFORMATION ====================

    private UUID storageUnit;
    private BaseTypeDto oilType;

    // ==================== QUANTITY & PRICING ====================

    private BigDecimal quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalAmount;
    private String currency;

    // ==================== PAYMENT INFORMATION ====================

    private String paymentMethod;
    private String bankAccount;
    private String checkNumber;
    private String externalTransactionId;

    // ==================== ADDITIONAL INFORMATION ====================

    private String description;
    private LocalDateTime deliveryDate;
    private String deliveryAddress;
    private String deliveryNotes;
    private boolean paid = false;

    // ==================== GETTERS AND SETTERS ====================

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public SaleStatus getStatus() {
        return status;
    }

    public void setStatus(SaleStatus status) {
        this.status = status;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public SupplierDto getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierDto supplier) {
        this.supplier = supplier;
    }

    public UUID getStorageUnit() {
        return storageUnit;
    }

    public void setStorageUnit(UUID storageUnit) {
        this.storageUnit = storageUnit;
    }

    public BaseTypeDto getOilType() {
        return oilType;
    }

    public void setOilType(BaseTypeDto oilType) {
        this.oilType = oilType;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryNotes() {
        return deliveryNotes;
    }

    public void setDeliveryNotes(String deliveryNotes) {
        this.deliveryNotes = deliveryNotes;
    }

    @Override
    public String toString() {
        return "OilSaleDTO{" +
                "id=" + getId() +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", status=" + status +
                ", saleDate=" + saleDate +
                ", customer=" + (customer != null ? customer.getCustomerName() : "null") +
                ", supplier=" + (supplier != null ? supplier.getSupplierInfo().getName() + " " + supplier.getSupplierInfo().getLastname() : "null") +
                ", oilType=" + (oilType != null ? oilType.getName() : "null") +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", totalAmount=" + totalAmount +
                ", currency='" + currency + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    /**
     * DTO for {@link com.osm.finance_service.model.BaseType}
     */
    public static class BaseTypeDto implements Serializable {
        private UUID id;
        private UUID tenantId;
        private Boolean isDeleted = false;
        private String createdBy;
        private LocalDateTime createdDate;
        private String lastModifiedBy;
        private LocalDateTime lastModifiedDate;
        private UUID externalId;
        private String name;
        private String description;
        private TypeCategory type;

        public BaseTypeDto() {
        }

        public BaseTypeDto(UUID id, UUID tenantId, Boolean isDeleted, String createdBy, LocalDateTime createdDate, String lastModifiedBy, LocalDateTime lastModifiedDate, UUID externalId, String name, String description, TypeCategory type) {
            this.id = id;
            this.tenantId = tenantId;
            this.isDeleted = isDeleted;
            this.createdBy = createdBy;
            this.createdDate = createdDate;
            this.lastModifiedBy = lastModifiedBy;
            this.lastModifiedDate = lastModifiedDate;
            this.externalId = externalId;
            this.name = name;
            this.description = description;
            this.type = type;
        }

        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
        }

        public UUID getTenantId() {
            return tenantId;
        }

        public void setTenantId(UUID tenantId) {
            this.tenantId = tenantId;
        }

        public Boolean getIsDeleted() {
            return isDeleted;
        }

        public void setIsDeleted(Boolean isDeleted) {
            this.isDeleted = isDeleted;
        }

        public String getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        public LocalDateTime getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(LocalDateTime createdDate) {
            this.createdDate = createdDate;
        }

        public String getLastModifiedBy() {
            return lastModifiedBy;
        }

        public void setLastModifiedBy(String lastModifiedBy) {
            this.lastModifiedBy = lastModifiedBy;
        }

        public LocalDateTime getLastModifiedDate() {
            return lastModifiedDate;
        }

        public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
        }

        public UUID getExternalId() {
            return externalId;
        }

        public void setExternalId(UUID externalId) {
            this.externalId = externalId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public TypeCategory getType() {
            return type;
        }

        public void setType(TypeCategory type) {
            this.type = type;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BaseTypeDto entity = (BaseTypeDto) o;
            return Objects.equals(this.id, entity.id) &&
                    Objects.equals(this.tenantId, entity.tenantId) &&
                    Objects.equals(this.isDeleted, entity.isDeleted) &&
                    Objects.equals(this.createdBy, entity.createdBy) &&
                    Objects.equals(this.createdDate, entity.createdDate) &&
                    Objects.equals(this.lastModifiedBy, entity.lastModifiedBy) &&
                    Objects.equals(this.lastModifiedDate, entity.lastModifiedDate) &&
                    Objects.equals(this.externalId, entity.externalId) &&
                    Objects.equals(this.name, entity.name) &&
                    Objects.equals(this.description, entity.description) &&
                    Objects.equals(this.type, entity.type);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, tenantId, isDeleted, createdBy, createdDate, lastModifiedBy, lastModifiedDate, externalId, name, description, type);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ", " +
                    "tenantId = " + tenantId + ", " +
                    "isDeleted = " + isDeleted + ", " +
                    "createdBy = " + createdBy + ", " +
                    "createdDate = " + createdDate + ", " +
                    "lastModifiedBy = " + lastModifiedBy + ", " +
                    "lastModifiedDate = " + lastModifiedDate + ", " +
                    "externalId = " + externalId + ", " +
                    "name = " + name + ", " +
                    "description = " + description + ", " +
                    "type = " + type + ")";
        }
    }
}