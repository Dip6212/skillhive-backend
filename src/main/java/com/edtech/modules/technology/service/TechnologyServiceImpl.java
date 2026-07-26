package com.edtech.modules.technology.service;

import com.edtech.common.exception.ResourceNotFoundException;
import com.edtech.modules.technology.dto.TechnologyRequest;
import com.edtech.modules.technology.dto.TechnologyResponse;
import com.edtech.modules.technology.entity.Technology;
import com.edtech.modules.technology.mapper.TechnologyMapper;
import com.edtech.modules.technology.repository.TechnologyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TechnologyServiceImpl implements TechnologyService {

    private final TechnologyRepository technologyRepository;
    private final TechnologyMapper technologyMapper;

    @Override
    public List<TechnologyResponse> getAllTechnologies() {

        return technologyRepository.findAll()
                .stream()
                .map(technologyMapper::toResponse)
                .toList();
    }

    @Override
    public List<TechnologyResponse> getActiveTechnologies() {

        return technologyRepository.findByIsActiveTrueOrderByDisplayOrderAsc()
                .stream()
                .map(technologyMapper::toResponse)
                .toList();
    }

    @Override
    public TechnologyResponse createTechnology(
            TechnologyRequest request
    ) {

        Technology technology = technologyMapper.toEntity(request);

        Technology savedTechnology =
                technologyRepository.save(technology);

        return technologyMapper.toResponse(savedTechnology);
    }

    @Override
    public TechnologyResponse updateTechnology(
            Long id,
            TechnologyRequest request
    ) {

        Technology technology = technologyRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Technology not found")
                );

        technology.setName(request.getName());
        technology.setIconUrl(request.getIconUrl());
        technology.setDisplayOrder(request.getDisplayOrder());
        technology.setIsActive(request.getIsActive());

        Technology updatedTechnology =
                technologyRepository.save(technology);

        return technologyMapper.toResponse(updatedTechnology);
    }

    @Override
    public void deleteTechnology(Long id) {

        Technology technology = technologyRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Technology not found")
                );

        technologyRepository.delete(technology);
    }
}