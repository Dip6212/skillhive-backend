package com.edtech.modules.hero.service;

import com.edtech.modules.hero.dto.HeroRequest;
import com.edtech.modules.hero.dto.HeroResponse;

import java.util.List;

public interface HeroService {

    HeroResponse getActiveHero();

    List<HeroResponse> getAllHeroes();

    HeroResponse createHero(HeroRequest request);

    HeroResponse updateHero(Long id, HeroRequest request);

    void deleteHero(Long id);
}