package com.edtech.modules.enquiry.controller;

import com.edtech.common.dto.ApiResponse;
import com.edtech.modules.enquiry.dto.EnquiryRequest;
import com.edtech.modules.enquiry.dto.EnquiryResponse;
import com.edtech.modules.enquiry.service.EnquiryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EnquiryController {

    private final EnquiryService enquiryService;

    @PostMapping("/public/enquiries")
    public ApiResponse<EnquiryResponse> createEnquiry(
            @Valid @RequestBody EnquiryRequest request
    ) {

        return ApiResponse.<EnquiryResponse>builder()
                .success(true)
                .message("Enquiry submitted successfully")
                .data(enquiryService.createEnquiry(request))
                .build();
    }
    //should be admin route
    @GetMapping("/admin/enquiries")
    public ApiResponse<List<EnquiryResponse>> getAllEnquiries() {

        return ApiResponse.<List<EnquiryResponse>>builder()
                .success(true)
                .message("Enquiries fetched successfully")
                .data(enquiryService.getAllEnquiries())
                .build();
    }
//should be admin route
    @GetMapping("/admin/enquiries/{id}")
    public ApiResponse<EnquiryResponse> getEnquiryById(
            @PathVariable Long id
    ) {

        return ApiResponse.<EnquiryResponse>builder()
                .success(true)
                .message("Enquiry fetched successfully")
                .data(enquiryService.getEnquiryById(id))
                .build();
    }
}