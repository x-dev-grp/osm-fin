package com.osm.finance_service.dto;

import com.osm.finance_service.ennum.UnitType;
import com.osm.finance_service.model.OilCredit;
import com.xdev.xdevbase.dtos.BaseDto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OilCreditDto extends BaseDto<OilCredit> {


    private String emballage;
    private BigDecimal quantity;
    private UnitType unit;
    private String destinataire;
    private LocalDate credit_date;
    private String citerne_pile;


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
}