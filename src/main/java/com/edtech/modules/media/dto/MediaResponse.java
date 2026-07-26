package com.edtech.modules.media.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MediaResponse {

    private Long id;

    private String fileName;

    private String originalFileName;

    private String contentType;

    private Long fileSize;

    private String fileUrl;
}