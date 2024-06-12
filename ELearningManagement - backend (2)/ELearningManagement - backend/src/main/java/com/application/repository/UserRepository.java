package com.application.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.application.model.Userone;

public interface UserRepository extends CrudRepository<Userone, String>
{
	
    public Userone findByEmail(String email);
	
	public Userone findByUsername(String username);
	
	public Userone findByEmailAndPassword(String email, String password);
	
	public List<Userone> findProfileByEmail(String email);

	public void deleteUserByEmail(String email);
	
	@Transactional
	@Modifying
	@Query(value = "update userone set status = 'accept' where email = ?1", nativeQuery = true)
	public void updateStatus(String email);
	
	@Transactional
	@Modifying
	@Query(value = "update userone set status = 'reject' where email = ?1", nativeQuery = true)
	public void rejectStatus(String email);
	
}