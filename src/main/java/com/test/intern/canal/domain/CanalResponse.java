package com.test.intern.canal.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CanalResponse {

    private Canal canal;
    private String error;

    public CanalResponse(Canal canal) {
        this.canal = canal;
    }

    public CanalResponse(String error) {
        this.error = error;
    }
}

