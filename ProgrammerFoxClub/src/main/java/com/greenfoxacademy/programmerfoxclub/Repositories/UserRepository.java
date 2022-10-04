package com.greenfoxacademy.programmerfoxclub.Repositories;

import com.greenfoxacademy.programmerfoxclub.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User existsUserByUsername(String username);


}
