package com.mandana.firstspringbootproject.repositories;

import com.mandana.firstspringbootproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
