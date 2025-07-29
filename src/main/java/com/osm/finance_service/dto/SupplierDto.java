package com.osm.finance_service.dto;

import com.osm.finance_service.model.Supplier;
import com.xdev.communicator.models.common.dtos.BaseTypeDto;
import com.xdev.xdevbase.dtos.BaseDto;

public class SupplierDto extends BaseDto<Supplier> {
    private SupplierInfoDto supplierInfo;
    private BaseTypeDto genericSupplierType;
    private Boolean hasStorage;

    public Boolean getHasStorage() {
        return hasStorage;
    }

    public void setHasStorage(Boolean hasStorage) {
        this.hasStorage = hasStorage;
    }



    public SupplierInfoDto getSupplierInfo() {
        return supplierInfo;
    }

    public void setSupplierInfo(SupplierInfoDto supplierInfo) {
        this.supplierInfo = supplierInfo;
    }

    public BaseTypeDto getGenericSupplierType() {
        return genericSupplierType;
    }

    public void setGenericSupplierType(BaseTypeDto genericSupplierType) {
        this.genericSupplierType = genericSupplierType;
    }
}