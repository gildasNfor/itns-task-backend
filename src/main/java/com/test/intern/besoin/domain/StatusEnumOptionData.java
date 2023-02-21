package com.test.intern.besoin.domain;

import java.io.Serializable;

public class StatusEnumOptionData implements Serializable {

    private final Long id;
    private final String value;

    public StatusEnumOptionData(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
