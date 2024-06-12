package com.application.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.application.model.Video;
import com.application.repository.VideoRepository;
import com.application.services.VideoService;


@RestController
@RequestMapping("/api/videos")
public class VideoController {
   @Autowired
   private VideoService videoService;
   
   @Autowired
   private VideoRepository videoRepo;
   
   @PostMapping("/upload")
   public void uploadVideo(@RequestParam("file") MultipartFile file) throws IOException {
       videoService.saveVideo(file);
   }
   
   @CrossOrigin(origins = "*")
   @GetMapping("/{id}")
   public ResponseEntity<byte[]> getVideoById(@PathVariable Long id) {
       Video video = videoService.getVideoById(id);
       HttpHeaders headers = new HttpHeaders();
       headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
       headers.setContentDispositionFormData(video.getName(), video.getName());
       return new ResponseEntity<>(video.getData(), headers, HttpStatus.OK);
   }
   
//   @GetMapping("/")
//   public List<Video> getAllVideos() {
//       return videoRepo.findAll();
//   }
}
