package com.surya.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surya.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserId(int id);
}
