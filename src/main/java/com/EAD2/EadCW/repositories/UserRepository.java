package com.EAD2.EadCW.repositories;

import com.EAD2.EadCW.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
