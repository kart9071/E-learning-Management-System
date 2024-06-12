package com.application.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.application.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, String>
{
	
	
    public Professor findByEmail(String email);
    
    public List<Professor> findProfessorListByEmail(String email);
	
	public Professor findByProfessorname(String professorname);
	
	public Professor findByEmailAndPassword(String email, String password);
	
	public List<Professor> findProfileByEmail(String email);
	
//	public List<Professor> findByEmailContaining(String email);
	
	@Transactional
	@Modifying
	@Query(value = "delete from professor where email = ?1", nativeQuery = true)
	public void deleteProfessorByEmail(String email);
	
	
	@Transactional
	@Modifying
	@Query(value = "update professor set status = 'accept' where email = ?1", nativeQuery = true)
	public void updateStatus(String email);
	
	@Transactional
	@Modifying
	@Query(value = "update professor set status = 'reject' where email = ?1", nativeQuery = true)
	public void rejectStatus(String email);
	
	@Transactional
	@Modifying
	@Query(value = "update professor set status = 'delete' where email = ?1", nativeQuery = true)
	public void deleteStatus(String email);

	
	
	
//	@Query("SELECT c FROM professor c WHERE c.email = ?1")
//    public Professor findByEmail(String email); 
     
//    public Professor findByResetPasswordToken(String token);
	
	
//	@Query(value = "select p from Professor p where p.status = 'accept' and p.email=?1 ", nativeQuery = true)
//	public String getStatusByEmail(String email);
	
}