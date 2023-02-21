package com.test.intern.besoin.domain;

public enum StatusType {

    TERMINE(0),
    EN_COURS(1),;

    private final int value;

    public Integer getValue() {
        return value;
    }

    StatusType(Integer value) {
        this.value = value;
    }

    public static StatusType fromInt(final int statut) {
        StatusType statusType;
        switch (statut) {
            case 0:
                statusType = TERMINE;
                break;
            case 1:
                statusType = EN_COURS;
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + statut);
        }
        return statusType;
    }
}
