package com.exemplo.list_do_to.repositories;

import com.exemplo.list_do_to.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, String> {
    UserDetails findByUsername(String username);
    Boolean existsByUsername(String username);
}
