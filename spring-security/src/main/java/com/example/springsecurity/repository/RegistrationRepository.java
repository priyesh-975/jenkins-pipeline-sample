package com.example.springsecurity.repository;

import com.example.springsecurity.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Integer> {
    public Registration findByUsername(String username);
}
