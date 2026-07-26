package com.edtech.modules.partner.controller;

import com.edtech.common.dto.ApiResponse;
import com.edtech.modules.partner.dto.PartnerRequest;
import com.edtech.modules.partner.dto.PartnerResponse;
import com.edtech.modules.partner.service.PartnerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PartnerController {

    private final PartnerService partnerService;

    @GetMapping("/public/partners")
    public ApiResponse<List<PartnerResponse>> getPartners() {

        return ApiResponse.<List<PartnerResponse>>builder()
                .success(true)
                .message("Partners fetched successfully")
                .data(partnerService.getActivePartners())
                .build();
    }

    @GetMapping("/admin/partners")
    public ApiResponse<List<PartnerResponse>> getAllPartners() {

        return ApiResponse.<List<PartnerResponse>>builder()
                .success(true)
                .message("Partners fetched successfully")
                .data(partnerService.getAllPartners())
                .build();
    }

    @PostMapping("/admin/partners")
    public ApiResponse<PartnerResponse> createPartner(
            @Valid @RequestBody PartnerRequest request
    ) {

        return ApiResponse.<PartnerResponse>builder()
                .success(true)
                .message("Partner created successfully")
                .data(partnerService.createPartner(request))
                .build();
    }

    @PutMapping("/admin/partners/{id}")
    public ApiResponse<PartnerResponse> updatePartner(
            @PathVariable Long id,
            @Valid @RequestBody PartnerRequest request
    ) {

        return ApiResponse.<PartnerResponse>builder()
                .success(true)
                .message("Partner updated successfully")
                .data(partnerService.updatePartner(id, request))
                .build();
    }

    @DeleteMapping("/admin/partners/{id}")
    public ApiResponse<Void> deletePartner(
            @PathVariable Long id
    ) {

        partnerService.deletePartner(id);

        return ApiResponse.<Void>builder()
                .success(true)
                .message("Partner deleted successfully")
                .build();
    }
}