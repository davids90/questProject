package com.example.Services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.User;

public interface UserService extends JpaRepository<User, Integer> {
	
	public List<User> findAllByOrderByDateOfBirthAsc();
	
	public List<User> findAll();
	
	public User findByPps(String pps);
	
	public User save(User user);

}
