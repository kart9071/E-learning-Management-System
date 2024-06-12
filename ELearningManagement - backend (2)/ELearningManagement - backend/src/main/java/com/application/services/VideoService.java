package com.application.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.application.model.Video;
import com.application.repository.VideoRepository;


@Service
public class VideoService {
   @Autowired
   private VideoRepository videoRepository;
   public void saveVideo(MultipartFile file) throws IOException {
       Video video = new Video();
       video.setName(file.getOriginalFilename());
       video.setData(file.getBytes());
       videoRepository.save(video);
   }
   public Video getVideoById(Long id) {
       return videoRepository.findById(id).orElse(null);
   }
}
