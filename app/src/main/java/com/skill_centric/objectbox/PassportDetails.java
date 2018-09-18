package com.skill_centric.objectbox;

import java.util.Date;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class PassportDetails {

    @Id
    private long number;
    private int code;
    private String registrationAddress;
    private Date dateOfBirth;

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getRegistrationAddress() {
        return registrationAddress;
    }

    public void setRegistrationAddress(String registrationAddress) {
        this.registrationAddress = registrationAddress;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "PassportDetails{" +
                "number=" + number +
                ", code=" + code +
                ", registrationAddress='" + registrationAddress + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
