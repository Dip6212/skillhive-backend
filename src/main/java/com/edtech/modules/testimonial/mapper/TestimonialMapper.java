package com.edtech.modules.testimonial.mapper;

import com.edtech.modules.testimonial.dto.TestimonialRequest;
import com.edtech.modules.testimonial.dto.TestimonialResponse;
import com.edtech.modules.testimonial.entity.Testimonial;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TestimonialMapper {

    @Mapping(target = "profileImage", ignore = true)
    Testimonial toEntity(TestimonialRequest request);

    @Mapping(target = "profileImage", ignore = true)
    TestimonialResponse toResponse(Testimonial testimonial);

}
