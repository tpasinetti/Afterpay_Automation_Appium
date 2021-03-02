package com.afterpay.app.appium.models.data_models;

public class ANZ_CreateAccountData {

    private String email = null;
    private String password = null;
    private String mobileNumber = null;

    public ANZ_CreateAccountData withEmail(String email) {
        setEmail(email);
        return this;
    }

    public ANZ_CreateAccountData withPassword(String password) {
        setPassword(password);
        return this;
    }

    public ANZ_CreateAccountData withMobileNumber(String mobileNumber) {
        setMobileNumber(mobileNumber);
        return this;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String toString(){
        return this.email + ", " + this.password + ", " + this.mobileNumber;
    }

}

