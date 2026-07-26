package com.edtech.modules.testimonial.controller;

import com.edtech.common.dto.ApiResponse;
import com.edtech.modules.testimonial.dto.TestimonialRequest;
import com.edtech.modules.testimonial.dto.TestimonialResponse;
import com.edtech.modules.testimonial.service.TestimonialService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TestimonialController {

    private final TestimonialService testimonialService;

    @GetMapping("/public/testimonials")
    public ApiResponse<List<TestimonialResponse>> getTestimonials() {

        return ApiResponse.<List<TestimonialResponse>>builder()
                .success(true)
                .message("Testimonials fetched successfully")
                .data(testimonialService.getActiveTestimonials())
                .build();
    }

    @GetMapping("/admin/testimonials")
    public ApiResponse<List<TestimonialResponse>> getAllTestimonials() {

        return ApiResponse.<List<TestimonialResponse>>builder()
                .success(true)
                .message("Testimonials fetched successfully")
                .data(testimonialService.getAllTestimonials())
                .build();
    }

    @PostMapping("/admin/testimonials")
    public ApiResponse<TestimonialResponse> createTestimonial(
            @Valid @RequestBody TestimonialRequest request
    ) {

        return ApiResponse.<TestimonialResponse>builder()
                .success(true)
                .message("Testimonial created successfully")
                .data(testimonialService.createTestimonial(request))
                .build();
    }

    @PutMapping("/admin/testimonials/{id}")
    public ApiResponse<TestimonialResponse> updateTestimonial(
            @PathVariable Long id,
            @Valid @RequestBody TestimonialRequest request
    ) {

        return ApiResponse.<TestimonialResponse>builder()
                .success(true)
                .message("Testimonial updated successfully")
                .data(testimonialService.updateTestimonial(id, request))
                .build();
    }

    @DeleteMapping("/admin/testimonials/{id}")
    public ApiResponse<Void> deleteTestimonial(
            @PathVariable Long id
    ) {

        testimonialService.deleteTestimonial(id);

        return ApiResponse.<Void>builder()
                .success(true)
                .message("Testimonial deleted successfully")
                .build();
    }
}