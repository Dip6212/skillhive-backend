package com.edtech.modules.media.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.edtech.common.exception.ResourceNotFoundException;
import com.edtech.modules.media.dto.MediaResponse;
import com.edtech.modules.media.entity.Media;
import com.edtech.modules.media.mapper.MediaMapper;
import com.edtech.modules.media.repository.MediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MediaServiceImpl implements MediaService {

    private final MediaRepository mediaRepository;
    private final MediaMapper mediaMapper;
    private final Cloudinary cloudinary;

    @Override
    public MediaResponse upload(MultipartFile file) {

        if (file.isEmpty()) {
            throw new RuntimeException("File is empty");
        }

        try {

            Map<?, ?> uploadResult = cloudinary.uploader().upload(
                    file.getBytes(),
                    ObjectUtils.emptyMap()
            );

            String secureUrl = uploadResult.get("secure_url").toString();
            String publicId = uploadResult.get("public_id").toString();

            Media media = Media.builder()
                    .fileName(publicId)
                    .originalFileName(file.getOriginalFilename())
                    .contentType(file.getContentType())
                    .fileSize(file.getSize())
                    .storagePath(publicId)
                    .fileUrl(secureUrl)
                    .uploadedBy(null)
                    .build();

            Media savedMedia = mediaRepository.save(media);

            return mediaMapper.toResponse(savedMedia);

        } catch (IOException e) {
            throw new RuntimeException("Failed to upload image to Cloudinary", e);
        }
    }

    @Override
    public void delete(Long id) {

        Media media = mediaRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Media not found"));

        try {

            cloudinary.uploader().destroy(
                    media.getStoragePath(),
                    ObjectUtils.emptyMap()
            );

            mediaRepository.delete(media);

        } catch (IOException e) {
            throw new RuntimeException("Failed to delete image from Cloudinary", e);
        }
    }

    @Override
    public MediaResponse getById(Long id) {

        Media media = mediaRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Media not found"));

        return mediaMapper.toResponse(media);
    }

    @Override
    public List<MediaResponse> getAll() {

        return mediaRepository.findAll()
                .stream()
                .map(mediaMapper::toResponse)
                .toList();
    }
}