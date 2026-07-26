package com.edtech.modules.media.repository;

import com.edtech.modules.media.entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MediaRepository extends JpaRepository<Media, Long> {

    List<Media> findTop5ByOrderByCreatedAtDesc();

}