package com.example.ParkingLot.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.ParkingLot.DTO.UserDto;
import com.example.ParkingLot.Model.User;
import com.example.ParkingLot.Repository.UserRepository;
import com.example.ParkingLot.Service.UserService;
import com.example.ParkingLot.Service.UserServiceImpl;

import ch.qos.logback.core.joran.conditional.ElseAction;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//@RequestMapping("/register")
@Controller
public class UserController {
    
    private UserService userService;
    private UserServiceImpl userDetailsService;

    public UserController(UserService userService){
        this.userService=userService;
    }


    @ModelAttribute("user")
    public UserDto userDto(){
        return new UserDto();
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") UserDto userDto){
        User user = userService.save(userDto);
        // if(user != null)
        //     return "redirect:/login";
        // else 
            return "redirect:/login?success";

    }

    @GetMapping ("/register")
    public String register() {
        return "register";
    }

    
    // @PostMapping("/login")
    // public void loginUser(@ModelAttribute UserDto userDto, Model model) {
    //     userDetailsService.lo
    // }
    

	// @PostMapping("/login")
	// public void login(@ModelAttribute UserDto userLoginDTO, Model model) {
	// 	userDetailsService.loadUserByUsername(userLoginDTO.getEmail());
	// }
    // @GetMapping("/login")
    //   public String login() {
    //       return "login";
    //   }
    // @GetMapping("/register")
    // public String register() {
    //     return "register";
    // }
    

    // @GetMapping
    // public List<User> getAllUsers(){
    //     return userRepository.findAll();
    // }


    // @GetMapping
    // public User getUser(){
    //     return userRepository.find
    // }


            // @PostMapping
            // public User creatUser(@RequestBody User newUser){
            //     return userRepository.save(newUser);
            // }
            // @GetMapping
            // public User getUser(@RequestBody String plate) {
            //     return userRepository.findByPlatenumber(plate);
            // }
            

            // @DeleteMapping
            // public void deletUser(@RequestBody User deletUser){
            //     userRepository.delete(deletUser);
            // }
    //  @GetMapping
    //  public User getPlateNumber(@RequestBody User newUser){
    //      User user = userRepository.findByPlatenumber(newUser.getPlatenumber());
         
    //      return user;
    //  }
    
    
    
}
