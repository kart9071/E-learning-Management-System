package com.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.model.Video;


public interface VideoRepository extends JpaRepository<Video, Long> {
}
