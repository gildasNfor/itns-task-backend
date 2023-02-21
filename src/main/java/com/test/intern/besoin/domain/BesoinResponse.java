package com.test.intern.besoin.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class BesoinResponse {

    private String id;
    private String date;
    private String description;
    private String status;
    private String offre;
    private String date_envoi;
    private String date_rappel;
    private boolean file_present;
    private String error;

    public BesoinResponse(String id,String date, String description, String status, String offre, String date_envoi, String date_rappel,boolean file_present) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.status = status;
        this.offre = offre;
        this.date_envoi = date_envoi;
        this.date_rappel = date_rappel;
        this.file_present = file_present;
    }

    public BesoinResponse(String error) {
        this.error = error;
    }
}

