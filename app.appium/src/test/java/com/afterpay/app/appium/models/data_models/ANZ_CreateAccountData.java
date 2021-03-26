package com.afterpay.app.appium.models.data_models;

public class ANZ_CreateAccountData {

    private String email = null;
    private String password = null;
    private String mobileNumber = null;
    private String verificationCode = null;
    private String firstName = null;
    private String middleName = null;
    private String lastName = null;
    private String dOBYear = null;
    private String dOBDay = null;
    private String address = null;

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setVerificationCode(String verificationCode){
        this.verificationCode = verificationCode;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName){
        this.middleName = middleName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setDOBYear(String dOBYear){
        this.dOBYear = dOBYear;
    }
    public void setDOBDay(String dOBDay){
        this.dOBDay = dOBDay;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getMobileNumber(){
        return mobileNumber;
    }

    public String getVerificationCode(){
        return verificationCode;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getMiddleName(){
        return middleName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getDOBYear(){
        return dOBYear;
    }

    public String getDOBDay(){
        return dOBDay;
    }

    public String getAddress(){
        return address;
    }

    public String toString(){
        return this.email + ", " + this.password + ", " + this.mobileNumber;
    }

}

