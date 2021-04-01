package edu.escuelaing.service4All.backend.model;


public class User {
    private String firstname;
    private String lastname;
    private String email;
    private String cedula;
    private String category;
    private String city;
    private String password;

    public User() {
    }

    public User(String firstname, String lastname, String email, String cedula, String category, String city, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.cedula = cedula;
        this.category = category;
        this.city = city;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
