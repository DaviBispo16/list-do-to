package com.exemplo.list_do_to.repositories;

import com.exemplo.list_do_to.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    UserDetails findByUsername(String username);
    Boolean existsByUsername(String username);

    User findOneByUsername(String username);


}
