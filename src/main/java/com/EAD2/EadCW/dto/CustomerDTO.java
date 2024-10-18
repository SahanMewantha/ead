package com.EAD2.EadCW.dto;

public class CustomerDTO {
    private int id;
    private String name;
    private String email;

    public CustomerDTO(){
        id=0;name="";email="none@email.com";
    }
    public CustomerDTO(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
