package com.example.project03website.backend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SavedSheets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sheetId;
    private Integer userId;
    private Integer savedSheetId;

    public SavedSheets(){

    }

    public SavedSheets(Integer sheetId, Integer userId) {
        this.sheetId = sheetId;
        this.userId = userId;
    }

    public SavedSheets(Integer sheetId, Integer userId, Integer savedSheetId) {
        this.sheetId = sheetId;
        this.userId = userId;
        this.savedSheetId = savedSheetId;
    }

    public Integer getSheetId() {
        return sheetId;
    }

    public void setSheetId(Integer sheetId) {
        this.sheetId = sheetId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSavedSheetId() {
        return savedSheetId;
    }

    public void setSavedSheetId(Integer savedSheetId) {
        this.savedSheetId = savedSheetId;
    }
}
