package com.edtech.modules.media.service;

import com.edtech.modules.media.dto.MediaResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MediaService {

    MediaResponse upload(MultipartFile file);

    void delete(Long id);

    MediaResponse getById(Long id);

    List<MediaResponse> getAll();

}
