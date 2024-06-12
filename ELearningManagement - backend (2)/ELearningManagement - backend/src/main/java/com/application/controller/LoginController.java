package com.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.application.model.Professor;
import com.application.model.Userone;
import com.application.services.ProfessorService;
import com.application.services.UserService;

@RestController
public class LoginController 
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping("/")
    public String welcomeMessage()
    {
    	return "Welcome to Elearning Management system !!!";
    }
	
	@PostMapping("/loginuser")
	@CrossOrigin(origins = "http://localhost:4200")
	public Userone loginUser(@RequestBody Userone user) throws Exception
	{
		String currEmail = user.getEmail();
		String currPassword = user.getPassword();
		
		Userone userObj = null;
		if(currEmail != null && currPassword != null)
		{
			userObj = userService.fetchUserByEmailAndPassword(currEmail, currPassword);
		}
		if(userObj == null)
		{
			throw new Exception("User does not exists!!! Please enter valid credentials...");
		}		
		return userObj;
	}
	
	@PostMapping("/loginprofessor")
	@CrossOrigin(origins = "http://localhost:4200")
	public Professor loginDoctor(@RequestBody Professor professor) throws Exception
	{
		String currEmail = professor.getEmail();
		String currPassword = professor.getPassword();
		String currStatus = professor.getStatus();
		
		Professor professorObj = null;
		if(currEmail != null && currPassword != null)
		{
//			if(this.professorService.getStatusByEmail(currStatus) == "false") {
			professorObj = professorService.fetchProfessorByEmailAndPassword(currEmail, currPassword);
//			}
			
		}
		if(professorObj == null)
		{
			throw new Exception("Professor does not exists!!! Please enter valid credentials...");
		}		
		return professorObj;
	}
}