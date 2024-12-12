package com.example.ParkingLot.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String fname;
    private String email;
    private String password;
    private String platenumber;

    public UserDto() {
    } 
    public UserDto(String fname, String email, String password, String platenumber) {
        this.fname = fname;
        this.email = email;
        this.password = password;
        this.platenumber = platenumber;
    }
    

    
}
