package com.edtech.modules.hero.service;

import com.edtech.common.exception.BadRequestException;
import com.edtech.common.exception.ResourceNotFoundException;
import com.edtech.modules.hero.dto.HeroRequest;
import com.edtech.modules.hero.dto.HeroResponse;
import com.edtech.modules.hero.entity.Hero;
import com.edtech.modules.hero.mapper.HeroMapper;
import com.edtech.modules.hero.repository.HeroRepository;
import com.edtech.modules.media.entity.Media;
import com.edtech.modules.media.mapper.MediaMapper;
import com.edtech.modules.media.repository.MediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeroServiceImpl implements HeroService {

    private final HeroRepository heroRepository;
    private final HeroMapper heroMapper;
    private final MediaRepository mediaRepository;

    private final MediaMapper mediaMapper;

    @Override
    public HeroResponse getActiveHero() {

        Hero hero = heroRepository.findByIsActiveTrue()
                .orElseThrow(() ->
                        new ResourceNotFoundException("Hero not found"));

        HeroResponse response = heroMapper.toResponse(hero);

        if (hero.getHeroImage() != null) {
            response.setHeroImage(
                    mediaMapper.toResponse(hero.getHeroImage())
            );
        }

        if (hero.getBackgroundImage() != null) {
            response.setBackgroundImage(
                    mediaMapper.toResponse(hero.getBackgroundImage())
            );
        }

        return response;
    }

    @Override
    public List<HeroResponse> getAllHeroes() {

        return heroRepository.findAll()
                .stream()
                .map(heroMapper::toResponse)
                .toList();
    }

    @Override
    public HeroResponse createHero(HeroRequest request) {

        if (Boolean.TRUE.equals(request.getIsActive())) {

            heroRepository.findByIsActiveTrue()
                    .ifPresent(activeHero -> {
                        activeHero.setIsActive(false);
                        heroRepository.save(activeHero);
                    });
        }

        Hero hero = heroMapper.toEntity(request);

        if (request.getHeroImageId() != null) {

            Media heroImage = mediaRepository.findById(request.getHeroImageId())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Hero image not found"));

            hero.setHeroImage(heroImage);
        }

        if (request.getBackgroundImageId() != null) {

            Media backgroundImage = mediaRepository.findById(request.getBackgroundImageId())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Background image not found"));

            hero.setBackgroundImage(backgroundImage);
        }

        Hero savedHero = heroRepository.save(hero);

        return buildHeroResponse(savedHero);
    }

    @Override
    public HeroResponse updateHero(
            Long id,
            HeroRequest request
    ) {

        Hero hero = heroRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Hero not found"));

        // Handle active hero first
        if (Boolean.TRUE.equals(request.getIsActive())) {

            heroRepository.findByIsActiveTrue()
                    .ifPresent(activeHero -> {

                        if (!activeHero.getId().equals(hero.getId())) {
                            activeHero.setIsActive(false);
                            heroRepository.save(activeHero);
                        }
                    });
        }

        hero.setTitle(request.getTitle());
        hero.setSubtitle(request.getSubtitle());
        hero.setDescription(request.getDescription());
        hero.setPrimaryButtonText(request.getPrimaryButtonText());
        hero.setPrimaryButtonLink(request.getPrimaryButtonLink());
        hero.setSecondaryButtonText(request.getSecondaryButtonText());
        hero.setSecondaryButtonLink(request.getSecondaryButtonLink());
        hero.setIsActive(request.getIsActive());

        if (request.getHeroImageId() != null) {

            Media heroImage = mediaRepository.findById(request.getHeroImageId())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Hero image not found"));

            hero.setHeroImage(heroImage);
        }

        if (request.getBackgroundImageId() != null) {

            Media backgroundImage = mediaRepository.findById(request.getBackgroundImageId())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Background image not found"));

            hero.setBackgroundImage(backgroundImage);
        }

        Hero updatedHero = heroRepository.save(hero);

        return buildHeroResponse(updatedHero);
    }

    @Override
    public void deleteHero(Long id) {

        Hero hero = heroRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Hero not found"));

        heroRepository.delete(hero);
    }

    private HeroResponse buildHeroResponse(Hero hero) {

        HeroResponse response = heroMapper.toResponse(hero);

        if (hero.getHeroImage() != null) {
            response.setHeroImage(
                    mediaMapper.toResponse(hero.getHeroImage())
            );
        }

        if (hero.getBackgroundImage() != null) {
            response.setBackgroundImage(
                    mediaMapper.toResponse(hero.getBackgroundImage())
            );
        }

        return response;
    }
}