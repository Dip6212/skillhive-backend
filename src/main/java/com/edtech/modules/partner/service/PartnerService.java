package com.edtech.modules.partner.service;

import com.edtech.modules.partner.dto.PartnerRequest;
import com.edtech.modules.partner.dto.PartnerResponse;

import java.util.List;

public interface PartnerService {

    List<PartnerResponse> getAllPartners();

    List<PartnerResponse> getActivePartners();

    PartnerResponse createPartner(PartnerRequest request);

    PartnerResponse updatePartner(Long id, PartnerRequest request);

    void deletePartner(Long id);

}