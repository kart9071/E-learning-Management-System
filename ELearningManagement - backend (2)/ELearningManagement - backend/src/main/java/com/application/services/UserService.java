package com.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.application.model.Userone;
import com.application.repository.UserRepository;

@Service
public class UserService 
{
	@Autowired
	private UserRepository userRepo;
	
	public Userone saveUser(Userone user)
	{
		return userRepo.save(user);
	}
	
	public Userone updateUserProfile(Userone user)
	{
		return userRepo.save(user);
	}
	
	public List<Userone> getAllUsers()
	{
		return (List<Userone>)userRepo.findAll();
	}
	
	public Userone fetchUserByEmail(String email)
	{
		return userRepo.findByEmail(email);
	}
	
	public Userone fetchUserByUsername(String username)
	{
		return userRepo.findByUsername(username);
	}
	
	public Userone fetchUserByEmailAndPassword(String email, String password)
	{
		return userRepo.findByEmailAndPassword(email, password);
	}
	
	public List<Userone> fetchProfileByEmail(String email)
	{
		return (List<Userone>)userRepo.findProfileByEmail(email);
	}
	public void deleteUserByEmail(String email)
	{
		userRepo.deleteUserByEmail(email);
	}

	public void rejectStatus(String email) {
		
		userRepo.rejectStatus(email);
	}

	public void updateStatus(String email) {
		userRepo.updateStatus(email);
		
	}
}