package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Person {
    private String fullName;
    private LocalDate dateOfBirth;
    private String dob;
    private boolean gender;
    private long identityCardNum;
    private String phoneNumber;
    private String mail;
    private String address;
    public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Person() {
    }

    public Person(String fullName, String dateOfBirth, boolean gender, long identityCardNum, String phoneNumber, String mail, String address) {
        this.fullName = fullName;
        this.dateOfBirth = LocalDate.parse(dateOfBirth,dateTimeFormatter);
        this.dob = dateOfBirth;
        this.gender = gender;
        this.identityCardNum = identityCardNum;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = LocalDate.parse(dateOfBirth,dateTimeFormatter);
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public long getIdentityCardNum() {
        return identityCardNum;
    }

    public void setIdentityCardNum(long identityCardNum) {
        this.identityCardNum = identityCardNum;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public static DateTimeFormatter getDateTimeFormatter() {
        return dateTimeFormatter;
    }

    public static void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
        Person.dateTimeFormatter = dateTimeFormatter;
    }
}
