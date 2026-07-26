package com.edtech.modules.enquiry.mapper;

import com.edtech.modules.enquiry.dto.EnquiryRequest;
import com.edtech.modules.enquiry.dto.EnquiryResponse;
import com.edtech.modules.enquiry.entity.Enquiry;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnquiryMapper {

    Enquiry toEntity(EnquiryRequest request);

    EnquiryResponse toResponse(Enquiry enquiry);
}