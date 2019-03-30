/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author jafar.j
 */
public class PhoneUserFull {
    
    private String phoneUserNumber = "boş";
    private String phoneUserName = "boş";
    private String phoneUserNameAZE = "boş";
    private String phoneUserDepartment = "boş";
    private String phoneUserSpecialty = "boş";
    private String phoneUserStructure = "boş";
    private String phoneUserEmail = "boş";

    public PhoneUserFull(){}
    
    public String getPhoneUserNumber() {
        return this.phoneUserNumber;
    }

    public void setPhoneUserNumber(String phoneUserNumber) {
        this.phoneUserNumber = phoneUserNumber;
    }

    public String getPhoneUserName() {
        return this.phoneUserName;
    }

    public void setPhoneUserName(String phoneUserName) {
        this.phoneUserName = phoneUserName;
    }

    public String getPhoneUserNameAZE() {
        return this.phoneUserNameAZE;
    }

    public void setPhoneUserNameAZE(String phoneUserNameAZE) {
        this.phoneUserNameAZE = phoneUserNameAZE;
    }

    public String getPhoneUserDepartment() {
        return this.phoneUserDepartment;
    }

    public void setPhoneUserDepartment(String phoneUserDepartment) {
        this.phoneUserDepartment = phoneUserDepartment;
    }

    public String getPhoneUserSpecialty() {
        return this.phoneUserSpecialty;
    }

    public void setPhoneUserSpecialty(String phoneUserSpecialty) {
        this.phoneUserSpecialty = phoneUserSpecialty;
    }

    public String getPhoneUserStructure() {
        return this.phoneUserStructure;
    }

    public void setPhoneUserStructure(String phoneUserStructure) {
        this.phoneUserStructure = phoneUserStructure;
    }
    
    public String getPhoneUserEmail(){
        return this.phoneUserEmail;
    }

    public void setPhoneUserEmail(String phoneUserEmail) {
        this.phoneUserEmail = phoneUserEmail;
    }
    
}
