package com.afterpay.app.appium.models.data_models;

public class ANZ_CreateAccountData {

    private String email = null;
    private String password = null;
    private String mobileNumber = null;
    private String firstName = null;


    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
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

    public String getFirstName(){
        return firstName;
    }

    public String toString(){
        return this.email + ", " + this.password + ", " + this.mobileNumber;
    }

}

