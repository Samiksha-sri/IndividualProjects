package com.example.Splitwise.repositories;

import com.example.Splitwise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    User save(User entity);

    @Override
    Optional<User> findById(Long userId);


}
