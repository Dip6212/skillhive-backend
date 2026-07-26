package com.edtech.modules.faq.mapper;

import com.edtech.modules.faq.dto.FaqRequest;
import com.edtech.modules.faq.dto.FaqResponse;
import com.edtech.modules.faq.entity.Faq;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FaqMapper {

    Faq toEntity(FaqRequest request);

    FaqResponse toResponse(Faq faq);

}