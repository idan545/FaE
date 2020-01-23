package com.example.fae;

import com.google.firebase.auth.FirebaseAuth;
public class Users{
    private String stEmail, stPhone, uid;

    public Users(){}
    public Users(String stEmail, String stPhone,String uid){
        this.stEmail=stEmail;
        this.stPhone=stPhone;
        this.uid=uid;
    }
    public String getEmail(){
        return stEmail;
    }
    public void setEmail(String stEmail){
        this.stEmail=stEmail;
    }
    public String getPhone(){
        return stPhone;
    }
    public void setPhone(String stPhone){
        this.stPhone=stPhone;
    }
    public String getUid(){
        return uid;
    }
    public void setUid(String uid){
        this.uid=uid;
    }
}