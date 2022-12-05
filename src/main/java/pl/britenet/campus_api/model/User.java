package pl.britenet.campus_api.model;

public class User {

    private int idUser;
    private String name;
    private String surname;
    private String password;
    private String nickname;
    private String country;
    private String city;
    private String homeNumber;
    private String zipCode;
    private String phoneNumber;
    private String eMail;

    public User(){};

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return
                "\nidUser=" + idUser +
                "\name='" + name +
                "\nsurname='" + surname +
                "\npassword='" + password +
                "\nnickname='" + nickname +
                "\ncountry='" + country +
                "\ncity='" + city +
                "\nhomeNumber='" + homeNumber +
                "\nzipCode='" + zipCode +
                "\nphoneNumber='" + phoneNumber +
                "\neMail='" + eMail;
    }
}
