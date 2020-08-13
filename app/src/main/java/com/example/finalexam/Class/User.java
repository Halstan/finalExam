package com.example.finalexam.Class;

public class User {

    private Integer idUser;
    private String nombre;
    private String username;
    private String password;

    public User(Integer idUser, String nombre, String username, String password) {
        this.idUser = idUser;
        this.nombre = nombre;
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
