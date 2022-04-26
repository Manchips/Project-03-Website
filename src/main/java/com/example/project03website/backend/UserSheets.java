package com.example.project03website.backend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserSheets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private Integer savedSheetsId;
    private Integer userSheetsId;

    public UserSheets(){

    }

    public UserSheets(Integer userId, Integer savedSheetsId, Integer userSheetsId) {
        this.userId = userId;
        this.savedSheetsId = savedSheetsId;
        this.userSheetsId = userSheetsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSavedSheetsId() {
        return savedSheetsId;
    }

    public void setSavedSheetsId(Integer savedSheetsId) {
        this.savedSheetsId = savedSheetsId;
    }

    public Integer getUserSheetsId() {
        return userSheetsId;
    }

    public void setUserSheetsId(Integer userSheetsId) {
        this.userSheetsId = userSheetsId;
    }
}
