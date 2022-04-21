package com.example.project03website.backend;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sheet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sheetId;
    private Integer userId;

    private Integer body_Stat;
    private Integer mind_Stat;

    private String className;
    private String characterNameURL;

    public Sheet(){

    }

    public Sheet(Integer sheetId, Integer userId, Integer body_Stat, Integer mind_Stat, String className, String characterNameURL) {
        this.sheetId = sheetId;
        this.userId = userId;
        this.body_Stat = body_Stat;
        this.mind_Stat = mind_Stat;
        this.className = className;
        this.characterNameURL = characterNameURL;
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

    public Integer getBody_Stat() {
        return body_Stat;
    }

    public void setBody_Stat(Integer body_Stat) {
        this.body_Stat = body_Stat;
    }

    public Integer getMind_Stat() {
        return mind_Stat;
    }

    public void setMind_Stat(Integer mind_Stat) {
        this.mind_Stat = mind_Stat;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCharacterNameURL() {
        return characterNameURL;
    }

    public void setCharacterNameURL(String characterNameURL) {
        this.characterNameURL = characterNameURL;
    }
}
