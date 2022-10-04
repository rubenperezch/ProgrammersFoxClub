package com.greenfoxacademy.programmerfoxclub.Repositories;

import com.greenfoxacademy.programmerfoxclub.Models.Fox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoxRepository extends JpaRepository<Fox, Long> {
}
