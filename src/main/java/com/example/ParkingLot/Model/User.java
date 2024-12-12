package com.example.ParkingLot.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user" , uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;

     private String fname;
     private String email;
     private String password;
     private String platenumber;
     

    public User(){
    }

    public User(String fname, String email, String password, String platenumber) {
        this.fname = fname;
        this.email = email;
        this.password = password;
        this.platenumber = platenumber;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPlatenumber() {
        return platenumber;
    }

    public void setPlatenumber(String platenumber) {
        this.platenumber = platenumber;
    }

    
}
