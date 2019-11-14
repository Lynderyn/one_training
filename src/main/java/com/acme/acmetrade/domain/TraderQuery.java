package com.acme.acmetrade.domain;

import java.util.Optional;

public class TraderQuery {
    
    private Optional<String> id = Optional.empty();
    private Optional<String> fName = Optional.empty();
    private Optional<String> lName = Optional.empty();
    private Optional<String> phone = Optional.empty();
    private Optional<String> email = Optional.empty();
    private Optional<String> address = Optional.empty();

    public TraderQuery() {
    }

    public TraderQuery(String id, String fName, String lName, String phone, String email, String address) {
        this.id = Optional.of(id);
        this.fName = Optional.of(fName);
        this.lName = Optional.of(lName);
        this.phone = Optional.of(phone);
        this.email = Optional.of(email);
        this.address = Optional.of(address);
    }

    public Optional<String> getId() {
        return id;
    }

    public void setId(String id) {
        this.id = Optional.of(id);
    }

    public Optional<String> getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = Optional.of(fName);
    }

    public Optional<String> getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = Optional.of(lName);
    }

    public Optional<String> getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = Optional.of(phone);
    }

    public Optional<String> getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = Optional.of(email);
    }

    public Optional<String> getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = Optional.of(address);
    }
}
