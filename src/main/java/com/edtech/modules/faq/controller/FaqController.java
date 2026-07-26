package com.edtech.modules.faq.controller;

import com.edtech.common.dto.ApiResponse;
import com.edtech.modules.faq.dto.FaqRequest;
import com.edtech.modules.faq.dto.FaqResponse;
import com.edtech.modules.faq.service.FaqService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FaqController {

    private final FaqService faqService;

    @GetMapping("/public/faqs")
    public ApiResponse<List<FaqResponse>> getFaqs() {

        return ApiResponse.<List<FaqResponse>>builder()
                .success(true)
                .message("FAQs fetched successfully")
                .data(faqService.getActiveFaqs())
                .build();
    }

    @GetMapping("/admin/faqs")
    public ApiResponse<List<FaqResponse>> getAllFaqs() {

        return ApiResponse.<List<FaqResponse>>builder()
                .success(true)
                .message("FAQs fetched successfully")
                .data(faqService.getAllFaqs())
                .build();
    }

    @PostMapping("/admin/faqs")
    public ApiResponse<FaqResponse> createFaq(
            @Valid @RequestBody FaqRequest request
    ) {

        return ApiResponse.<FaqResponse>builder()
                .success(true)
                .message("FAQ created successfully")
                .data(faqService.createFaq(request))
                .build();
    }

    @PutMapping("/admin/faqs/{id}")
    public ApiResponse<FaqResponse> updateFaq(
            @PathVariable Long id,
            @Valid @RequestBody FaqRequest request
    ) {

        return ApiResponse.<FaqResponse>builder()
                .success(true)
                .message("FAQ updated successfully")
                .data(faqService.updateFaq(id, request))
                .build();
    }

    @DeleteMapping("/admin/faqs/{id}")
    public ApiResponse<Void> deleteFaq(
            @PathVariable Long id
    ) {

        faqService.deleteFaq(id);

        return ApiResponse.<Void>builder()
                .success(true)
                .message("FAQ deleted successfully")
                .build();
    }
}