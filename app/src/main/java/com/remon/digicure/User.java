package com.remon.digicure;

public class User {
    public String type;
    public String fname;
    public String lname;
    public String tittle;
    public String category;
    public String natioNo;
    public String regiNo;
    public String gender;
    public String email;
    public String pass;

    public User(){

    }
    public User(String type, String fname, String lname,String gender, String email, String pass){
        this.type = type;
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.email = email;
        this.pass = pass;
    }
    public User(String type, String fname, String lname,String tittle, String category,String natioNo, String regiNo,String gender, String email, String pass){
            this.type = type;
            this.fname = fname;
            this.lname = lname;
            this.tittle = tittle;
            this.category = category;
            this.natioNo = natioNo;
            this.regiNo = regiNo;
            this.gender = gender;
            this.email = email;
            this.pass = pass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getNatioNo() {
        return natioNo;
    }

    public void setNatioNo(String natioNo) {
        this.natioNo = natioNo;
    }

    public String getRegiNo() {
        return regiNo;
    }

    public void setRegiNo(String regiNo) {
        this.regiNo = regiNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
