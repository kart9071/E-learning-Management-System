
package com.application.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

import com.application.model.Chapter;

public interface ChapterRepository extends CrudRepository<Chapter, Integer>
{
	@Query("SELECT c FROM Chapter c WHERE LOWER(c.coursename) = LOWER(:coursename)")

	public List<Chapter> findByCoursename(String coursename);

	public Chapter getChapterById(int id);

	public Optional<Chapter> findById(Long chapterid);
}
//package com.application.repository;
//
//import org.springframework.data.repository.CrudRepository;
//import java.util.List;
//import com.application.model.Chapter;
//
//
//public interface ChapterRepository extends CrudRepository<Chapter, Integer>
//{
//	public List<Chapter> findByCoursename(String Coursename);
//
//	public List<Chapter> findByVideoId(Integer videoId);
//	
//}