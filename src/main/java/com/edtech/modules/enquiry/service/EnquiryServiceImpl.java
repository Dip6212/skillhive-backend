package com.edtech.modules.enquiry.service;

import com.edtech.common.exception.ResourceNotFoundException;
import com.edtech.modules.enquiry.dto.EnquiryRequest;
import com.edtech.modules.enquiry.dto.EnquiryResponse;
import com.edtech.modules.enquiry.entity.Enquiry;
import com.edtech.modules.enquiry.mapper.EnquiryMapper;
import com.edtech.modules.enquiry.repository.EnquiryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EnquiryServiceImpl implements EnquiryService {

    private final EnquiryRepository enquiryRepository;

    private final EnquiryMapper enquiryMapper;

    @Override
    public EnquiryResponse createEnquiry(EnquiryRequest request) {

        Enquiry enquiry = enquiryMapper.toEntity(request);

        enquiry.setStatus("NEW");

        enquiry.setCreatedAt(LocalDateTime.now());

        Enquiry saved = enquiryRepository.save(enquiry);

        return enquiryMapper.toResponse(saved);
    }

    @Override
    public List<EnquiryResponse> getAllEnquiries() {

        return enquiryRepository
                .findAll()
                .stream()
                .map(enquiryMapper::toResponse)
                .toList();
    }

    @Override
    public EnquiryResponse getEnquiryById(Long id) {

        Enquiry enquiry = enquiryRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Enquiry not found"
                        )
                );

        return enquiryMapper.toResponse(enquiry);
    }
}