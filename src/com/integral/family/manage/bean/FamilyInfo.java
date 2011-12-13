package com.integral.family.manage.bean;

// Generated Dec 13, 2011 1:16:43 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * FamilyInfo generated by hbm2java
 */
public class FamilyInfo implements java.io.Serializable {

    private String familyId;

    private String familyName;

    private Date familyCreateDate;

    private String familyHouseHolder;

    private String familyAddress;

    private String familyTel;

    public FamilyInfo() {
    }

    public FamilyInfo(String familyId) {
        this.familyId = familyId;
    }

    public FamilyInfo(String familyId, String familyName, Date familyCreateDate, String familyHouseHolder,
            String familyAddress, String familyTel) {
        this.familyId = familyId;
        this.familyName = familyName;
        this.familyCreateDate = familyCreateDate;
        this.familyHouseHolder = familyHouseHolder;
        this.familyAddress = familyAddress;
        this.familyTel = familyTel;
    }

    public String getFamilyId() {
        return this.familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Date getFamilyCreateDate() {
        return this.familyCreateDate;
    }

    public void setFamilyCreateDate(Date familyCreateDate) {
        this.familyCreateDate = familyCreateDate;
    }

    public String getFamilyHouseHolder() {
        return this.familyHouseHolder;
    }

    public void setFamilyHouseHolder(String familyHouseHolder) {
        this.familyHouseHolder = familyHouseHolder;
    }

    public String getFamilyAddress() {
        return this.familyAddress;
    }

    public void setFamilyAddress(String familyAddress) {
        this.familyAddress = familyAddress;
    }

    public String getFamilyTel() {
        return this.familyTel;
    }

    public void setFamilyTel(String familyTel) {
        this.familyTel = familyTel;
    }

}
