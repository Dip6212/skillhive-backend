package com.edtech.modules.media.mapper;

import com.edtech.modules.media.dto.MediaResponse;
import com.edtech.modules.media.entity.Media;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MediaMapper {

    MediaResponse toResponse(Media media);

}