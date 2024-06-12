package com.application.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.application.model.Chapter;
import com.application.model.chapter_1;
import com.application.model.Course;
import com.application.model.Professor;
import com.application.model.Userone;
import com.application.model.Wishlist;
import com.application.repository.CourseRepository;
import com.application.repository.ProfessorRepository;
import com.application.services.ChapterService;
import com.application.services.CourseService;
import com.application.services.ProfessorService;
import com.application.services.WishlistService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProfessorController 
{	
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private ChapterService chapterService;
	
	@Autowired
	private WishlistService wishlistService;
	
	@GetMapping("/professorlist")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Professor>> getProfessorList() throws Exception
	{
		List<Professor> professors = professorService.getAllProfessors();
		return new ResponseEntity<List<Professor>>(professors, HttpStatus.OK);
	}
	
	@GetMapping("/youtubecourselist")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Course>> getYoutubeCourseList() throws Exception
	{
		List<Course> youtubeCourseList = courseService.fetchByCoursetype("Youtube");
//		for(Course list:youtubeCourseList)
//		{
//			System.out.println(list.getYoutubeurl());
//		}
		return new ResponseEntity<List<Course>>(youtubeCourseList, HttpStatus.OK);
	}
	
	@GetMapping("/websitecourselist")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Course>> getWebsiteCourseList() throws Exception
	{
		List<Course> websiteCourseList = courseService.fetchByCoursetype("Website");
		return new ResponseEntity<List<Course>>(websiteCourseList, HttpStatus.OK);
	}
	
	@GetMapping("/courselistbyname/{coursename}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Course>> getCourseListByName(@PathVariable String coursename) throws Exception
	{
		Course courseList = courseService.fetchCourseByCoursename(coursename);
		System.out.println(courseList.getCoursename()+" ");
		List<Course> courselist = new ArrayList<>();
		courselist.add(courseList);
		return new ResponseEntity<List<Course>>(courselist, HttpStatus.OK);
	}
	
	@GetMapping("/professorlistbyemail/{email}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Professor>> getProfessorListByEmail(@PathVariable String email) throws Exception
	{
		List<Professor> professors = professorService.getProfessorsByEmail(email);
		return new ResponseEntity<List<Professor>>(professors, HttpStatus.OK);
	}
	
	@PostMapping("/addProfessor")
	@CrossOrigin(origins = "http://localhost:4200")
	public Professor addNewProfessor(@RequestBody Professor professor) throws Exception
	{
		Professor professorObj = null;
		String newID = getNewID();
		professor.setProfessorid(newID);
		professorObj = professorService.addNewProfessor(professor);
		professorService.updateStatus(professor.getEmail());
		return professorObj;
	}
	
	@DeleteMapping("/dele/{email}")
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteProfessorByEmail(@PathVariable String email)
	{
		professorService.deleteProfessorByEmail(email);
	}
	
	
	
//	 @DeleteMapping("/del/{email}")
//	 @CrossOrigin(origins = "http://localhost:4200")
//	 public ResponseEntity<HttpStatus> deleteProfessor(@PathVariable("email") String email)  {
//	 	try {
//	 		professorRepository.deleteById(email);
//	 		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	 	}catch (Exception e) {
//	 			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	 	}
//	 }
	
	@PostMapping("/addCourse")
	@CrossOrigin(origins = "http://localhost:4200")
	public Course addNewCourse(@RequestBody Course course) throws Exception
	{
		Course courseObj = null;
		String newID = getNewID();
		course.setCourseid(newID);
		
		courseObj = courseService.addNewCourse(course);
		return courseObj;
	}
	
//	@PostMapping("/addnewchapter")
//	@CrossOrigin(origins = "http://localhost:4200")
//	public Chapter addNewChapters(@RequestParam String coursename, @RequestBody Chapter chapter) throws Exception
//	{
//		chapter.setCoursename(coursename);
//		Chapter chapterObj = null;
//		chapterObj = chapterService.addNewChapter(chapter);
//		return chapterObj;
//	}
//	
//	@PostMapping("/upload")
//	@CrossOrigin(origins = "http://localhost:4200")
//	public ResponseEntity<String> uploadVideo(@RequestParam("file") List<MultipartFile> file) {
//	try {
//	chapterService.saveVideos(file);
//	return ResponseEntity.ok().body("{\"message\": \"Video uploaded successfully!\"}");
//	} catch (Exception e) {
//	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload video: " + e.getMessage());
//	}
//	}
	
	@PostMapping("/addnewchapter")
	@CrossOrigin(origins = "http://localhost:4200")
	public Chapter addNewChapters(@RequestBody Chapter chapter) throws Exception
	{
		Chapter chapterObj = null;
		chapterObj = chapterService.addNewChapter(chapter);
		return chapterObj;
	}
	@PostMapping("/upload")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<String> uploadVideo(@RequestParam ("file") List<MultipartFile> file, @RequestParam("coursename") String coursename)
	{
		System.out.println("Course Name: " + coursename);
	try {
	chapterService.saveVideos(file, coursename);
	return ResponseEntity.ok().body("{\"message\": \"Video uploaded successfully!\"}");
	} catch (Exception e) {
	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload video: " + e.getMessage());
	}
	}
	
	@GetMapping(value = "/videos/{id}/{chaptername}")
	public ResponseEntity<Resource> getChapterVideo(@PathVariable("id") Integer id, @PathVariable("chaptername") String chapterName) {
	    Chapter chapter = chapterService.getChapterById(id);

	    if (chapter != null) {
	        Map<String, byte[]> chapterMap = new HashMap<>();
	        chapterMap.put(chapter.getChapter1name(), chapter.getChapter1id());
	        chapterMap.put(chapter.getChapter2name(), chapter.getChapter2id());
	        chapterMap.put(chapter.getChapter3name(), chapter.getChapter3id());
	        chapterMap.put(chapter.getChapter4name(), chapter.getChapter4id());
	        chapterMap.put(chapter.getChapter5name(), chapter.getChapter5id());
	        chapterMap.put(chapter.getChapter6name(), chapter.getChapter6id());
	        chapterMap.put(chapter.getChapter7name(), chapter.getChapter7id());
	        chapterMap.put(chapter.getChapter8name(), chapter.getChapter8id());
	       

	        if (chapterMap.containsKey(chapterName)) {
	            byte[] videoData = chapterMap.get(chapterName);
	           
	            if (videoData != null) {
	                ByteArrayResource resource = new ByteArrayResource(videoData);
	                HttpHeaders headers = new HttpHeaders();
	                headers.add(HttpHeaders.CONTENT_TYPE, "video/mp4");
	                headers.add(HttpHeaders.CONTENT_LENGTH, String.valueOf(videoData.length));
	                return ResponseEntity.ok().headers(headers).body(resource);
	            }
	        }
	    }

	    return ResponseEntity.notFound().build();
	}


	
	@GetMapping("/acceptstatus/{email}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<String>> updateStatus(@PathVariable String email) throws Exception
	{
		professorService.updateStatus(email);
		List<String> al=new ArrayList<>();
		al.add("accepted");
		return new ResponseEntity<List<String>>(al,HttpStatus.OK);
	}
	
	@GetMapping("/rejectstatus/{email}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<String>> rejectStatus(@PathVariable String email) throws Exception
	{
		professorService.rejectStatus(email);
		List<String> al=new ArrayList<>();
		al.add("rejected");
		return new ResponseEntity<List<String>>(al,HttpStatus.OK);
	}
	
	@DeleteMapping("/deletestatus/{email}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<String>> deleteStatus(@PathVariable String email) throws Exception
	{
		professorService.deleteStatus(email);
		List<String> al=new ArrayList<>();
		al.add("deleted");
		return new ResponseEntity<List<String>>(al,HttpStatus.OK);
	}
	@GetMapping("/professorprofileDetails/{email}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Professor>> getProfileDetails(@PathVariable String email) throws Exception
	{
		List<Professor> professors = professorService.fetchProfileByEmail(email);
		return new ResponseEntity<List<Professor>>(professors, HttpStatus.OK);
	}
	
	@PutMapping("/updateprofessor")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Professor> updateProfessorProfile(@RequestBody Professor professor) throws Exception
	{
		Professor professorobj = professorService.updateProfessorProfile(professor);
		return new ResponseEntity<Professor>(professorobj, HttpStatus.OK);
	}
	
	@GetMapping("/gettotalprofessors")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Integer>> getTotalProfessors() throws Exception
	{
		List<Professor> professors = professorService.getAllProfessors();
		List<Integer> professorsCount = new ArrayList<>();
		professorsCount.add(professors.size());
		return new ResponseEntity<List<Integer>>(professorsCount, HttpStatus.OK);
	}
	
	@GetMapping("/gettotalchapters")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Integer>> getTotalChapters() throws Exception
	{
		List<Chapter> chapters = chapterService.getAllChapters();
		List<Integer> chaptersCount = new ArrayList<>();
		chaptersCount.add(chapters.size());
		return new ResponseEntity<List<Integer>>(chaptersCount, HttpStatus.OK);
	}
	
	@GetMapping("/gettotalcourses")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Integer>> getTotalCourses() throws Exception
	{
		List<Course> courses = courseService.getAllCourses();
		List<Integer> coursesCount = new ArrayList<>();
		coursesCount.add(courses.size());
		return new ResponseEntity<List<Integer>>(coursesCount, HttpStatus.OK);
	}
	
	@GetMapping("/gettotalwishlist")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Integer>> getTotalWishlist() throws Exception
	{
		List<Wishlist> wishlists = wishlistService.getAllLikedCourses();
		List<Integer> wishlistCount = new ArrayList<>();
		wishlistCount.add(wishlists.size());
		return new ResponseEntity<List<Integer>>(wishlistCount, HttpStatus.OK);
	}
  
  @GetMapping("/getcoursenames")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<String>> getCourseNames() throws Exception
	{
		List<Course> courses = courseService.getAllCourses();
		List<String> coursenames = new ArrayList<>();
		for(Course obj : courses)
		{
			coursenames.add(obj.getCoursename());
		}
		return new ResponseEntity<List<String>>(coursenames, HttpStatus.OK);
	}
	
	public String getNewID()
	{
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"0123456789"+"abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 12; i++) 
        {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
	}
	
	@GetMapping("/download")
	public ResponseEntity<Resource> downloadProfessorData() throws IOException {
	    List<Professor> professors = professorService.getAllProfessors();
	    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	    // create the workbook and populate with professor data
	    XSSFWorkbook workbook = professorService.createExcelSheet(professors);
	    workbook.write(outputStream);

	    // convert workbook to a byte array resource
	    ByteArrayResource resource = new ByteArrayResource(outputStream.toByteArray());

	    // create the ResponseEntity with the byte array resource as content
	    HttpHeaders headers = new HttpHeaders();
	    headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=professors.xlsx");

	    return ResponseEntity.ok()
	            .headers(headers)
	            .contentLength(resource.contentLength())
	            .contentType(MediaType.parseMediaType("application/octet-stream"))
	            .body(resource);
	}
}
