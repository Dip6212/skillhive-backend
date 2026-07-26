package com.edtech.modules.media.controller;

import com.edtech.common.dto.ApiResponse;
import com.edtech.modules.media.dto.MediaResponse;
import com.edtech.modules.media.service.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestPart;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MediaController {

    private final MediaService mediaService;

    @PostMapping(
            value = "/admin/media/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ApiResponse<MediaResponse> upload(
            @RequestPart("file") MultipartFile file
    ) {

        return ApiResponse.<MediaResponse>builder()
                .success(true)
                .message("File uploaded successfully")
                .data(mediaService.upload(file))
                .build();
    }

    @GetMapping("/public/media/{id}")
    public ApiResponse<MediaResponse> getMedia(
            @PathVariable Long id
    ) {

        return ApiResponse.<MediaResponse>builder()
                .success(true)
                .message("Media fetched successfully")
                .data(mediaService.getById(id))
                .build();
    }

    @DeleteMapping("/admin/media/{id}")
    public ApiResponse<Void> deleteMedia(
            @PathVariable Long id
    ) {

        mediaService.delete(id);

        return ApiResponse.<Void>builder()
                .success(true)
                .message("Media deleted successfully")
                .build();
    }

    @GetMapping("/admin/media")
    public ApiResponse<List<MediaResponse>> getAllMedia() {

        return ApiResponse.<List<MediaResponse>>builder()
                .success(true)
                .message("Media fetched successfully")
                .data(mediaService.getAll())
                .build();
    }
}