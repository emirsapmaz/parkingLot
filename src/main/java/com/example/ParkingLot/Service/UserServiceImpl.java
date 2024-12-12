package com.example.ParkingLot.Service;

import java.security.Principal;
import java.util.Collections;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.ParkingLot.DTO.UserDto;
import com.example.ParkingLot.Model.User;
import com.example.ParkingLot.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getFname(),userDto.getEmail(),userDto.getPassword(),userDto.getPlatenumber()); 
        return userRepository.save(user);
    }


    @Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	
		User user = userRepository.findByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),Collections.emptyList());		
	}

   

	@Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public int getUserCount() {
        return (int) userRepository.count();
    }

    // @Override
    // public User getPlateNumber(String plateNumber) {
    //     return userRepository.findByPlatenumber(plateNumber);
    // }

    public User getUser(Model model,Principal principal){
        String email = principal.getName();
        User u = getUserByEmail(email);
        return u;
    }
    @Override
    public void addPlate(@ModelAttribute("user") User user,Model model,Principal principal){
        User u = getUser(model, principal);
        u.setPlatenumber(user.getPlatenumber());
        userRepository.save(u);
    }

    @Override
    public boolean deletePlate(@ModelAttribute("user") User user,Model model, Principal principal) {
        if(checkPlate(user)){
            User u = getUser(model, principal);
            u.setPlatenumber(null);
            userRepository.save(u);
            return true;
        }else
            return false;


    }

    @Override
    public boolean checkPlate(@ModelAttribute("user") User user) {
        User u=userRepository.findByPlatenumber(user.getPlatenumber());
        if(u == null) {
			return false;
		}else
            return true;
    }
    
    
}
