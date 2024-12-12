package com.example.ParkingLot.Service;

import java.security.Principal;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.ParkingLot.DTO.UserDto;
import com.example.ParkingLot.Model.User;

public interface UserService extends UserDetailsService{
    User save(UserDto userDto);
    User getUserByEmail(String email);
    int getUserCount();
    void addPlate(@ModelAttribute("user") User user,Model model,Principal principal);
    boolean deletePlate(@ModelAttribute("user") User user,Model model,Principal principal);
    boolean checkPlate(@ModelAttribute("user") User user);
}                   
