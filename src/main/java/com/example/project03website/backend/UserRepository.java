package com.example.project03website.backend;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
    User findUserById(Integer id);


    @Query("SELECT u FROM User u WHERE u.username =?1")
    User findByUsername(String username);

    boolean existsByUsername(String username);
}