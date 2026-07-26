package com.edtech.modules.partner.service;

import com.edtech.common.exception.ResourceNotFoundException;
import com.edtech.modules.media.entity.Media;
import com.edtech.modules.media.mapper.MediaMapper;
import com.edtech.modules.media.repository.MediaRepository;
import com.edtech.modules.partner.dto.PartnerRequest;
import com.edtech.modules.partner.dto.PartnerResponse;
import com.edtech.modules.partner.entity.Partner;
import com.edtech.modules.partner.mapper.PartnerMapper;
import com.edtech.modules.partner.repository.PartnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartnerServiceImpl implements PartnerService {

    private final PartnerRepository partnerRepository;
    private final PartnerMapper partnerMapper;
    private final MediaRepository mediaRepository;
    private final MediaMapper mediaMapper;

    @Override
    public List<PartnerResponse> getAllPartners() {

        return partnerRepository.findAll()
                .stream()
                .map(this::buildPartnerResponse)
                .toList();
    }

    @Override
    public List<PartnerResponse> getActivePartners() {

        return partnerRepository.findByIsActiveTrueOrderByDisplayOrderAsc()
                .stream()
                .map(this::buildPartnerResponse)
                .toList();
    }

    @Override
    public PartnerResponse createPartner(PartnerRequest request) {

        Partner partner = partnerMapper.toEntity(request);

        if (request.getLogoId() != null) {

            Media logo = mediaRepository.findById(request.getLogoId())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Logo not found"));

            partner.setLogo(logo);
        }

        Partner savedPartner = partnerRepository.save(partner);

        return buildPartnerResponse(savedPartner);
    }

    @Override
    public PartnerResponse updatePartner(
            Long id,
            PartnerRequest request
    ) {

        Partner partner = partnerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Partner not found"));

        partner.setName(request.getName());
        partner.setWebsiteUrl(request.getWebsiteUrl());
        partner.setDisplayOrder(request.getDisplayOrder());
        partner.setIsActive(request.getIsActive());

        if (request.getLogoId() != null) {

            Media logo = mediaRepository.findById(request.getLogoId())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Logo not found"));

            partner.setLogo(logo);
        }

        Partner updatedPartner = partnerRepository.save(partner);

        return buildPartnerResponse(updatedPartner);
    }

    @Override
    public void deletePartner(Long id) {

        Partner partner = partnerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Partner not found"));

        partnerRepository.delete(partner);
    }

    private PartnerResponse buildPartnerResponse(Partner partner) {

        PartnerResponse response = partnerMapper.toResponse(partner);

        if (partner.getLogo() != null) {
            response.setLogo(
                    mediaMapper.toResponse(partner.getLogo())
            );
        }

        return response;
    }
}