package com.osm.finance_service.model;

import com.osm.finance_service.ennum.UnitType;
import com.xdev.xdevbase.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "oil_credits")
public class OilCredit extends BaseEntity implements Serializable {


    private LocalDate credit_date;

    private String citerne_pile;

    private String emballage;

    private BigDecimal quantity;

    @Enumerated(EnumType.STRING)
    private UnitType unit;

    private String destinataire;

    public LocalDate getCredit_date() {
        return credit_date;
    }

    public void setCredit_date(LocalDate credit_date) {
        this.credit_date = credit_date;
    }

    public String getCiterne_pile() {
        return citerne_pile;
    }

    public void setCiterne_pile(String citerne_pile) {
        this.citerne_pile = citerne_pile;
    }

    public String getEmballage() {
        return emballage;
    }

    public void setEmballage(String emballage) {
        this.emballage = emballage;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public UnitType getUnit() {
        return unit;
    }

    public void setUnit(UnitType unit) {
        this.unit = unit;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(String destinataire) {
        this.destinataire = destinataire;
    }
}
