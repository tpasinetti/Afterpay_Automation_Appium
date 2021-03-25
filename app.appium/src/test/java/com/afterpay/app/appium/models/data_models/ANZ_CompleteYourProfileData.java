package com.afterpay.app.appium.models.data_models;

public class ANZ_CompleteYourProfileData {
    
    private String firstName = null;
    private String lastName = null;

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String toString(){
        return this.firstName + ", " + this.lastName;
    }
}
