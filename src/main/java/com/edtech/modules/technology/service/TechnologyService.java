package com.edtech.modules.technology.service;

import com.edtech.modules.technology.dto.TechnologyRequest;
import com.edtech.modules.technology.dto.TechnologyResponse;

import java.util.List;

public interface TechnologyService {

    List<TechnologyResponse> getAllTechnologies();

    List<TechnologyResponse> getActiveTechnologies();

    TechnologyResponse createTechnology(TechnologyRequest request);

    TechnologyResponse updateTechnology(
            Long id,
            TechnologyRequest request
    );

    void deleteTechnology(Long id);
}