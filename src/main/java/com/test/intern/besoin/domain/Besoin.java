package com.test.intern.besoin.domain;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Document("besoin")
public class Besoin {

    @Id
    private String id;
    private String date;
    private String description;
    private String status;
    private byte[] file;
    private String offre;
    private String date_envoi;
    private String date_rappel;
    private boolean file_present;
    private String content_type;


    public void setFile_present(boolean file_present) {
        this.file_present = file_present;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public Besoin(String id, String date, String description, String status, byte[] file, String offre, String date_envoi, String date_rappel, boolean file_present, String content_type) {
        super();
        this.id = id;
        this.date = date;
        this.description = description;
        this.status = status;
        this.file = file;
        this.offre = offre;
        this.date_envoi = date_envoi;
        this.date_rappel = date_rappel;
        this.file_present = file_present;
        this.content_type = content_type;
    }

    public Besoin(String date, String description, String status, String offre, String date_envoi, String date_rappel) {
        super();
        this.date = date;
        this.description = description;
        this.status = status;
        this.offre = offre;
        this.date_envoi = date_envoi;
        this.date_rappel = date_rappel;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getOffre() {
        return offre;
    }

    public void setOffre(String offre) {
        this.offre = offre;
    }

    public String getDate_envoi() {
        return date_envoi;
    }

    public void setDate_envoi(String date_envoi) {
        this.date_envoi = date_envoi;
    }

    public String getDate_rappel() {
        return date_rappel;
    }

    public void setDate_rappel(String date_rappel) {
        this.date_rappel = date_rappel;
    }

    public boolean isFile_present() {
        return file_present;
    }

    public String getContent_type() {
        return content_type;
    }
}
