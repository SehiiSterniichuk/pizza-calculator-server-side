package com.pizzacalculator.pizzacalculatorserverside.security.repository;

import com.pizzacalculator.pizzacalculatorserverside.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByPhone(String phone);

    boolean existsByPhone(String phone);
}
