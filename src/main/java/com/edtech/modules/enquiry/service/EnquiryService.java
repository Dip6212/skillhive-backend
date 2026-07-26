package com.edtech.modules.enquiry.service;

import com.edtech.modules.enquiry.dto.EnquiryRequest;
import com.edtech.modules.enquiry.dto.EnquiryResponse;

import java.util.List;

public interface EnquiryService {

    EnquiryResponse createEnquiry(EnquiryRequest request);

    List<EnquiryResponse> getAllEnquiries();

    EnquiryResponse getEnquiryById(Long id);

}