package com.edtech.modules.partner.mapper;

import com.edtech.modules.partner.dto.PartnerRequest;
import com.edtech.modules.partner.dto.PartnerResponse;
import com.edtech.modules.partner.entity.Partner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PartnerMapper {

    @Mapping(target = "logo", ignore = true)
    Partner toEntity(PartnerRequest request);

    @Mapping(target = "logo", ignore = true)
    PartnerResponse toResponse(Partner partner);

}