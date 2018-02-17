/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 17 Feb 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/Jackson-Test/
 **/
package com;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PendingChallan {

    @JsonProperty("CHALLAN_NO")
    private String challanNo;

    @JsonProperty("UNIT_CODE")
    private String unitCode;

    @JsonProperty("REGN_NO")
    private String regnNo;

    @JsonProperty("OFFENCE_DATE")
    private String offenceDate;

    @JsonProperty("OFF_TIME")
    private String offTime;

    @JsonProperty("BOOKED_POLICE_STATION_NAME")
    private String bookedPoliceStationName;

    @JsonProperty("PLACE_OF_VIOLATION")
    private String placeOfViolation;

    @JsonProperty("VIOLATIONS")
    private String violations;

    @JsonProperty("ACTUAL_AMOUNT")
    private String actualAmount;

    @JsonProperty("USER_CHARGES")
    private String userCharges;

    @JsonProperty("COMPOUNDING_AMOUNT")
    private String compoundingAmount;

    @JsonProperty("TOKEN")
    private String token;

    public String getChallanNo() {
        return challanNo;
    }

    public void setChallanNo(String challanNo) {
        this.challanNo = challanNo;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getRegnNo() {
        return regnNo;
    }

    public void setRegnNo(String regnNo) {
        this.regnNo = regnNo;
    }

    public String getOffenceDate() {
        return offenceDate;
    }

    public void setOffenceDate(String offenceDate) {
        this.offenceDate = offenceDate;
    }

    public String getOffTime() {
        return offTime;
    }

    public void setOffTime(String offTime) {
        this.offTime = offTime;
    }

    public String getBookedPoliceStationName() {
        return bookedPoliceStationName;
    }

    public void setBookedPoliceStationName(String bookedPoliceStationName) {
        this.bookedPoliceStationName = bookedPoliceStationName;
    }

    public String getPlaceOfViolation() {
        return placeOfViolation;
    }

    public void setPlaceOfViolation(String placeOfViolation) {
        this.placeOfViolation = placeOfViolation;
    }

    public String getViolations() {
        return violations;
    }

    public void setViolations(String violations) {
        this.violations = violations;
    }

    public String getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(String actualAmount) {
        this.actualAmount = actualAmount;
    }

    public String getUserCharges() {
        return userCharges;
    }

    public void setUserCharges(String userCharges) {
        this.userCharges = userCharges;
    }

    public String getCompoundingAmount() {
        return compoundingAmount;
    }

    public void setCompoundingAmount(String compoundingAmount) {
        this.compoundingAmount = compoundingAmount;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "PendingChallans{" +
                "challanNo='" + challanNo + '\'' +
                ", unitCode='" + unitCode + '\'' +
                ", regnNo='" + regnNo + '\'' +
                ", offenceDate='" + offenceDate + '\'' +
                ", offTime='" + offTime + '\'' +
                ", bookedPoliceStationName='" + bookedPoliceStationName + '\'' +
                ", placeOfViolation='" + placeOfViolation + '\'' +
                ", violations='" + violations + '\'' +
                ", actualAmount='" + actualAmount + '\'' +
                ", userCharges='" + userCharges + '\'' +
                ", compoundingAmount='" + compoundingAmount + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

}
