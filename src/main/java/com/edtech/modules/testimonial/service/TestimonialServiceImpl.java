package com.edtech.modules.testimonial.service;

import com.edtech.common.exception.ResourceNotFoundException;
import com.edtech.modules.media.entity.Media;
import com.edtech.modules.media.mapper.MediaMapper;
import com.edtech.modules.media.repository.MediaRepository;
import com.edtech.modules.testimonial.dto.TestimonialRequest;
import com.edtech.modules.testimonial.dto.TestimonialResponse;
import com.edtech.modules.testimonial.entity.Testimonial;
import com.edtech.modules.testimonial.mapper.TestimonialMapper;
import com.edtech.modules.testimonial.repository.TestimonialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestimonialServiceImpl implements TestimonialService {

    private final TestimonialRepository testimonialRepository;
    private final TestimonialMapper testimonialMapper;
    private final MediaRepository mediaRepository;
    private final MediaMapper mediaMapper;

    @Override
    public List<TestimonialResponse> getAllTestimonials() {

        return testimonialRepository.findAll()
                .stream()
                .map(this::buildResponse)
                .toList();
    }

    @Override
    public List<TestimonialResponse> getActiveTestimonials() {

        return testimonialRepository.findByIsActiveTrueOrderByDisplayOrderAsc()
                .stream()
                .map(this::buildResponse)
                .toList();
    }

    @Override
    public TestimonialResponse createTestimonial(TestimonialRequest request) {

        Testimonial testimonial = testimonialMapper.toEntity(request);

        if (request.getProfileImageId() != null) {

            Media profileImage = mediaRepository.findById(request.getProfileImageId())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Profile image not found"));

            testimonial.setProfileImage(profileImage);
        }

        Testimonial saved = testimonialRepository.save(testimonial);

        return buildResponse(saved);
    }

    @Override
    public TestimonialResponse updateTestimonial(
            Long id,
            TestimonialRequest request
    ) {

        Testimonial testimonial = testimonialRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Testimonial not found"));

        testimonial.setName(request.getName());
        testimonial.setDesignation(request.getDesignation());
        testimonial.setCompany(request.getCompany());
        testimonial.setReview(request.getReview());
        testimonial.setRating(request.getRating());
        testimonial.setDisplayOrder(request.getDisplayOrder());
        testimonial.setIsActive(request.getIsActive());

        if (request.getProfileImageId() != null) {

            Media profileImage = mediaRepository.findById(request.getProfileImageId())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Profile image not found"));

            testimonial.setProfileImage(profileImage);
        }

        Testimonial updated = testimonialRepository.save(testimonial);

        return buildResponse(updated);
    }

    @Override
    public void deleteTestimonial(Long id) {

        Testimonial testimonial = testimonialRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Testimonial not found"));

        testimonialRepository.delete(testimonial);
    }

    private TestimonialResponse buildResponse(Testimonial testimonial) {

        TestimonialResponse response =
                testimonialMapper.toResponse(testimonial);

        if (testimonial.getProfileImage() != null) {
            response.setProfileImage(
                    mediaMapper.toResponse(testimonial.getProfileImage())
            );
        }

        return response;
    }
}