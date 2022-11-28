package pl.britenet.campus_api.model.builder;

import pl.britenet.campus_api.model.Product;
import pl.britenet.campus_api.model.User;

public class UserBuilder {

    private final User user;

    public UserBuilder(){ this.user = new User(); };

    public User getUser() {
        return  this.user;
    }

    public UserBuilder setIdUser(int idUser) {
        this.user.setIdUser(idUser);
        return this;
    }

    public UserBuilder setName(String name) {
        this.user.setName(name);
        return this;
    }

    public UserBuilder setSurname(String surname) {
        this.user.setSurname(surname);
        return this;
    }

    public UserBuilder setPassword(String password){
        this.user.setPassword(password);
        return this;
    }
    public UserBuilder setNickname(String nickname) {
        this.user.setNickname(nickname);
        return this;
    }

    public UserBuilder setCountry(String country) {
        this.user.setCountry(country);
        return this;
    }

    public UserBuilder setCity(String city) {
        this.user.setCity(city);
        return this;
    }

    public UserBuilder setHomeNumber(String homeNumber) {
        this.user.setHomeNumber(homeNumber);
        return this;
    }

    public UserBuilder setZipCode(String zipCode) {
        this.user.setZipCode(zipCode);
        return this;
    }

    public UserBuilder setPhoneNumber(String phoneNumber){
        this.user.setPhoneNumber(phoneNumber);
        return  this;
    }
    public UserBuilder seteMail(String eMail) {
        this.user.seteMail(eMail);
        return this;
    }
}
