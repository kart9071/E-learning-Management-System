package com.application.services;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.application.model.Professor;
import com.application.repository.ProfessorRepository;

@Service
public class ProfessorService 
{
	@Autowired
	private ProfessorRepository professorRepo;
	
	public Professor saveProfessor(Professor professor)
	{
		return professorRepo.save(professor);
	}
	
	public Professor addNewProfessor(Professor professor)
	{
		return professorRepo.save(professor);
	}
	
	public Professor updateProfessorProfile(Professor professor)
	{
		return professorRepo.save(professor);
	}
	
	public List<Professor> getAllProfessors()
	{
		return (List<Professor>)professorRepo.findAll();
	}
	
	public List<Professor> getProfessorListByEmail(String email) 
	{
		return (List<Professor>)professorRepo.findProfessorListByEmail(email);
	}
	
	public Professor fetchProfessorByEmail(String email)
	{
		return professorRepo.findByEmail(email);
	}
	
	public Professor fetchProfessorByProfessorname(String professorname)
	{
		return professorRepo.findByProfessorname(professorname);
	}
	
	public Professor fetchProfessorByEmailAndPassword(String email, String password)
	{
		return professorRepo.findByEmailAndPassword(email, password);
	}
	
	public List<Professor> fetchProfileByEmail(String email)
	{
		return (List<Professor>)professorRepo.findProfileByEmail(email);
	}

	public void updateStatus(String email) 
	{
		professorRepo.updateStatus(email);
	}

	public void rejectStatus(String email) 
	{
		professorRepo.rejectStatus(email);
	}
	public void deleteStatus(String email) 
	{
		professorRepo.deleteStatus(email);
	}
public void deleteProfessorByEmail(String email)
	{
	professorRepo.deleteProfessorByEmail(email);
	}

	public List<Professor> getProfessorsByEmail(String email)
	{
		return professorRepo.findProfessorListByEmail(email);
	}

	public void deleteUserByEmail(String email) {
		// TODO Auto-generated method stub
		
	}

	public XSSFWorkbook createExcelSheet(List<Professor> professors) {
	    // create a new workbook
	    XSSFWorkbook workbook = new XSSFWorkbook();

	    // create a new sheet
	    XSSFSheet sheet = workbook.createSheet("Professors");

	    // create a header row
	    XSSFRow headerRow = sheet.createRow(0);
	    headerRow.createCell(0).setCellValue("Email");
	    headerRow.createCell(1).setCellValue("Professor Name");
	    headerRow.createCell(2).setCellValue("Professor ID");
	    headerRow.createCell(3).setCellValue("Degree Completed");
	    headerRow.createCell(4).setCellValue("Institution Name");
	    headerRow.createCell(5).setCellValue("Department");
	    headerRow.createCell(6).setCellValue("Experience");
	    headerRow.createCell(7).setCellValue("Mobile");
	    headerRow.createCell(8).setCellValue("Gender");
	    headerRow.createCell(9).setCellValue("Password");
	    headerRow.createCell(10).setCellValue("Status");

	    // write the data to the sheet
	    int rowNum = 1;
	    for (Professor professor : professors) {
	        XSSFRow row = sheet.createRow(rowNum++);
	        row.createCell(0).setCellValue(professor.getEmail());
	        row.createCell(1).setCellValue(professor.getProfessorname());
	        row.createCell(2).setCellValue(professor.getProfessorid());
	        row.createCell(3).setCellValue(professor.getDegreecompleted());
	        row.createCell(4).setCellValue(professor.getInstitutionname());
	        row.createCell(5).setCellValue(professor.getDepartment());
	        row.createCell(6).setCellValue(professor.getExperience());
	        row.createCell(7).setCellValue(professor.getMobile());
	        row.createCell(8).setCellValue(professor.getGender());
	        row.createCell(9).setCellValue(professor.getPassword());
	        row.createCell(10).setCellValue(professor.getStatus());
	    }

	    return workbook;
	}



//	public String getStatusByEmail(String currStatus) {
//		// TODO Auto-generated method stub
//		return professorRepo.getStatusByEmail(currStatus);
//	}
	
//	public String getStatusByEmail(String email) {
//			return professorRepo.getStatusByEmail(email);
//	}
//	public void updateResetPasswordToken(String token, String email) throws ClassNotFoundException {
//        Professor professor = professorRepo.findByEmail(email);
//        if (professor != null) {
//        	professor.setResetPasswordToken(token);
//        	professorRepo.save(professor);
//        } else {
//            throw new ClassNotFoundException("Could not find any customer with the email " + email);
//        }
//    }
//	public Professor getByResetPasswordToken(String token) {
//        return professorRepo.findByResetPasswordToken(token);
//    }
//	public void updatePassword(Professor customer, String newPassword) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode(newPassword);
//        customer.setPassword(encodedPassword);
//         
//        customer.setResetPasswordToken(null);
//        professorRepo.save(customer);
//    }
	
	
	
}