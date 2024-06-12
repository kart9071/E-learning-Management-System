package com.application.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.application.model.Chapter;
import com.application.repository.ChapterRepository;
import com.application.model.chapter_1;

@Service
public class ChapterService 
{
	@Autowired
	private ChapterRepository chapterRepo;
	
	@PersistenceContext
	private EntityManager entityManager;
	public Chapter saveChapter(Chapter chapter)
	{
		return chapterRepo.save(chapter);
	}
//	public List<Chapter> getChaptersByVideoId(Integer videoId) {
//        return chapterRepo.findByVideoId(videoId);
//    }
//	
	public Chapter addNewChapter(Chapter chapter)
	{
		return chapterRepo.save(chapter);
	}
	
	public List<Chapter> getAllChapters()
	{
		return (List<Chapter>)chapterRepo.findAll();
	}
	
	public List<Chapter> fetchByCoursename(String coursename)
	{
		return (List<Chapter>)chapterRepo.findByCoursename(coursename);
	}
	public Chapter getChapterByIdAndChapterName(Integer id, String chapterName) {
	    return chapterRepo.findById(id)
	            .filter(chapter -> {
	                switch(chapterName.toLowerCase()) {
	                    case "chapter1":
	                        return chapter.getChapter1name().equalsIgnoreCase(chapterName);
	                    case "chapter2":
	                        return chapter.getChapter2name().equalsIgnoreCase(chapterName);
	                    case "chapter3":
	                        return chapter.getChapter3name().equalsIgnoreCase(chapterName);
	                    case "chapter4":
	                        return chapter.getChapter4name().equalsIgnoreCase(chapterName);
	                    case "chapter5":
	                        return chapter.getChapter5name().equalsIgnoreCase(chapterName);
	                    case "chapter6":
	                        return chapter.getChapter6name().equalsIgnoreCase(chapterName);
	                    case "chapter7":
	                        return chapter.getChapter7name().equalsIgnoreCase(chapterName);
	                    case "chapter8":
	                        return chapter.getChapter8name().equalsIgnoreCase(chapterName);
	                    default:
	                        return false;
	                }
	            })
	            .orElse(null);
	}
	public List<Chapter> fetchByCoursename1(String coursename) {
		 final Logger logger = LogManager.getLogger(ChapterService.class);
	    logger.info("Fetching chapters for coursename: {}", coursename);
	    List<Chapter> chapters = new ArrayList<>();
	    try {
	        chapters = chapterRepo.findByCoursename(coursename);
	        logger.info("Found {} chapters for coursename: {}", chapters.size(), coursename);
	    } catch (Exception e) {
	        logger.error("Error fetching chapters for coursename: {}", coursename, e);
	    }
	    return chapters;
	}

	public void saveVideos(List<MultipartFile> files,String coursename) throws IOException {
	    Chapter video = new Chapter();
	    video.setCoursename(coursename);
	    
	    for(int i=0; i<files.size(); i++) {
	        String fieldName = "chapter" + (i+1);
	        String fileName =  files.get(i).getOriginalFilename();
	        byte[] fileData = files.get(i).getBytes();
	        
	        try {
	            Field nameField = video.getClass().getDeclaredField(fieldName + "name");
	            nameField.setAccessible(true);
	            nameField.set(video, fileName);
	            
	            Field dataField = video.getClass().getDeclaredField(fieldName + "id");
	            dataField.setAccessible(true);
	            dataField.set(video, fileData);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
	        }
	    }
	    
	    chapterRepo.save(video);
}

	public Chapter getChapterById(Integer id) {
        return chapterRepo.findById(id).orElse(null);
    }
	


	public Resource getVideoById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	    private final ResourceLoader resourceLoader;
	    
	    public ChapterService(ResourceLoader resourceLoader) {
	        this.resourceLoader = resourceLoader;
	    }
	    
	    public Resource getVideoResourceById(String id) {
	        return (Resource) resourceLoader.getResource("classpath:static/videos/" + id);
	    }

		public Chapter getChapterById(int courseId, int chapterId) {
			// TODO Auto-generated method stub
			return chapterRepo.findById(courseId).orElse(null);
		}

		public Chapter getChapterByCourseIdAndChapterName(Integer courseId, String chapterName) {
			// TODO Auto-generated method stub
			return chapterRepo.findById(courseId).orElse(null);
		}
	
	
}