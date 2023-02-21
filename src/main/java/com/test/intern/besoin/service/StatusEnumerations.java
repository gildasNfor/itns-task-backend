package com.test.intern.besoin.service;

import com.test.intern.besoin.domain.StatusEnumOptionData;
import com.test.intern.besoin.domain.StatusType;

public class StatusEnumerations {

    public static StatusEnumOptionData statusType(final int id) {
        return statusType(StatusType.fromInt(id));
    }

    public static StatusEnumOptionData statusType(final StatusType type) {
        StatusEnumOptionData optionData = null;
        switch (type) {
            case TERMINE:
                optionData = new StatusEnumOptionData(StatusType.TERMINE.getValue().longValue(),"Terminé");
                break;
            case EN_COURS:
                optionData = new StatusEnumOptionData(StatusType.EN_COURS.getValue().longValue(), "en cours");
                break;
        }
        return optionData;
    }
}
