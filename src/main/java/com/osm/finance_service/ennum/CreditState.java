package com.osm.finance_service.ennum;

public enum CreditState {
    /**
     * A credit request has been created but not yet reviewed.
     */
    PENDING,


    /**
     * The approved credit has been applied to the storage unit/account.
     */
    APPROVED,

    /**
     * The credit has been fully settled/closed (e.g. invoiced or paid off).
     */
    SETTLED,

}
