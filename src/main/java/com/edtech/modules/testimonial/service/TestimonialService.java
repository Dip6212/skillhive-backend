package com.edtech.modules.testimonial.service;

import com.edtech.modules.testimonial.dto.TestimonialRequest;
import com.edtech.modules.testimonial.dto.TestimonialResponse;

import java.util.List;

public interface TestimonialService {

    List<TestimonialResponse> getAllTestimonials();

    List<TestimonialResponse> getActiveTestimonials();

    TestimonialResponse createTestimonial(TestimonialRequest request);

    TestimonialResponse updateTestimonial(Long id, TestimonialRequest request);

    void deleteTestimonial(Long id);

}