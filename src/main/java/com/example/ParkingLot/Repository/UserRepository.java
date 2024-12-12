package com.example.ParkingLot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ParkingLot.Model.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.platenumber=?1")
     User findByPlatenumber(String plateNo);
}
