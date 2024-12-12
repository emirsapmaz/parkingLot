package com.example.ParkingLot.Controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ParkingLot.DTO.UserDto;
import com.example.ParkingLot.Model.User;
import com.example.ParkingLot.Repository.UserRepository;
import com.example.ParkingLot.Service.UserService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {

    @Autowired
	private UserService userService;

    @Autowired
    private UserRepository userRepository;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
    @GetMapping("/")
    public String index(Model model, Principal principal) {
        final int parkCapacity=100;
        // Get the currently authenticated user's email from Principal
        String email = principal.getName();
        // Retrieve the user from the service
        User user = userService.getUserByEmail(email);
        // Add user to the model
        int userCount = userService.getUserCount();
        model.addAttribute("user", user);
        model.addAttribute("available", (parkCapacity-userCount));
        model.addAttribute("occupied", (userCount));
        return "index";
    }

    @PostMapping("/addPlate")
    public String addPlate(@ModelAttribute("user") User user,Model model,Principal principal){
        // String email = principal.getName();
        // User u = userService.getUserByEmail(email);
        // u.setPlatenumber(user.getPlatenumber());
        // userRepository.save(u);
        userService.addPlate(user,model, principal);
        return "redirect:/?plateadded";
    }

    @PostMapping("/deletePlate")
    public String deletePlate(@ModelAttribute("user") User user,Model model,Principal principal){
        if(userService.deletePlate(user,model, principal))
            return "redirect:/?platedeleted";
        else
            return "redirect:/?noplatedeleted";
    }

    @PostMapping("/checkPlate")
    public String checkPlate(@ModelAttribute("user") User user){
        if(userService.checkPlate(user))
            return "redirect:/?platechecked";
        else
            return "redirect:/?noplatechecked";
    }

    /*
    @PostMapping("/addplate")
    public String addPlate(@RequestParam("plateNumber") String plateNo,Model model,Principal principal) {
        // Get the currently authenticated user's email from Principal
        String email = principal.getName();
        // Retrieve the user from the service
        User user = userService.getUserByEmail(email);
        user.setPlatenumber(plateNo);
        return "redirect:/index?success"; 
    }*/

/* 
    @PostMapping("/addPlate")
    @ResponseBody
    public Map<String, String> addPlate(@RequestParam("plateNumber") String plateNumber) {
        Map<String, String> response = new HashMap<>();
        UserDto user = new UserDto();
        user.setPlatenumber(plateNumber);
        userService.save(user);
        response.put("message", "Plate number added successfully!");
        return response;
    }
  */  
}

