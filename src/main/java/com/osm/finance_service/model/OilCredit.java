package com.osm.finance_service.model;

import com.osm.finance_service.ennum.CreditState;
import com.osm.finance_service.ennum.UnitType;
import com.xdev.xdevbase.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "oil_credits")
public class OilCredit extends BaseEntity implements Serializable {

    private String emballage;

    private Double quantity;

    @Enumerated(EnumType.STRING)
    private UnitType unit;
    private UUID oil_type;
    private UUID destinataire;
    private UUID transaction_id_in;
    private UUID transaction_id_out;
    @Enumerated(EnumType.STRING)
    private CreditState creditState = CreditState.PENDING;

    public UUID getTransaction_id_in() {
        return transaction_id_in;
    }

    public void setTransaction_id_in(UUID transaction_id_in) {
        this.transaction_id_in = transaction_id_in;
    }

    public UUID getTransaction_id_out() {
        return transaction_id_out;
    }

    public void setTransaction_id_out(UUID transaction_id_out) {
        this.transaction_id_out = transaction_id_out;
    }


    public String getEmballage() {
        return emballage;
    }

    public void setEmballage(String emballage) {
        this.emballage = emballage;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public UnitType getUnit() {
        return unit;
    }

    public void setUnit(UnitType unit) {
        this.unit = unit;
    }

    public UUID getOil_type() {
        return oil_type;
    }

    public void setOil_type(UUID oil_type) {
        this.oil_type = oil_type;
    }

    public UUID getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(UUID destinataire) {
        this.destinataire = destinataire;
    }


    public CreditState getCreditState() {
        return creditState;
    }

    public void setCreditState(CreditState creditState) {
        this.creditState = creditState;
    }
}
